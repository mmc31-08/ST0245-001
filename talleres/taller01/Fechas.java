public class Fechas {

    private int dia,mes,anio;


    public Fechas (int dia,int mes,int anio){
        this.anio = anio;
        this.dia = dia;
        this.mes = mes;
    }

    public int anio() {
        return this.anio;
    }

    public int dia() {
        return this.dia;
    }

    public int mes() {
        return this.mes;
    }

    public int comparar(Fechas f){
        if(this.anio < f.anio && this.mes < f.mes && this.dia < f.dia){
            return -1;
        }else if(this.anio > f.anio && this.mes > f.mes && this.dia > f.dia ){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Fecha: " + this.dia + "/" + this.mes + "/" + this.anio;
    }
}

