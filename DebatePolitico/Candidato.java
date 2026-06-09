import java.util.ArrayList;
import java.util.List;

public class Candidato implements Subject{

    private int cand_id;
    private String cand_nome;
    private boolean jaPerguntou;
    protected Microfone cand_mic;

    private List<Observer> observers;


    public Candidato(int p_id, String p_nome, Microfone p_mic){
        this.cand_id = p_id;
        this.cand_nome = p_nome;
        this.jaPerguntou = false;
        this.cand_mic = p_mic;

        this.observers = new ArrayList<>();


    }

    public String getNome(){return this.cand_nome;}

    public int getId(){return this.cand_id;}

    public void marcarComoInquiridor(){ this.jaPerguntou = true;}

    public boolean getJaPerguntou(){ return this.jaPerguntou;}

    @Override
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers() {
        String mensagem;

        mensagem = ("Candidato " + this.cand_nome + " esta falando");

        for(Observer observer : observers){
            observer.atualizar(mensagem);
        }
    }

    public void solicitarDR(){
        cand_mic.pressionarDR(this);
    }
}
