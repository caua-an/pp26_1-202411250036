public class EstadoNormal implements DebateState{
    @Override
    public void passarRodada(GerenciadorDebate debate) {
        // ao terminar o processo dentro do EstadoNormal, verifica se algum candidato adicionou um DR, para entao entrar no estado de DR
        if(debate.possuiSolicitacoesDR()) {
            debate.registrarAcao("Solicitações de DR detectadas.");
            // vai para o estadoDR
            debate.setEstadoatual(new EstadoDR());
            // executa o estadoDR
            debate.executarEstadoAtual();

        } else {
            debate.registrarAcao("Rodada encerrada sem DR");
        }

        debate.sortearInquiridor();


    }
}
