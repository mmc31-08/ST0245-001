public class Contador {

    private int cuenta;
    private final String id;

    public Contador(String id){
        this.id = id;
    }

    public void incrementar(){
        cuenta += 1;
    }

    public void decrementar(){
        cuenta = cuenta - 1;
    }

    public int incrementos(){
        return cuenta;
    }

    @Override
    public String toString() {
        return "ID: " + id + " || " + "CUENTA: " + cuenta;
    }
}
