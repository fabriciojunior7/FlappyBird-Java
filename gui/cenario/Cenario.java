package gui.cenario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Cenario {
	
	//Atributos
	private Luminar sol, lua;
	private ArrayList<Nuvem> nuvens;
	private boolean dia;
	private float ceu;
	private int r, g, b;
	private int numNuvens;
	
	//Construtor
	public Cenario(JPanel janela){
		this.sol = new Luminar("imagens/sol2.png", janela);
		this.lua = new Luminar("imagens/lua1.png", janela);
		this.dia = true;
		this.ceu = -150;
		this.r = 102 + (int)this.ceu;
		this.g = 255 + (int)this.ceu;
		this.b = 255 + (int)this.ceu;
		this.nuvens = new ArrayList<Nuvem>();
		Random random = new Random();
		this.numNuvens = random.nextInt(30) + 20;
		for(int i=0; i<this.numNuvens; i++){
			Nuvem n = new Nuvem(janela);
			this.nuvens.add(n);
		}
	}
	
	//Metodos
	public void desenhar(Graphics g){
		float t = 1;
		this.calcularCorCeu();
		g.setColor(new Color(this.r, this.g, this.b));
		g.fillRect(0, 0, 640, 480);

		//Desenhar Luminares
		if(this.dia) {
			this.sol.atualizarPosicao();
			this.sol.desenhar(g);
		}
		else{
			this.lua.atualizarPosicao();
			this.lua.desenhar(g);
		}

		for(Nuvem n : this.nuvens){
			n.atualizarPosicao();
			n.desenhar(g);
		}

		//Coloracao do Ceu
		if((this.sol.getX() > 320-this.sol.getLargura()/2 && this.dia) || this.lua.getX() < 320-this.lua.getLargura()/2 && !this.dia){
			this.ceu += 0.22*t;
		}
		else{
			this.ceu -= 0.22*t;
		}

		//Alternancia Dia/Noite
		if(this.sol.getX() <= -this.sol.getLargura()+5 && this.dia){
			this.dia = false;
		}
		else if(this.lua.getX() <= -this.lua.getLargura()+5 && !this.dia){
			this.dia = true;
		}
	}

	public void calcularCorCeu(){
		this.r = 102 + (int)this.ceu;
		this.g = 255 + (int)this.ceu;
		this.b = 255 + (int)this.ceu;

		if(this.r < 0){
			this.r = 0;
		}
		else if(this.r > 102){
			this.r = 102;
		}

		if(this.g < 0){
			this.g = 0;
		}
		else if(this.g > 255){
			this.g = 255;
		}

		if(this.b < 0){
			this.b = 0;
		}
		else if(this.b > 255){
			this.b = 255;
		}
	}

}
