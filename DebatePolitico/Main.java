public static void main(String[] args) {

  System.out.println("==================================");
  System.out.println("   SIMULADOR DE DEBATE POLITICO   ");
  System.out.println("==================================\n");

  Fachada fachada = new DebateBuilder()
          .addCandidato(1, "Carlos")
          .addCandidato(2, "Marina")
          .addEleitor("Maria",   1)
          .addEleitor("Jonas",   1)
          .addEleitor("Eduardo", 2)
          .build();

  System.out.println("Debate configurado com sucesso.\n");

  System.out.println("\n==================================");
  System.out.println("      INICIANDO O DEBATE");
  System.out.println("==================================\n");

  fachada.iniciarDebate();
  String erro = fachada.definirInquirido(2);

  if (erro != null) {
    erro = fachada.definirInquirido(1);
  }

  if (erro != null) {
    System.out.println(erro);
  } else {
    fachada.iniciarFase(10); // PERGUNTA
    fachada.iniciarFase(10); // RESPOSTA
    fachada.iniciarFase(10); // REPLICA
    fachada.iniciarFase(10); // TREPLICA
  }

  System.out.println("RELATORIO FINAL:");
  fachada.finalizarDebate();

  System.out.println("\n==================================");
  System.out.println("       DEBATE ENCERRADO");
  System.out.println("==================================");
}