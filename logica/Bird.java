package logica;

public class Bird extends Entidade {

    //Atributos
    protected int score;
    protected int velocidadeX, velocidadeY, getVelocidadeYMax, forcaPulo, GRAVIDADE;

    //Construtor
    public Bird(int x, int y) {
        super(x, y, 20, 20);
        this.score = 0;
        this.forcaPulo = 10;
        this.velocidadeX = 0;
        this.velocidadeY = 0;
        this.getVelocidadeYMax = 30;
        this.GRAVIDADE = 1;
    }

    //Metodos
    public void pontuar(){
        this.score++;
    }

    public void pular(){
        this.velocidadeY = -this.forcaPulo;
    }

    public void atualizarPosicao(){
        if(this.velocidadeY < this.getVelocidadeYMax){
            this.velocidadeY += this.GRAVIDADE;
        }

        if(this.y < 0){
            this.velocidadeY *= -0.5;
            this.y = 0;
        }

        else if(this.y > 400-this.altura){
            this.velocidadeY = 0;
            this.y = 400-this.altura;
        }

        this.y += this.velocidadeY;
    }

    //Metodos Especiais

}
