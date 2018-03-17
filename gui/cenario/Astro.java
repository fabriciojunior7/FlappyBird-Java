package gui.cenario;

import logica.Entidade;
import logica.TipoDeCenario;

import javax.swing.*;

public abstract class Astro extends Entidade{

	//Atributos

	//Construtor
	public Astro(int x, int y, int largura, int altura, String local, JPanel janela) {
		super(x, y, largura, altura, local, janela);
	}

	//Metodos Abstratos
	public abstract void atualizarPosicao();

	//Metodos Especias

}
