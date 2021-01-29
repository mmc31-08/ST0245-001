import java.awt.*;

public class Punto {

    private double x,y;

    public Punto (double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }


    public double radioPolar(){
        double radio = Math.sqrt((Math.pow(x,2)) + (Math.pow(y,2)));
        return radio;
    }

    public double anguloPolar(){
        double angulo = Math.atan(y/x);
        return angulo;
    }

    public double distanciaEuclidiana(Punto p){
        double differencex = this.x - p.getX();
        double differencey = this.y - p.getY();
        return Math.sqrt(Math.pow(differencex,2) + Math.pow(differencey,2));
    }

}