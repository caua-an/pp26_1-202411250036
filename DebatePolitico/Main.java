import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    System.out.println("==================================");
    System.out.println("   SIMULADOR DE DEBATE POLITICO   ");
    System.out.println("==================================\n");

    Fachada fachada = Fachada.getInstance();

    // =========================
    // MICROFONES
    // =========================

    Microfone mic1 = new Microfone(1);
    Microfone mic2 = new Microfone(2);

    // =========================
    // CANDIDATOS
    // =========================

    Candidato candidato1 =
            new Candidato(1, "Carlos", mic1);

    Candidato candidato2 =
            new Candidato(2, "Marina", mic2);

    // =========================
    // ELEITORES
    // =========================

    // cria o eleitor prototipo a ser seguido
    Eleitor eleitor_base = new Eleitor("Modelo");
    // clona o modelo proto
    Eleitor e1 = eleitor_base.clonar_prot();
    Eleitor e2 = eleitor_base.clonar_prot();
    Eleitor e3 = eleitor_base.clonar_prot();
    // cria suas variantes
    e1.setNome("Maria");
    e2.setNome("Jonas");
    e3.setNome("Eduardo");

    // =========================
    // LISTA DE CANDIDATOS
    // =========================

    List<Candidato> candidatos =
            new ArrayList<>();

    candidatos.add(candidato1);
    candidatos.add(candidato2);

    // =========================
    // CONFIGURAR DEBATE
    // =========================

    fachada.configurarDebate(candidatos);

    System.out.println("Debate configurado com sucesso.\n");


    System.out.println("\n==================================");
    System.out.println("      INICIANDO O DEBATE");
    System.out.println("==================================\n");

    // =========================
    // INICIA DEBATE
    // =========================
    fachada.vincularEleitor(e1, candidato1);
    fachada.vincularEleitor(e2, candidato1);
    fachada.vincularEleitor(e3, candidato2);

    fachada.iniciarDebate();
    String erro = fachada.definirInquirido(2);

    if(erro != null){
        erro = fachada.definirInquirido(1);
    }

    if(erro != null){
        System.out.println(erro);
    } else {
        // inicia fase pergunta
        fachada.iniciarFase(10);
        // inicia fase resposta
        fachada.iniciarFase(10);
        // inicia fase replica
        fachada.iniciarFase(10);
        // inicia fase treplica
        fachada.iniciarFase(10);
    }



    System.out.println("RELATORIO FINAL:");
    fachada.finalizarDebate();



    System.out.println("\n==================================");
    System.out.println("       DEBATE ENCERRADO");
    System.out.println("==================================");
  }
}
