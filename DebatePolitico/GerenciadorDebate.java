import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerenciadorDebate implements Mediador{
    protected List<Candidato> candidatos;
    private Candidato inquiridor;
    private Candidato inquirido;

    private Cronometro cronometro;
    protected Logger logger;
    private String faseAtual;

    private Random randomizador;

    public GerenciadorDebate(){
        // atributos necessarios/obrigatorios para o gerenciador funcionar
        this.cronometro = new Cronometro();
        this.logger = new Logger();
        this.randomizador = new Random();
        this.candidatos = new ArrayList<>();
        this.cronometro.setMediador(this);


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

        int quantidade = disponiveis.size() - 1;
        int indice = randomizador.nextInt(0, quantidade);

        this.inquiridor = disponiveis.get(indice);
        this.inquiridor.marcarComoInquiridor();

        logger.registrar("Inquiridor sorteado: " + this.inquiridor.getNome());

    }

    public String definirInquirido(int id){
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

        logger.registrar("Fase iniciada: " + this.faseAtual);
    }

    public void proximaAcao(){
        if(this.faseAtual.equals("PERGUNTA")){
            this.faseAtual = "RESPOSTA";
            iniciarFase(120);
        } else if (this.faseAtual.equals("RESPOSTA")) {
            this.faseAtual = "REPLICA";
            iniciarFase(180);
        } else if (this.faseAtual.equals("REPLICA")) {
            this.faseAtual = "TREPLICA";
            iniciarFase(60);
        } else if (this.faseAtual.equals("TREPLICA")) {
            logger.registrar("Rodada finalizada");
        }
    }

    public void registrarAcao(String acao){
        logger.registrar(acao);
    }


}
