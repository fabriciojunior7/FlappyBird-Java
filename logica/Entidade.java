package logica;

import java.awt.*;

public class Entidade {

    //Atributos
    protected int x, y, largura, altura;
    protected Color cor;

    //Construtor
    public Entidade(int x, int y, int largura, int altura){
        if(largura <= 0 || altura <= 0){
            throw new IllegalArgumentException("Não é possível criar uma Entidade com largura ou altura iguais ou menores que zero.");
        }
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.cor = Color.white;
    }

    //Metodos
    public void desenhar(Graphics g){
        g.setColor(this.cor);
        g.fillRect(this.x, this.y,this.largura,this.altura);
    }

    //Metodos Especiais
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor){
        this.cor = cor;
    }

}
