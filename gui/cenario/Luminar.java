package gui.cenario;

import javax.swing.*;

public class Luminar extends Astro {

    //Atributos
    private float x, y;

    //Construtor
    public Luminar(String local, JPanel janela){
        super(640, 100, 66, 66, local, janela);
        this.x = super.x;
        this.y = super.y;
    }

    //Metodos
    @Override
    public void atualizarPosicao() {
        float t = 1;
        this.x -= 0.2*t;
        if(this.x > 320-this.largura/2){
            this.y -= 0.05*t;
        }
        else{
            this.y += 0.05*t;
        }

        if(this.x < -this.largura){
            this.reset();
        }
        super.x = (int) this.x;
        super.y = (int) this.y;
    }

    public void reset(){
        this.x = 640;
        this.y = 100;
        super.x = (int) this.x;
        super.y = (int) this.y;
    }


}
