package bridge_publicacao;

public class Revista extends Publicacao{

    String artigo;

    public Revista(Implementador imp, String p_titulo, String p_autor){
        super(imp, p_titulo, p_autor);
        //
        System.out.println("Construtor de revista foi usado!");
    }

    public String getArtigo() {
        //
        return "getArtigo()";
    }
}
