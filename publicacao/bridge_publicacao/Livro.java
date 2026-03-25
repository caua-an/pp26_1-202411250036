package bridge_publicacao;


public class Livro extends Publicacao{

    int ISBN;


    public Livro(Implementador imp, String p_titulo, String p_autor) {

        super(imp, p_titulo, p_autor);
        //

        System.out.println("Construtor de livro foi usado!");


    }

    public String getISBN() {
        //
        return "getISBN() foi usado.";
    }

}
