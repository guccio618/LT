
public class Q062_Search_in_Rotated_Sorted_Array {
	// by Jackie
	public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        
        int left = 0, right = A.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target == A[mid]){
                return mid;
            }
            if(A[mid] > A[left] || A[mid] > A[right]){
                if(target < A[mid] && target >= A[left]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else if(A[mid] < A[right] || A[mid] < A[left]){
                if(target > A[mid] && target <= A[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            else{
                right--;
            }
        }
        return -1;
    }
}
