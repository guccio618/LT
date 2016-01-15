
public class Q076_Longest_Increasing_Subsequence {
	public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int max = -1;
        int[] res = new int[len];
        res[0] = 0;
        
        for(int i = 1; i < len; ++i){
            for(int j = i-1; j >= 0; --j){
                if(nums[j] <= nums[i]){
                    res[i] = Math.max(res[i], res[j] + 1);
                    max = Math.max(max, res[i]);
                }
            }
        }
        return (max == -1) ? 1 : max + 1;
    }
	
	
	public static void main(String[] args){
		Q076_Longest_Increasing_Subsequence t = new Q076_Longest_Increasing_Subsequence();
		int[] nums = {10,1,11,2,12,3,11};
		System.out.println(t.longestIncreasingSubsequence(nums));
	}
}
