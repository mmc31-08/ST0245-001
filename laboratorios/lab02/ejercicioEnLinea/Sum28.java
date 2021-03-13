public class Sum28
{
    public boolean sum28(int[] nums){
        int totalSumArray = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i]==2){
                totalSumArray+=2;
            }
        }
        if (totalSumArray == 8){
            return true;
        }
        return false;
    }
}
