public class Eleitor implements Observer,Prototype{
    private String nome;

    public Eleitor(String p_nome){
        this.nome = p_nome;
    }


    @Override
    public void atualizar(String mensagem) {
        System.out.println("Eleitor " + this.nome + " recebeu: " + mensagem + "\n");

    }

    @Override
    public Eleitor clonar_prot() {
        return new Eleitor(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
