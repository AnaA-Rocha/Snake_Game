package test;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Graficos
extends JPanel
implements ActionListener{

    private Timer t = new Timer(200, this);
    public String estado;

    private Cobra cobra;
    private Comida maca;
    private Jogo jogo;

    public Graficos(Jogo j) {
        t.start();
        estado = "INICIO";

        jogo = j;
        cobra = j.getPlayer();
        maca = j.getComida();

        this.addKeyListener(j);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Jogo.largura * Jogo.dimensao, Jogo.altura * Jogo.dimensao);
        
        if(estado == "INICIO") {
        	g2d.setColor(Color.blue);
			g2d.drawString("Aperte qualquer tecla", Jogo.largura/2 * Jogo.dimensao - 40, Jogo.altura / 2 * Jogo.dimensao - 20);
        }
        else if(estado == "RODANDO") {
        	g2d.setColor(Color.red);
        	g2d.fillRect(maca.getX() * Jogo.dimensao, maca.getY() * Jogo.dimensao, Jogo.dimensao, Jogo.dimensao);

        	g2d.setColor(Color.pink);
            for(Rectangle r: cobra.getCorpo()){
                g2d.fill(r); 
            }
		}
		else {
			g2d.setColor(Color.white);
			g2d.drawString("Pontos: " + (cobra.getCorpo().size() - 3), Jogo.largura/2 * Jogo.dimensao - 40, Jogo.altura / 2 * Jogo.dimensao - 20);
		}
    	
 
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            repaint();
            jogo.update();
    }


}