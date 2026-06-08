public class Microfone {

    private int id_mic;
    private boolean est_ligado;
    private GerenciadorDebate debate;

    public Microfone(int p_id, GerenciadorDebate debate_p){
        this.id_mic = p_id;
        this.est_ligado = false;
        this.debate = debate_p;
    }
    // metodos on/off
    public void ligar(){
        this.est_ligado = true;
    }
    public void desligar(){
        this.est_ligado = false;
    }

    // adiciona o candidato a lista de DR
    public void pressionarDR(Candidato cand_p){
        debate.solicitarDR(cand_p);
    }

}
