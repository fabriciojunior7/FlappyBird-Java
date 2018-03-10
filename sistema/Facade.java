package sistema;

import gui.Janela;

public class Facade {

    //Atributos
    private Janela janela;

    //Construtor
    public Facade(){

    }

    //Metodos
    public void novoJogo(String titulo, int largura, int altura){
        this.janela = new Janela(titulo, largura, altura);
    }





}
