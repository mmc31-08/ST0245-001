public class centeredAverage{
        public int centeredAverage(int[] nums) {
        int cont = 0;
        int vMax = nums[0];
        int vMin = nums[0];

        for(int i=0; i<nums.length;i++){
            cont+=nums[i];
            vMin = Math.min(vMin, nums[i]);
            vMax = Math.max(vMax, nums[i]);
        }
        return (cont-vMax-vMin)/(nums.length-2);
    }
    //O(n)
    // n corresponde a la longitud del arreglo
}
