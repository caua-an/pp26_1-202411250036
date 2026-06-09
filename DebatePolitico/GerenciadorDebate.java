import java.util.*;
import java.util.concurrent.TimeUnit;

public class GerenciadorDebate implements Mediador{
    protected List<Candidato> candidatos;
    private Candidato inquiridor;
    private Candidato inquirido;

    private Cronometro cronometro;
    protected Logger logger;
    private String faseAtual;

    private Random randomizador;

    private Queue<Candidato> solicitacoesDR;
    private DebateState estadoatual;


    public GerenciadorDebate(){
        this.cronometro = new Cronometro();
        this.logger = new Logger();
        this.randomizador = new Random();
        this.candidatos = new ArrayList<>();
        this.cronometro.setMediador(this);
        this.solicitacoesDR = new LinkedList<>();
        this.estadoatual = new EstadoNormal();


    }
    public void sortearInquiridor(){
        if(this.faseAtual == null){
            this.faseAtual = "PERGUNTA";
        }

        List<Candidato> disponiveis = new ArrayList<>();

        for(Candidato c: candidatos){
            if(!c.getJaPerguntou()){
                disponiveis.add(c);
            }
        }

        if(disponiveis.isEmpty()){
            System.out.println("Todos ja foram inquiridores");
        }

        int indice = randomizador.nextInt(disponiveis.size());

        this.inquiridor = disponiveis.get(indice);
        this.inquiridor.marcarComoInquiridor();

        logger.registrar("Inquiridor sorteado: " + this.inquiridor.getNome());

    }

    public String definirInquirido(int id){
        if(this.inquiridor == null){
            return "Sorteie o inquiridor antes de definir o inquirido";
        }

        for(Candidato c : candidatos){
            if(c.getId() == id && c != this.inquiridor){
                this.inquirido = c;
                logger.registrar("Inquirido definido: " + this.inquirido.getNome());
                return null;
            }
        }

        return "Id do candidato inválido";
    }

    public void iniciarFase(int tempo){
        if(this.inquiridor == null || this.inquirido == null){
            logger.registrar("Erro: inquiridor e inquirido precisam estar definidos antes de iniciar a fase");
            return;
        }

        logger.registrar("Fase iniciada: " + this.faseAtual);

        if(this.faseAtual.equals("PERGUNTA") || this.faseAtual.equals("REPLICA")){
            inquiridor.notificarObservers();
            inquiridor.cand_mic.ligar();

            inquirido.cand_mic.desligar();
        }
        else if(this.faseAtual.equals("RESPOSTA") || this.faseAtual.equals("TREPLICA")){
            inquiridor.cand_mic.desligar();

            inquirido.notificarObservers();
            inquirido.cand_mic.ligar();
        }
        cronometro.iniciar(tempo);
    }

    public void proximaAcao(){
        if(this.faseAtual.equals("PERGUNTA")){
            this.faseAtual = "RESPOSTA";

        } else if (this.faseAtual.equals("RESPOSTA")) {
            this.faseAtual = "REPLICA";
        } else if (this.faseAtual.equals("REPLICA")) {
            this.faseAtual = "TREPLICA";

        } else if (this.faseAtual.equals("TREPLICA")) {
            logger.registrar("Rodada finalizada");
            estadoatual.passarRodada(this);
        }
    }

    public void registrarAcao(String acao){
        logger.registrar(acao);
    }

    public void vincularEleitor(Eleitor eleitor_p, Candidato candidato_p){
        candidato_p.adicionarObserver(eleitor_p);
    }

    public void desvincularEleitor(Eleitor eleitor_p, Candidato candidato_p){
        candidato_p.removerObserver(eleitor_p);
    }

    public void solicitarDR(Candidato candidato_p){
        // if para que o candidato não habilite o DR varias vezes
        if(!solicitacoesDR.contains(candidato_p)){
            solicitacoesDR.add(candidato_p);
        }

        logger.registrar(candidato_p.getNome() + " solicitou o Direito de Resposta");
    }

    public boolean possuiSolicitacoesDR(){
        if(solicitacoesDR.isEmpty()){
            return false;
        }

        return true;
    }

    public Queue<Candidato> getSolicitacoesDR() {
        return solicitacoesDR;
    }

    public void setEstadoatual(DebateState estadoatual) {
        this.estadoatual = estadoatual;
    }

    public void executarEstadoAtual(){
        estadoatual.passarRodada(this);
    }

    public void executarDR() {
        while(!solicitacoesDR.isEmpty()){
            // pega o primeiro candidato da fila
            Candidato candidato = solicitacoesDR.poll();

            logger.registrar("DR concedido para: "+ candidato.getNome());

            candidato.notificarObservers();
            candidato.cand_mic.ligar();

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            candidato.cand_mic.desligar();
        }
    }
}
