import java.util.Arrays;

public class Q092_Backpack {
	/*******************************************************/
	// by Jackie using DP
	public int backPack(int m, int[] A) {
		if(m <= 0 || A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        Arrays.sort(A);
        int[][] dp = new int[n][n];
        int maxWeight = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; ++i){
        	if(A[i] <= m){
        		dp[i][i] = A[i];
        	}
        }
        
        for(int i = n-1; i >= 0; --i){
        	for(int j = i-1; j >= 0; --j){
        		if(dp[i][j+1] + A[j] <= m){
        			dp[i][j] = dp[i][j+1] + A[j];
        		}
        		else{
        			dp[i][j] = dp[i][j+1];
        		}
        		maxWeight = Math.max(maxWeight, dp[i][j]);
        	}
        }
        return maxWeight;
	}
	
	
	/*******************************************************/
	// by ninechapter using DP
	public int backPack2(int m, int[] A) {
        boolean f[][] = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i + 1][j] = f[i][j];
                if (j >= A[i] && f[i][j - A[i]]) {
                    f[i + 1][j] = true;
                }
            } // for j
        } // for i
        
        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }
        return 0;
    }
	
	
	/*******************************************************/
	// by Jackie using recursive, but time limit exceeded
	private int maxWeight = Integer.MIN_VALUE;
	public int backPack3(int m, int[] A) {
        // write your code here
        if(m <= 0 || A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; ++i){
        	helper(A, visited, i, m, 0);
        }
        return maxWeight;
    }
	
	public void helper(int[] A, boolean[] visited, int pos, int m, int weight){
		visited[pos] = true;
		for(int i = 0; i < A.length; ++i){
			if(visited[i] != true && weight + A[pos] <= m){
				maxWeight = Math.max(maxWeight, weight + A[pos]);
				helper(A, visited, i, m, weight + A[pos]);
			}
		}
		visited[pos] = false;		
	}

	
	public static void main(String[] args){
		Q092_Backpack t = new Q092_Backpack();
		int[] A = {3, 4, 8, 5};
		System.out.println(t.backPack2(10, A));
	}
}
