import java.util.Scanner;
public class PrincipalArbol{
     public static void main(String[] argumentos) {
        Scanner scan = new Scanner(System.in);
        Arbol arbol = new Arbol();
        System.out.println("Ingrese la cantidad de nodos a insertar: ");
        int cNodos = scan.nextInt(); 
        System.out.println("- Recorrido en postOrden -");
        
        for(int i = 0 ; i<cNodos; i++){
            int nodo;
            System.out.println("Ingrese el Nodo: ");
            nodo = scan.nextInt();
            arbol.insertar(nodo);
            
        }
        arbol.postorden();
    }
}
