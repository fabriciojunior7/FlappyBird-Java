package gui.cenario;

import logica.Entidade;

import javax.swing.*;
import java.util.Random;

public class Nuvem extends Astro{

	//Atributos
	private float x, y, velocidadeX;
	private int nImagem;

	//Contrutor
	public Nuvem(int x, int y, String local, int nImagem, JPanel janela){
		super(x, y, 0, 0, local, janela);
		this.x = x;
		this.y = y;
		this.largura = this.imagem.getIconWidth();
		this.altura = this.imagem.getIconHeight();
		Random r = new Random();
		this.velocidadeX = 1 - r.nextFloat();
		this.nImagem = nImagem;
	}

	//Metodos
	@Override
	public void atualizarPosicao() {
		this.x -= this.velocidadeX;
		super.x = (int)this.x;
		if(this.x < -this.largura){
			this.reset();
		}
	}

	public void reset(){
		Random r = new Random();
		this.x = 640;
		super.x = (int)this.x;
		this.y = r.nextInt(101);
		super.y = (int)this.y;
		this.velocidadeX = 1 - r.nextFloat();
	}
}
