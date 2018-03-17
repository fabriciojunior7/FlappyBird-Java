package logica;

import interfaces.Movimentavel;

import javax.swing.*;
import java.awt.*;

public class Tubo extends Entidade{

    //Atributos

    //Construtor
    public Tubo(int x, int y, String local, JPanel janela) {
        super(x, y, 40, 400, local, janela);
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
