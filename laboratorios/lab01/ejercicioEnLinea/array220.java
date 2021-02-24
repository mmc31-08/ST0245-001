public class array220{
    public boolean array220(int[] nums, int index) {
        if(nums.length-1 <=index){
            return false;
        }
        if(nums[index+1] == nums[index] *10){
            return true;
        }
        return array220(nums, index+1);
    }
}