package test;



import java.awt.Rectangle;

public class Comida{
    private int x;
    private int y;

    public Comida(Cobra player){
        this.aleatorio(player);
    }

    public void aleatorio(Cobra player){
        boolean onCobra = true;
        while(onCobra){
        	onCobra = false;
            x = (int)(Math.random() * Jogo.largura - 1);
            y = (int)(Math.random() * Jogo.altura - 1);
            for(Rectangle r: player.getCorpo()){
                if(r.x == x && r.y == y){
                    onCobra = true;
                    //vai gerar de novo até não estar mais sobre a cobra
                }
            }
        }
    }

    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
}