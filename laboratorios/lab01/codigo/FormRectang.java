public class FormRectang{   
 public static int formRectang(int n){
        if(n<=2) return n;
        return formRectang(n-1) + formRectang(n-2);

    }
}