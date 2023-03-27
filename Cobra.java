package test;

ALTEREI AQUI
import java.util.ArrayList;
import java.awt.Rectangle;;

public class Cobra{
    
    private ArrayList<Rectangle> corpo;
    private String move;

    public Cobra(){ //construtor
        corpo = new ArrayList<>();

        Rectangle temp = new Rectangle(Jogo.dimensao, Jogo.dimensao);
        temp.setLocation(Jogo.largura/2 * Jogo.dimensao, Jogo.altura/2 * Jogo.dimensao);
        corpo.add(temp); //adicionou o retangulo ao corpo

        temp = new Rectangle(Jogo.dimensao, Jogo.dimensao);
        temp.setLocation((Jogo.largura/2 - 1) * Jogo.dimensao, (Jogo.altura/2 - 1) * Jogo.dimensao);
        corpo.add(temp); //adicionou o retangulo ao corpo

        temp = new Rectangle(Jogo.dimensao, Jogo.dimensao);
        temp.setLocation((Jogo.largura/2 - 2) * Jogo.dimensao, (Jogo.altura/2 - 2) * Jogo.dimensao);
        corpo.add(temp); //adicionou o retangulo ao corpo

        move = "LEFT"; //para a cobra comecar o jogo andando para esquerda
    }

    public void move(){
        Rectangle primeiro = corpo.get(0);
        Rectangle temp = new Rectangle(Jogo.dimensao, Jogo.dimensao);
        if(move == "UP"){
            temp.setLocation(primeiro.x, primeiro.y - Jogo.dimensao);
        }
        if(move == "DOWN"){
            temp.setLocation(primeiro.x, primeiro.y + Jogo.dimensao);
        }
        if(move == "LEFT"){
            temp.setLocation(primeiro.x  - Jogo.dimensao, primeiro.y);
        }
        if(move == "RIGHT"){
            temp.setLocation(primeiro.x  + Jogo.dimensao, primeiro.y);
        }
        corpo.add(0,temp);
        corpo.remove(corpo.size() - 1);
    }

    public void grow(){
        Rectangle primeiro = corpo.get(0);
        Rectangle temp = new Rectangle(Jogo.dimensao, Jogo.dimensao);
        if(move == "UP"){
            temp.setLocation(primeiro.x, primeiro.y - Jogo.dimensao);
        }
        if(move == "DOWN"){
            temp.setLocation(primeiro.x, primeiro.y + Jogo.dimensao);
        }
        if(move == "LEFT"){
            temp.setLocation(primeiro.x  - Jogo.dimensao, primeiro.y);
        }
        if(move == "RIGHT"){
            temp.setLocation(primeiro.x  + Jogo.dimensao, primeiro.y);
        }
        corpo.add(0,temp);
    }

    public ArrayList<Rectangle> getCorpo(){
        return corpo;
    }

    public void setCorpo(ArrayList<Rectangle> corpo){
        this.corpo = corpo;
    }
    
	public int getX() {
		return corpo.get(0).x;
	}
	
	public int getY() {
		return corpo.get(0).y ;
	}
	
	public String getMove() {
		return move;
	}
    public void up(){
        move = "UP";
    }
    public void down(){
        move = "DOWN";
    }
    public void left(){
        move = "LEFT";
    }
    public void right(){
        move = "RIGHT";
    }
}