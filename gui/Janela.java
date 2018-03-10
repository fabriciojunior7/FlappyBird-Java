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

    //Construtor
    public Janela(String titulo, int largura, int altura){
        if(largura <= 0 || altura <= 0){
            throw new IllegalArgumentException("Não é possível criar uma Tela com largura ou altura iguais ou menores que zero.");
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
        this.player = new Bird(310,230);
        this.entidades = new ArrayList<Entidade>();
        this.pause = false;

        int numObstaculos = 4;
        for(int i=0; i<numObstaculos; i++){
            this.entidades.add(new Obstaculo(640 + i*160));
        }
    }

    //Metodos
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,640,480);

        this.player.atualizarPosicao();
        this.player.desenhar(g);
        for(Entidade entidade : this.entidades){
            if(entidade instanceof Obstaculo){
                ((Obstaculo) entidade).atualizarPosicao();
            }
            entidade.desenhar(g);
        }
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
