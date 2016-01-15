
public class Q458_Last_Position_of_Target {
	// by Jackie
	public int lastPosition(int[] A, int target) {
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
//                while(mid+1 < A.length && A[mid] == A[mid+1]){  // 如果遇到有很多重复数时速度太慢
//                    mid++;
//                }
            	if(mid+1 < A.length && A[mid] == A[mid+1]){
            		left = mid + 1;
            		continue;
            	}
                return mid;
            }
        }
        return -1;
    }
	
	public static void main(String[] args){
		Q458_Last_Position_of_Target t = new Q458_Last_Position_of_Target();
		int[] A = {1,2,2,4,5,5};
		System.out.println(t.lastPosition(A, 5));
	}
}
