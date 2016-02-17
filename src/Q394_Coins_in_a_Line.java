
public class Q394_Coins_in_a_Line {
	// by ninechapter
	public boolean firstWillWin(int n) {
        if(n <= 0){
            return false;
        } else if(n <= 2){
            return true;
        }
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        dp[3] = false;
        for(int i = 4; i <= n; ++i){
            dp[i] = (dp[i - 2] && dp[i - 3]) || (dp[i -3] && dp[i - 4]);  // first拿1个，second拿1-2个； first拿2个，second拿1-2个
        }
        return dp[n];
    }
}
