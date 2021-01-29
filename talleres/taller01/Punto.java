import java.awt.*;

public class Punto{

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
        double anguloP = Math.atan(y/x);
        return anguloP;
    }

    public double distanciaEuclidiana(Punto p){
        double diferenciax = this.x - p.getX();
        double diferenciay = this.y - p.getY();
        return Math.sqrt(Math.pow(diferenciax,2) + Math.pow(diferenciay,2));
    }

}