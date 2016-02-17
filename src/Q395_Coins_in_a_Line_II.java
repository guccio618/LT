
public class Q395_Coins_in_a_Line_II {
	// by ninechater
	public boolean firstWillWin(int[] values) {
        if(values == null || values.length == 0){
            return false;
        } else if(values.length <= 2){
            return true;
        }
        int []dp = new int[values.length + 1];
        int sum = 0;
        for(int now : values) 
            sum += now;
        
        dp[0] = 0;
        dp[1] = values[values.length-1];
        dp[2] = values[values.length-1] + values[values.length-2];
        dp[3] = values[values.length-2] + values[values.length-3]; 
        
        for(int i = 4; i <= values.length; ++i){  // 内层必须是用Math.min
            dp[i] = Math.max(Math.min(dp[i - 2], dp[i - 3]) + values[values.length - i], Math.min(dp[i - 3], dp[i - 4]) + values[values.length - i] + values[values.length - i + 1]);
        }
        
        return sum < 2 * dp[values.length];
    }
}
