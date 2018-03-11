package logica;

import interfaces.Movimentavel;

import java.awt.*;

public class Tubo extends Entidade{

    //Atributos

    //Construtor
    public Tubo(int x, int y) {
        super(x, y, 40, 400);
        this.setCor(Color.blue);
    }

    //Metodos
    public void atualizarPosicao(int x) {
        this.x = x;
    }

    public void reset(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Metodos Especiais


}
