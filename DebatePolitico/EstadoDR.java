public class EstadoDR implements DebateState{
    @Override
    public void passarRodada(GerenciadorDebate debate) {
        ///  metodo que vai realizar a funcionalidade de uma DR
        debate.executarDR();
        debate.setEstadoatual(new EstadoNormal());

        debate.registrarAcao("Retornando ao Debate normal");
    }
}
