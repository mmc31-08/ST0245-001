public class Taller2 {
    public static int gcd(int p, int q){
        if(p%q==0)
            return q;
        return gcd(q, p%q);
    }

    public static boolean sumaGrupo(int[] nums, int target){
        return SumaGrupo ( 0 , nums, target);
    }

    private static boolean SumaGrupo(int start, int[] nums, int target){
        if (start == nums.length)
            if (target == 0)
                return true;
            else
                return false;
        //else
        boolean respuestaSi = SumaGrupo(start+1,nums,target - nums[start]);
        boolean respuestaNo = SumaGrupo(start+1,nums,target);
        return respuestaSi || respuestaNo;
    }

    public static void combinations(String s){


    }

    private static void combinationsAux(String prefix, String s){


    }


}
