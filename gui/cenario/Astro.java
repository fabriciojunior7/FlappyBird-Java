package gui.cenario;

import logica.Entidade;
import logica.TipoDeCenario;

public abstract class Astro extends Entidade{

	//Atributos
	//private TipoDeCenario tipo;

	//Construtor
	public Astro(int x, int y, int largura, int altura) {
		super(x, y, largura, altura);
	}

	//Metodos Abstratos
	public abstract void atualizarPosicao();

	//Metodos Especias

}
