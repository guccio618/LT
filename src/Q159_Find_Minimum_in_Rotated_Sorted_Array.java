
public class Q159_Find_Minimum_in_Rotated_Sorted_Array {
	// by Jackie
	public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return -1;
        }
        
        int left = 0, right = num.length - 1;
        int minValue = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = (left + right) / 2;
            minValue = Math.min(minValue, num[left]);
            minValue = Math.min(minValue, num[right]);
            minValue = Math.min(minValue, num[mid]);
            if(num[mid] > num[left] || num[mid] > num[right]){
                left = mid + 1;
            }
            else if(num[mid] < num[right] || num[mid] < num[left]){
                right = mid - 1;
            }
            else{
                right--;
            }
        }
        return minValue;
    }
}
