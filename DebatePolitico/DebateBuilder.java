import java.util.List;

public class DebateBuilder {
    // set padrões pro builder
    private List<Candidato> candidatosList;
    private List<Microfone> microfonesList;
    private Eleitor eleitor_modelo = new Eleitor("modelo");
    private int cont_mic = 0;

    public DebateBuilder addCandidato(int id, String nome){
        Microfone mic = new Microfone(cont_mic++);
        microfonesList.add(mic);
        candidatosList.add(new Candidato(id, nome, mic));
        return this;
    }

}
