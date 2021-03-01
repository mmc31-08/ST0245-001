
public class Taller5 {      
    public static int suma (int[]array){
        int totalSumArray = 0;
        for (int i = 0; i <array.length ; i++ ) {
            totalSumArray += array[i];
        }
        return totalSumArray;
    }
    public static void mul (int num){
        for(int i = 1; i<=10; i++){
            System.out.println(num + " * " + i + " : " + num*i);                                                     
        }
    }   
    public static int[] insertionSort (int[] array){
        int temp;
        for(int i = 1; i<array.length; i++){
            for(int j = i; j>0; j--){
                if(array[j]<array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        } 
        return array;
    }    
}