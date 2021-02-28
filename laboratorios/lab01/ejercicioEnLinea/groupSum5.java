public class groupSum5{
    public static void main(String[]args){
        int nums[] = new int[4];
        nums[0] = 2;
        nums[1] = 5;
        nums[2] = 10;
        nums[3] = 4;
        System.out.println(groupSum5(0, nums, 19));

    } 

    public static boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        if (nums[start] % 5 == 0) {
            if (start + 1 != nums.length && nums[start + 1] == 1) {
                return groupSum5(start + 2, nums, target - nums[start]);
            }else {
                return groupSum5(start + 1, nums, target - nums[start]);
            }
        }
        return (groupSum5(start + 1, nums, target - nums[start]) || groupSum5(start + 1, nums, target));
    }
}
//T(n) = T(n-1) + c1
//T(n) = c1n + c
//O(c1n + c)
//O(n)
