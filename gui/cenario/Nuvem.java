package gui.cenario;

import logica.Entidade;

import javax.swing.*;
import java.util.Random;

public class Nuvem extends Astro{

	//Atributos
	private float x, y, velocidadeX;
	private int nImagem;

	//Contrutor
	public Nuvem(JPanel janela){
		super(new Random().nextInt(641), new Random().nextInt(101), 1, 1, "imagens/nuvem1.png", janela);
		this.x = super.x;
		this.y = super.y;
		super.largura = this.imagem.getIconWidth();
		super.altura = this.imagem.getIconHeight();
		Random r = new Random();
		this.velocidadeX = 1 - r.nextFloat();
		this.nImagem = 8;
		this.imagem = new ImageIcon(this.janela.getClass().getResource("imagens/nuvem" + (r.nextInt(this.nImagem)+1) + ".png"));
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
		this.imagem = new ImageIcon(this.janela.getClass().getResource("imagens/nuvem" + (r.nextInt(this.nImagem)+1) + ".png"));
	}
}
