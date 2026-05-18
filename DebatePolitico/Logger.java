import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<String> logs;

    public Logger(){
        this.logs = new ArrayList<>();
    }

    public void registrar(String acao){
        if(acao == null){
            throw new IllegalArgumentException("Parametro passado eh null");
        }

        logs.add(acao);
    }

    public String gerarRelatorio(){
        if(logs.isEmpty()){
            return "Nenhuma acao registrada";
        }

        for(String log : logs){
            System.out.println(log);
        }
        return "";
    }

}
