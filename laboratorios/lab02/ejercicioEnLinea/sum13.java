public class sum13
{
       public int sum13(int[] nums) {
        int sum = 0;
        int i = 0;
        if(nums.length==0){
            return 0;
        }
        while(i<nums.length){
            if(nums[i]==13){
                i+=2;
            }else{
                sum+=nums[i];
                i++;
            }
        }
        return sum;
    }
    //O(n)
    //n correspode al numero de elementos del arreglo nums
}
