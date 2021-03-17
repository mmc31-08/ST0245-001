public class MiArrayList {
    private int size;
    private static final int DEFAULT_SIZE = 10;
    private int array[];

    public void MiArrayLis() {
        array = new int[DEFAULT_SIZE];
        size = 0;
    }
    public int size() {
        return size;
    }

    public void add(int e) {
        add( size, e);
    }

    public int get(int i) {
        if (i < size || i > 0) {
            return array[i];
        }else {
            throw new IndexOutOfBoundsException("Index : " + i);
        }
    }

    public void add(int index, int e) {
        if (index< size && index >= 0) {

            for (int i = 0; i <= size; i++) {
                if (i == size && size == array.length) {
                    extend();
                }
                if (i == index) {
                    int swap = array[i];
		            array[i] = e;
                    array[i + 1] = swap;
                    i++;
                    size++;
                }
            }
        }else if ( index==size ) {
            array[index] = e;
            size++;
            if (size == array.length) {
                extend();
            }
        }
    }

    private void extend() {
        int [] array2 =  new int[array.length + 10 ];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }
}

