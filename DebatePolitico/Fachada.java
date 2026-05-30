import java.util.List;

public class Fachada {
    private static Fachada instance;
    private GerenciadorDebate gerenciador;

    private Fachada(){
        if(instance == null){
            gerenciador = new GerenciadorDebate();
        }
    }

    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
        }

        return  instance;
    }
    // mudança no parâmetro tempos[]
    public void configurarDebate(List<Candidato> candidatos){
        if(candidatos.isEmpty()){
            System.out.println("Erro: dados inválidos");
            return;
        }

        gerenciador.candidatos = candidatos;
    }

    public void sortearInquiridor(){
        gerenciador.sortearInquiridor();
    }

    public String definirInquirido(int idCandidato){
        return gerenciador.definirInquirido(idCandidato);
    }

    public void iniciarDebate(){
        if(gerenciador.candidatos.isEmpty()){
            System.out.println("Erro: debate não configurado");
            return;
        }

        gerenciador.registrarAcao("Debate iniciado");
        gerenciador.sortearInquiridor();
    }

    public void vincularEleitor(Eleitor e_p, Candidato cand_p){
        gerenciador.vincularEleitor(e_p, cand_p);
    }
    public void desvincularEleitor(Eleitor e_p, Candidato cand_p){
        gerenciador.desvincularEleitor(e_p, cand_p);
    }

    public void avancarEtapa(){
        gerenciador.proximaAcao();
    }
    public void iniciarFase(int tempo) {gerenciador.iniciarFase(tempo);}

    public void finalizarDebate(){
        gerenciador.registrarAcao("Debate finalizado");
        gerenciador.logger.gerarRelatorio();
    }
}
