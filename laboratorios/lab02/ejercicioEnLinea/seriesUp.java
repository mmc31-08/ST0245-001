public class seriesUp
{
    public int[] seriesUp(int n) 
    {
        int[] arr = new int[n*(n+1)/2];
        int pos = 0;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= i; j++, pos++){
                arr[pos] = j;
            }
        }
        return arr;
    }
}
//O(n^2)
//n is the number of times to repeat the pattern