package sistema;

import gui.Janela;
import logica.Entidade;
import logica.Bird;

import java.util.ArrayList;

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
