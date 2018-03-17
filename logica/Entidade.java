package logica;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Entidade {

    //Atributos
    protected int x, y, largura, altura;
    protected Color cor;
    protected ImageIcon imagem;
    protected JPanel janela;

    //Construtores
    public Entidade(int x, int y, int largura, int altura){
        if(largura <= 0 || altura <= 0){
            throw new IllegalArgumentException("Nao e possivel criar uma Entidade com largura ou altura iguais ou menores que zero.");
        }
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.cor = Color.white;
        this.imagem = null;
        this.janela = null;
    }

    public Entidade(int x, int y, int largura, int altura, String local, JPanel janela){
        if(largura <= 0 || altura <= 0){
            throw new IllegalArgumentException("Nao e possivel criar uma Entidade com largura ou altura iguais ou menores que zero.");
        }
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.cor = Color.white;
        this.imagem = new ImageIcon(janela.getClass().getResource(local));
        this.janela = janela;
    }

    //Metodos
    public void desenhar(Graphics g){
        if(this.imagem != null){
            this.imagem.paintIcon(this.janela, g, this.x, this.y);
        }
        else{
            g.setColor(this.cor);
            g.fillRect(this.x, this.y,this.largura,this.altura);
        }
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
