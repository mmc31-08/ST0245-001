public class Lcs{
    public static int lcsDNA(String s1, String s2, int n, int m){
        if (n==0 || m==0) {return 0;}
        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return 1 + lcsDNA(s1,s2, n-1, m-1);
        }
        return Math.max(lcsDNA(s1, s2, n, m-1), lcsDNA(s1, s2, n-1, m ) );
    }
}