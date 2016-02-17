
public class Q392_House_Robber {
	/**********************************************************************/
	// by Jackie using DP, time complexity is O(n), space is O(1);
	public long houseRobber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        } else if(nums.length == 1){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        long ppProfit = nums[0];
        long pProfit = Math.max(nums[0], nums[1]);
        long maxProfit = 0;
        
        for(int i = 2; i < nums.length; ++i){
            maxProfit = Math.max(ppProfit + nums[i], pProfit);
            ppProfit = pProfit;
            pProfit = maxProfit;
        }
        return maxProfit;
	}
	
	
	/**********************************************************************/
	// by Jackie using DP, time complexity is O(n), space is O(n);
	public long houseRobber2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        } else if(nums.length == 1){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        long[] dp = new long[nums.length];  // the maximum profit until current house i;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        
        for(int i = 2; i < nums.length; ++i){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
