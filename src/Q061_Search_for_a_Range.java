
public class Q061_Search_for_a_Range {
	// by Jackie
	public int[] searchRange(int[] A, int target) {
        int res[] = {-1, -1};
        if(A == null || A.length == 0 || target < A[0] || target > A[A.length - 1]){
            return res;
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
                int pos = mid;
                while(pos-1 >= 0 && A[pos-1] == A[pos]) --pos;
                res[0] = pos;
                pos = mid;
                while(pos+1 < A.length && A[pos+1] == A[pos]) ++pos;
                res[1] = pos;
                return res;
            }
        }
        return res;
    }
}
