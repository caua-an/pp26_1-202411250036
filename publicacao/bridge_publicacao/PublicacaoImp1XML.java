package bridge_publicacao;

public class PublicacaoImp1XML extends Implementador{

    public PublicacaoImp1XML(){
        System.out.println("O construtor de um implementador publicacaoimp1xml foi ativado");
    }

    @Override
    public void getDados(Publicacao tipo) {
        //
        System.out.println("getDados() do PublicacaoImp1XML foi usado");
    }
}
