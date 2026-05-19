public class Eleitor implements Observer{
    private String nome;
    private Candidato cand_escolhido;

    public Eleitor(String p_nome, Candidato p_candidato){
        this.nome = p_nome;
        this.cand_escolhido = p_candidato;
    }


    @Override
    public void atualizar(String mensagem) {
        System.out.println("Eleitor " + this.nome + " recebeu: " + mensagem + "\n");

    }
}
