import java.util.concurrent.TimeUnit;


public class Cronometro extends Colaborador{
    private int tempoAtual;

    public void iniciar(int tempo){
        this.tempoAtual = tempo;

        while(this.tempoAtual > 0){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException("Erro na setagem do tempo do cronômetro.", e);
            }
            this.tempoAtual --;
        }

        finalizar();

    }

    public void finalizar(){
        mediador.proximaAcao();
    }

}
