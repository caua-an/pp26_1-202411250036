package bridge_publicacao;

public class PublicacaoImp1BD extends Implementador{

    public PublicacaoImp1BD(){
        System.out.println("O construtor de um implementador publicacaoimp1bd foi ativado");
    }

    @Override
    public void getDados(Publicacao tipo) {
        //
        System.out.println("getDados() do PublicacaoImp1BD foi usado");
    }
}
