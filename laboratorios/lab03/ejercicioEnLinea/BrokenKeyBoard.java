package labs;

import java.util.LinkedList;
public class BrokenKeyBoard {
    public static void brokenKeyBoard(String a){
        LinkedList<String>text = new LinkedList<>();

        int i = 0;
        int j = 0;
        boolean end = true;

        while(i<a.length()){
            if(a.charAt(i)=='[' || a.charAt(i)==']'){
                if(a.charAt(i)=='['){
                    end = false;
                }else if(a.charAt(i)==']'){
                    end = true;
                }
                j=i+1;
            }else if(Character.isLetter(a.charAt(i)) && ((a.charAt(i)=='[' || a.charAt(i)==']') || (i+1 == a.length()))){
                if(end){
                    text.addLast(a.substring(j,i));
                }else{
                    text.addFirst(a.substring(j,i));
                }
            }
            i++;
        }
    }
}


//Comvertir text a string

