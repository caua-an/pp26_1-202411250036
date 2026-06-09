public class EstadoDR implements DebateState{
    @Override
    public void passarRodada(GerenciadorDebate debate) {
        debate.executarDR();
        debate.setEstadoatual(new EstadoNormal());

        debate.registrarAcao("Retornando ao Debate normal");
        debate.sortearInquiridor();
    }
}
