package logica;

import interfaces.Movimentavel;

public class Bird extends Entidade implements Movimentavel{

    //Atributos
    protected int score;
    protected int velocidadeX, velocidadeY, getVelocidadeYMax, forcaPulo, GRAVIDADE;
    protected boolean gameOver;

    //Construtor
    public Bird(int x, int y) {
        super(x, y, 20, 20);
        this.score = 0;
        this.forcaPulo = 10;
        this.velocidadeX = 0;
        this.velocidadeY = 0;
        this.getVelocidadeYMax = 30;
        this.GRAVIDADE = 1;
        this.gameOver = false;
    }

    //Metodos
    public void pontuar(){
        this.score++;
    }

    public void pular(){
        this.velocidadeY = -this.forcaPulo;
    }

    @Override
    public void atualizarPosicao(){
        //Ação Gravitacional
        if(this.velocidadeY < this.getVelocidadeYMax){
            this.velocidadeY += this.GRAVIDADE;
        }

        //Game Over
        if(this.y < 0 || this.y > 430-this.altura){
            this.gameOver = true;
        }

        this.y += this.velocidadeY;
    }

    //Metodos Especiais
    public boolean getGameOver(){
        return this.gameOver;
    }

    public int getScore(){
        return this.score;
    }

}
