package bridge_publicacao;

public class Publicacao {
    // aqui que é o core do "Bridge", esse atributo que conectara em uma instância de publicacaoimp1bd ou publicacaoimp1xml
    public Implementador imp;


    public Publicacao(Implementador p_imp, String p_titulo, String p_autor){
        //

        System.out.println("Construtor de Publicacao foi usado!");
    }

    public void obter_dados(String tipo){
        //
        System.out.println("obter_dados() foi usado");
    }

    public String getTitulo(){
        //
        return "getTitulo() foi usado";
    }

    public String getAutor(){
        //
        return "getAutor() foi usado";
    }
}
