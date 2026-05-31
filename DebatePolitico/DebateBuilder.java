import java.util.ArrayList;
import java.util.List;

public class DebateBuilder {
    // set padrões pro builder
    private List<Candidato> candidatosList = new ArrayList<>();
    private List<Microfone> microfonesList = new ArrayList<>();
    private Eleitor eleitor_modelo = new Eleitor("modelo");
    private Fachada fachada = Fachada.getInstance();

    private int cont_mic = 0;

    public DebateBuilder addCandidato(int id, String nome){
        Microfone mic = new Microfone(cont_mic++);
        microfonesList.add(mic);
        candidatosList.add(new Candidato(id, nome, mic));
        fachada.configurarDebate(candidatosList);
        return this;
    }
    public DebateBuilder addEleitor(String nome, int id_cand){
        boolean encontrado = false;
        // vincular o eleitor ao seu candidato
        for(Candidato c : candidatosList){
            if(c.getId() == id_cand){
                // usa o prototipo para clonar
                Eleitor e = eleitor_modelo.clonar_prot();
                e.setNome(nome);
                fachada.vincularEleitor(e, c);
                encontrado = true;
                break;
            }
        }
        // caso nao encontre o candidato com id_cand
        if(!encontrado){
            throw new RuntimeException("Candidato com id "+ id_cand +" não encontrado");
        }

        return this;

    }
    public Fachada build(){
        return fachada;
    }

}
