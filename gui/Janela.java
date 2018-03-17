package gui;

import gui.cenario.Cenario;
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
    protected Cenario cenario;
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
        this.timer = new Timer(22, this);
        this.timer.start();
        this.player = new Bird(310, 100, "imagens/bird1.png", this);
        this.cenario = new Cenario(this);
        this.entidades = new ArrayList<Entidade>();
        this.pause = false;

        this.imagemSol = new ImageIcon(this.getClass().getResource("imagens/sol2.png"));

        int numObstaculos = 4;
        for(int i=0; i<numObstaculos; i++){
            this.entidades.add(new Obstaculo(640 + i*160, this));
        }
    }

    //Metodos
    @Override
    public void paintComponent(Graphics g){
    	this.processar();
        this.desenhar(g);
    }

    public void processar(){
        this.player.atualizarPosicao();
        for(Entidade entidade : this.entidades){
            if(entidade instanceof Obstaculo){
                ((Obstaculo) entidade).atualizarPosicao(this.player.getScore());
            }
            if(Collide.rect(this.player, ((Obstaculo) entidade).getTuboBase()) || Collide.rect(this.player, ((Obstaculo) entidade).getTuboTop()) || this.player.getGameOver()){
                this.gameOver();
            }
            if(Collide.rect(this.player, ((Obstaculo) entidade).getBarraPontuar()) && ((Obstaculo) entidade).getPontuar()){
                this.player.pontuar();
                ((Obstaculo) entidade).pontuar();
            }
        }
    }

    public void desenhar(Graphics g){
        this.cenario.desenhar(g);
        this.player.desenhar(g);
        for(Entidade entidade : this.entidades){
            entidade.desenhar(g);
        }
        this.desenharTexto(g);
    }
 
    public void desenharTexto(Graphics g){
        g.setFont(new Font("Arial", Font.BOLD, 75));
        g.setColor(new Color(40, 40, 40, 100));
        if(this.player.getScore() < 10) {
        	g.drawString(this.player.getScore()+"", 305, 80);
        }
        else {
        	g.drawString(this.player.getScore()+"", 280, 80);
        }
        g.setColor(new Color(40, 40, 40));
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
        //System.out.println("GAME OVER!");
        //this.timer.stop();
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
            if(keyEvent.getKeyCode() == 32 || keyEvent.getKeyCode() == 87 || keyEvent.getKeyCode() == 38){
                this.player.pular();
            }

        }

        //PAUSE
        if((keyEvent.getKeyCode() == 27 || keyEvent.getKeyCode() == 10 || keyEvent.getKeyCode() == 80) && !this.pause){
            this.pause = true;
            this.timer.stop();
        }
        else if((keyEvent.getKeyCode() == 27 || keyEvent.getKeyCode() == 10 || keyEvent.getKeyCode() == 80) && this.pause){
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
