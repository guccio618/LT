
public class Q462_Total_Occurrence_of_Target {
	// by Jackie
	public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0 || target < A[0] || target > A[A.length - 1]){
            return 0;
        }
        int left = 0, right = A.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target > A[mid]){
                left = mid + 1;
            }
            else if(target < A[mid]){
                right = mid - 1;
            }
            else{
                int start = mid, end = mid;
                while(start - 1 >= 0 && A[start - 1] == A[start]){
                    start--;
                }
                while(end + 1 < A.length && A[end] == A[end + 1]){
                    end++;
                }
                return (end - start + 1);
            }
        }
        return 0;
    }
}
