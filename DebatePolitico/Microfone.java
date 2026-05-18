public class Microfone {

    private int id_mic;
    private boolean est_ligado;

    // construtor do Microfone necessita no minimo um id para instanciar
    public Microfone(int p_id){
        this.id_mic = p_id;
        this.est_ligado = false;
    }
    // metodos on/off
    public void ligar(){
        this.est_ligado = true;
    }
    public void desligar(){
        this.est_ligado = false;
    }

}
