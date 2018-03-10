package logica;

import java.awt.*;

public class BarraScore extends Entidade {

    //Atributos
    private boolean pontuar;

    //Construtor
    public BarraScore(int x) {
        super(x, 0, 1, 480);
        this.pontuar = true;
    }

    //Metodos
    public void atualizarPosicao(int x) {
        this.x = x;
    }

    public void reset(int x){
        this.setCor(Color.white);
        this.pontuar = true;
        this.x = x;
    }

    //Metodos Especiais
    public boolean getPontuar(){
        return this.pontuar;
    }

    public void Pontuar(){
        this.pontuar = false;
        this.setCor(Color.green);
    }

}
