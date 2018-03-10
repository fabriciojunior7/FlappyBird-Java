package logica;

import interfaces.Movimentavel;

import java.awt.*;
import java.util.Random;

public class Obstaculo extends Entidade implements Movimentavel{

    //Atributos
    private Tubo tuboTop, tuboBase;
    private int separacao;
    protected int velocidadeX, velocidadeY;

    //Construtor
    public Obstaculo(int x){
        super(x, 300, 40, 400);
        Random r = new Random();
        this.separacao = 100;
        this.y = r.nextInt(300) + this.separacao + 10;
        this.tuboBase = new Tubo(x, this.y);
        this.tuboTop = new Tubo(x, this.y-this.tuboBase.getAltura()-this.separacao);
        this.velocidadeX = -2;
        this.velocidadeY = 0;
    }

    //Metodos
    @Override
    public void atualizarPosicao() {
        this.x += this.velocidadeX;
        this.y += this.velocidadeY;
        this.tuboTop.atualizarPosicao(this.x);
        this.tuboBase.atualizarPosicao(this.x);
        if(this.x < -this.largura){
            this.reset();
        }
    }

    @Override
    public void desenhar(Graphics g){
        this.tuboTop.desenhar(g);
        this.tuboBase.desenhar(g);
    }

    public void reset(){
        Random r = new Random();
        this.x = 640;
        this.y = r.nextInt(300) + this.separacao + 10;
        this.tuboBase.reset(this.x, this.y);
        this.tuboTop.reset(x, this.y-this.tuboBase.getAltura()-this.separacao);
    }

    //Metodos Especiais

}
