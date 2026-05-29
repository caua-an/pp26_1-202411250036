public class Eleitor implements Observer{
    private String nome;

    public Eleitor(String p_nome){
        this.nome = p_nome;
    }


    @Override
    public void atualizar(String mensagem) {
        System.out.println("Eleitor " + this.nome + " recebeu: " + mensagem + "\n");

    }
}
