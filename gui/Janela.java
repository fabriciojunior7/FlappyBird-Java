package gui;

import logica.Bird;
import logica.Collide;
import logica.Entidade;
import logica.Obstaculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Janela extends JPanel implements ActionListener, KeyListener, MouseListener{

    //Atributos
    protected JFrame tela;
    protected Timer timer;
    protected Bird player;
    protected ArrayList<Entidade> entidades;
    protected boolean pause;
    protected ImageIcon imagemBird, imagemTuboBase, imagemTuboTop, imagemSol;

    //Construtor
    public Janela(String titulo, int largura, int altura){
        if(largura <= 0 || altura <= 0){
            throw new IllegalArgumentException("Nao e possivel criar uma Tela com largura ou altura iguais ou menores que zero.");
        }
        this.tela = new JFrame(titulo);
        this.tela.setSize(largura, altura);
        this.tela.setVisible(true);
        this.tela.setLocationRelativeTo(null);
        this.tela.setBackground(new Color(0,0,0));
        this.tela.setResizable(false);
        this.tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.tela.add(this);
        this.tela.addKeyListener(this);
        this.tela.addMouseListener(this);
        this.timer = new Timer(24, this);
        this.timer.start();
        this.player = new Bird(310, 100);
        this.entidades = new ArrayList<Entidade>();
        this.pause = false;
        
        this.imagemBird = new ImageIcon(this.getClass().getResource("imagens/bird1.png"));
        this.imagemTuboBase = new ImageIcon(this.getClass().getResource("imagens/tuboBase1.png"));
        this.imagemTuboTop = new ImageIcon(this.getClass().getResource("imagens/tuboTop1.png"));
        this.imagemSol = new ImageIcon(this.getClass().getResource("imagens/sol1.png"));

        int numObstaculos = 4;
        for(int i=0; i<numObstaculos; i++){
            this.entidades.add(new Obstaculo(640 + i*160));
        }
    }

    //Metodos
    @Override
    public void paintComponent(Graphics g){
        //g.setColor(new Color(255, 255, 255));
    	g.setColor(new Color(127, 227, 255));
        g.fillRect(0, 0, 640, 480);
        this.desenharCenario(g);

        this.player.atualizarPosicao();
        //this.player.desenhar(g);
        for(Entidade entidade : this.entidades){
            if(entidade instanceof Obstaculo){
                ((Obstaculo) entidade).atualizarPosicao(this.player.getScore());
            }
            //entidade.desenhar(g);
            try {
            	imagemTuboBase.paintIcon(this, g, ((Obstaculo) entidade).getTuboBase().getX(), ((Obstaculo) entidade).getTuboBase().getY());
                imagemTuboTop.paintIcon(this, g, ((Obstaculo) entidade).getTuboTop().getX(), ((Obstaculo) entidade).getTuboTop().getY());
			} catch (Exception e) {
				
			}
            
            if(Collide.rect(this.player, ((Obstaculo) entidade).getTuboBase()) || Collide.rect(this.player, ((Obstaculo) entidade).getTuboTop()) || this.player.getGameOver()){
                this.gameOver();
            }
            if(Collide.rect(this.player, ((Obstaculo) entidade).getBarraPontuar()) && ((Obstaculo) entidade).getPontuar()){
                this.player.pontuar();
                ((Obstaculo) entidade).pontuar();
            }
        }
        this.texto(g);
        this.desenharImagens(g);
    }

    public void desenharImagens(Graphics g){
    	try {
    		imagemBird.paintIcon(this, g, this.player.getX(),this.player.getY());
		} catch (Exception e) {
			
		}
    }
    
    public void desenharCenario(Graphics g) {
    	try {
    		imagemSol.paintIcon(this, g, 25, 25);
		} catch (Exception e) {
			
		}
    } 
 
    public void texto(Graphics g){
        g.setFont(new Font("Arial", Font.BOLD, 75));
        g.setColor(new Color(40, 40, 40));
        if(this.player.getScore() < 10) {
        	g.drawString(this.player.getScore()+"", 305, 80);
        }
        else {
        	g.drawString(this.player.getScore()+"", 280, 80);
        }
        g.setFont(new Font("Arial", Font.ITALIC, 12));
        g.drawString("Fabricio Junior", 5, 445);
    }

    public void setPlayer(Bird player){
        this.player = player;
    }

    public void addEntidade(Entidade entidade){
        this.entidades.add(entidade);
    }

    public void removeEntidade(Entidade entidade){
        this.entidades.remove(entidade);
    }

    public void gameOver(){
        System.out.println("GAME OVER!");
        this.timer.stop();
    }


    //Metodos Especiais
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        //System.out.println(keyEvent.getKeyCode());

        if(!this.pause){

            //PULAR
            if(keyEvent.getKeyCode() == 32){
                this.player.pular();
            }

        }

        //PAUSE
        if(keyEvent.getKeyCode() == 27 && !this.pause){
            this.pause = true;
            this.timer.stop();
        }
        else if(keyEvent.getKeyCode() == 27 && this.pause){
            this.pause = false;
            this.timer.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

}
