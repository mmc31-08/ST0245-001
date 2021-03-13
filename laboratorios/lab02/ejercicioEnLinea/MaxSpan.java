public class MaxSpan
{
    public int maxSpan(int[] nums) {
        int cont = 0;
        int varMax = 0;

        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    cont = j-i+1;
                    varMax = Math.max(cont, varMax);
                }
            }
        }
        return varMax;
    }
}
