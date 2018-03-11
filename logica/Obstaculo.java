package logica;

import interfaces.Movimentavel;

import java.awt.*;
import java.util.Random;

public class Obstaculo extends Entidade{

    //Atributos
    private Tubo tuboTop, tuboBase;
    private BarraScore barraScore;
    private int separacaoBase, separacao;
    protected int velocidadeX, velocidadeY;

    //Construtor
    public Obstaculo(int x){
        super(x, 300, 40, 400);
        Random r = new Random();
        this.separacaoBase = 200;
        this.separacao = this.separacaoBase;
        this.y = r.nextInt(310) + this.separacao;
        this.tuboBase = new Tubo(x, this.y);
        this.tuboTop = new Tubo(x, this.y-this.tuboBase.getAltura()-this.separacao);
        this.barraScore = new BarraScore(x + this.largura + 20);
        this.velocidadeX = -3;
        this.velocidadeY = 0;
    }

    //Metodos
    public void atualizarPosicao(int score) {
        this.x += this.velocidadeX;
        this.y += this.velocidadeY;
        this.tuboTop.atualizarPosicao(this.x);
        this.tuboBase.atualizarPosicao(this.x);
        this.barraScore.atualizarPosicao(x + this.largura + 20);
        if(this.x < -this.largura-5){
            this.reset(score);
        }
    }

    @Override
    public void desenhar(Graphics g){
        this.tuboTop.desenhar(g);
        this.tuboBase.desenhar(g);
        //this.barraScore.desenhar(g);
    }

    public void reset(int score){
        Random r = new Random();
        //FASE 1
        if(score <= 25) {
        	this.separacao = this.separacaoBase - score*2;
        }
        //FASE 2
        else if(score <= 50){
        	this.separacao = r.nextInt(200) + 90;
        }
        //FASE 3
        else if(score <= 75){
        	this.separacao = r.nextInt(100) + 90;
        }
        //FASE 4
        else {
        	this.separacao = r.nextInt(20) + 90;
        }
        this.x = 640;
        this.y = r.nextInt(310) + this.separacao;
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
