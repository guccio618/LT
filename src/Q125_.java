public class Q125_ {
	// by other using DP
	public int backPackII(int capacity, int[] size, int[] value) {
		int[][] res = new int[size.length + 1][capacity + 1];
		res[0][0] = 0;
		for (int i = 1; i <= size.length; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (j - size[i - 1] < 0)
					res[i][j] = res[i - 1][j];
				if (j - size[i - 1] >= 0) {
					res[i][j] = Math.max(res[i - 1][j], res[i - 1][j
							- size[i - 1]]
							+ value[i - 1]);
				}
			}
		}

		return res[size.length][capacity];
	}
}
