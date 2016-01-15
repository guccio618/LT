
public class Q063_Search_in_Rotated_Sorted_Array_II {
	// by Jackie
	public boolean search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return false;
        }
        int left = 0, right = A.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid] == target){
                return true;
            }
            else if(A[mid] > A[left] || A[mid] > A[right]){
                if(target < A[mid] && target >= A[left]){   // 注意有等号，>=
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else if(A[mid] < A[right] || A[mid] < A[left]){
                if(target > A[mid] && target <= A[right]){  // 注意有等号，<=
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
        return false;
    }
	
	
	public static void main(String[] args){
		Q063_Search_in_Rotated_Sorted_Array_II t = new Q063_Search_in_Rotated_Sorted_Array_II();
		int[] A = {9,5,6,7,8,9,9,9,9,9,9};
		System.out.println(t.search(A, 8));
	}
}
