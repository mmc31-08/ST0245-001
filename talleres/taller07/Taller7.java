import java.lang.IndexOutOfBoundsException;
// Una lista simplemente enlazada
public class Taller7{
    Node first;
    private int size;

    public Taller7()
    {
        size = 0;
        first = null;
    }


    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size(){
        return size;
    }

    // Inserta un dato en la posición index
    public void add(int data, int index){
        if (index == 0) {
            Node nuevo = new Node(data);
            nuevo.next = first;
            first = nuevo;
            size++;
        } else if(index != 0){
            Node temp = getNode(index - 1);
            Node nuevo = new Node(data);
            nuevo.next = temp.next;
            temp.next = nuevo;
            size++;
        }else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    // Borra el dato en la posición index
    public void remove(int index){
        try {
            if (index == 0) {
                Node temp = first;
                first = temp.next;
                size--;
            } else if (index == size - 1) {
                Node temp = getNode(size - 2);
                temp.next = null;
                size--;
            } else {
                Node temp = getNode(index - 1);
                temp.next = temp.next.next;
                size--;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La posicion no existe");
        }

    }

    // Verifica si está un dato en la lista
    public boolean contains(int data){
        for (int i=0;i<size;i++){
            if(get(i)==data){
                return true;
            }
        }
        return false;
    }
}
