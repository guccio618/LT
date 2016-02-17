
public class Q005_Kth_Largest_Element {
	// by Jackie
	public int kthLargestElement(int k, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    
    public void quickSort(int[] nums, int left, int right){
        if(left < right){
            int m = partition(nums, left, right);
            quickSort(nums, left, m - 1);
            quickSort(nums, m + 1, right);
        }
    }
    
    public int partition(int[] nums, int left, int right){
        int i = left;
        int pivot = nums[right];
        int temp = 0;
        for(int j = left; j < right; ++j){
            if(nums[j] <= pivot){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
        return i;
    }
}
