package logica;

import interfaces.Movimentavel;

import java.awt.*;
import java.util.Random;

public class Obstaculo extends Entidade implements Movimentavel{

    //Atributos
    private Tubo tuboTop, tuboBase;
    private BarraScore barraScore;
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
        this.barraScore = new BarraScore(x + this.largura + 20);
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
        this.barraScore.atualizarPosicao(x + this.largura + 20);
        if(this.x < -this.largura){
            this.reset();
        }
    }

    @Override
    public void desenhar(Graphics g){
        this.tuboTop.desenhar(g);
        this.tuboBase.desenhar(g);
        this.barraScore.desenhar(g);
    }

    public void reset(){
        Random r = new Random();
        this.x = 640;
        this.y = r.nextInt(300) + this.separacao + 10;
        this.tuboBase.reset(this.x, this.y);
        this.tuboTop.reset(this.x, this.y-this.tuboBase.getAltura()-this.separacao);
        this.barraScore.reset(x + this.largura + 20);
    }

    public void pontuar(){
        this.barraScore.Pontuar();
    }

    //Metodos Especiais
    public Entidade getTuboBase(){
        return this.tuboBase;
    }

    public Entidade getTuboTop(){
        return this.tuboTop;
    }

    public Entidade getBarraPontuar(){
        return this.barraScore;
    }

    public boolean getPontuar(){
        return this.barraScore.getPontuar();
    }

}
