
public class Q457_Classical_Binary_Search {
	// by Jackie
	public int findPosition(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0 || target < A[0] || target > A[A.length-1]){
            return -1;
        }
        int left = 0, right = A.length-1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(target < A[mid]){
            	right = mid - 1;
            }
            else if(target > A[mid]){
                left = mid + 1;
            }
            else{
            	if(mid+1 < A.length && A[mid] == A[mid+1]){
            		left = mid + 1;
            		continue;
            	}
                return mid;
            }
        }
        return -1;
    }
}
