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

    Eleitor eleitor1 =
            new Eleitor("Joao", candidato1);

    Eleitor eleitor2 =
            new Eleitor("Ana", candidato1);

    Eleitor eleitor3 =
            new Eleitor("Pedro", candidato2);

    // =========================
    // OBSERVERS
    // =========================

    candidato1.adicionarObserver(eleitor1);
    candidato1.adicionarObserver(eleitor2);

    candidato2.adicionarObserver(eleitor3);

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

    fachada.iniciarDebate();
    String erro = fachada.definirInquirido(2);

    if(erro != null){
        erro = fachada.definirInquirido(1);
    }

    if(erro != null){
        System.out.println(erro);
    } else {
        fachada.iniciarFase(10);
    }

    System.out.println("RELATORIO FINAL:");
    fachada.finalizarDebate();



    System.out.println("\n==================================");
    System.out.println("       DEBATE ENCERRADO");
    System.out.println("==================================");
  }
}
