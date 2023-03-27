package test;


import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class Jogo
implements KeyListener {

    private Cobra player; //Um Cobra snake chamado player
    private Comida comida;
    private Graficos grafico;
    
    private JFrame janela; //Onde vou desenhar a tela 
    public static final int largura = 30; //valor constante
    public static final int altura = 30;
    public static final int dimensao = 20;

    public Jogo(){
        //criando e configurando a janela
        janela = new JFrame();

        player = new Cobra();
        comida = new Comida(player);

        grafico = new Graficos(this);
        janela.add(grafico);

        janela.setTitle("Vamos Jogar!");
        janela.setSize(largura*dimensao, altura*dimensao);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para permitir fechar


    }

    public void start(){
        grafico.estado = "RODANDO";
    }
    
    public void update() {
		if(grafico.estado == "RODANDO") {
			if(check_colisao_comida()) {
				player.grow();
				comida.aleatorio(player);
				//gera nova comida
			}
			else if(check_colisao_parede() || check_colisao_cobra()) {
				grafico.estado = "FIM";
			}
			else {
				player.move();
			}
		}
	}
    
    private boolean check_colisao_parede() {
		if(player.getX() < 0 || player.getX() >= largura * dimensao 
				|| player.getY() < 0|| player.getY() >= altura * dimensao) {
			return true;
		}
		return false;
	}
    
    private boolean check_colisao_comida() {
		if(player.getX() == comida.getX() * dimensao && player.getY() == comida.getY() * dimensao) {
			return true;
		}
		return false;
	}
    
    private boolean check_colisao_cobra() {
		for(int i = 1; i < player.getCorpo().size(); i++) {
			if(player.getX() == player.getCorpo().get(i).x &&
					player.getY() == player.getCorpo().get(i).y) {
				return true;
			}
		}
		return false;
	}

    @Override
    public void keyTyped(KeyEvent e){}
    
    @Override
    public void keyPressed(KeyEvent e){
        int KeyCode = e.getKeyCode();
        
        if(grafico.estado == "RODANDO") { 
        	if(KeyCode == KeyEvent.VK_W){
        		//seta para cima
           	player.up();
        	}
        	if(KeyCode == KeyEvent.VK_S){
        		//seta para baixo
        		player.down();
        	}
        	if(KeyCode == KeyEvent.VK_A){
        		//seta para Esquerda
        		player.left();
        	}
        	if(KeyCode == KeyEvent.VK_D){
        		//seta para Direita
        		player.right();
        	}
        }
        else {
        	this.start();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){}

    public Cobra getPlayer(){
        return player;
    }
    public void setPlayer(Cobra player){
        this.player = player;
    }
    public Comida getComida(){
        return comida;
    }
    public void setComida(Comida comida){
        this.comida = comida;
    }
    public JFrame getJanela(){
        return janela;
    }
    public void setJanela(JFrame janela){
        this.janela = janela;
    }
    

}