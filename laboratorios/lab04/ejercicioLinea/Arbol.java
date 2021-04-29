public class Arbol {
    private Nodo raiz;

    public Arbol() {
    }

    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    private void insertar(Nodo padre, int dato) {
        if (dato > padre.getDato()) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.imprimirDato();
        }
    }

    public void postorden() {
        this.postorden(this.raiz);
    }
}