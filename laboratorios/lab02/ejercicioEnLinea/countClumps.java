public class countClumps
{
    public int countClumps(int[] nums) {
        int cont= 0;
        boolean clump = false;
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(clump)
            {
                if(nums[i] != nums[i+1])
                    clump = false;
            }
            else if(nums[i] == nums[i+1])
            {
                clump = true;
                cont++;
            }
        }
        return cont;
    }
}
//O(n)
//n is the number of values ​​in the array