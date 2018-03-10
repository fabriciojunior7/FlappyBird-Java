package logica;

import java.awt.*;

public class Entidade {

    //Atributos
    protected int x, y, largura, altura;

    //Construtor
    public Entidade(int x, int y, int largura, int altura){
        if(largura <= 0 || altura <= 0){
            throw new IllegalArgumentException("Não é possível criar uma Entidade com largura ou altura iguais ou menores que zero.");
        }
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    //Metodos
    public void desenhar(Graphics g){
        g.setColor(new Color(255, 255, 255));
        g.fillRect(this.x, this.y,this.largura,this.altura);
    }

    //Metodos Especiais

}
