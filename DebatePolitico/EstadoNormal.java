public class EstadoNormal implements DebateState{
    @Override
    public void passarRodada(GerenciadorDebate debate) {
        // ao terminar o processo dentro do EstadoNormal, verifica se algum candidato adicionou um DR, para entao entrar no estado de DR
        if(debate.possuiSolicitacoesDR()){
            debate.setEstadoatual(new EstadoDR());
        }
    }
}
