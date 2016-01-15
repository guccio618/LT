
public class Q014_First_Position_of_Target {
	// by Jackie
	public int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(target > nums[mid]){
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
            else{
                while(mid-1 >= 0 && nums[mid-1] == nums[mid]) --mid;
                return mid;
            }
        }
        return -1;
    }
}
