
public class Q065_Median_of_two_Sorted_Arrays {
	// by Jackie
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // write your code here
        if( (nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0) ){
            return 0;
        }
        if(nums1 == null || nums1.length == 0){
            if(nums2.length == 1){
                return nums2[0];
            }
            else if(nums2.length % 2 == 0){
                return (nums2[nums2.length/2] + nums2[nums2.length/2-1]) / 2.0;
            }
            else{
                return nums2[nums2.length/2];
            }
        }
        if(nums2 == null || nums2.length == 0){
            if(nums1.length == 1){
                return nums1[0];
            }
            else if(nums1.length % 2 == 0){
                return (nums1[nums1.length/2] + nums1[nums1.length/2-1]) / 2.0;
            }
            else{
                return nums1[nums1.length/2];
            }
        }
        
        int len1 = nums1.length, len2 = nums2.length;
        double[] mergeNums = new double[len1 + len2];
        int len3 = len1 + len2;
        int x = 0, y = 0;
        for(int k = 0; k < len3; ++k){
            if(x < len1 && y >= len2){
                mergeNums[k] = nums1[x++];
            }
            else if(y < len2 && x >= len1){
                mergeNums[k] = nums2[y++];
            }
            else{
                if(nums1[x] < nums2[y]){
                    mergeNums[k] = nums1[x++];
                }
                else{
                    mergeNums[k] = nums2[y++];
                }
            }
        }
        
        for(int i = 0; i < len3; ++i)
        	System.out.print(mergeNums[i] + ", ");
        System.out.println();
        
        if(len3 % 2 == 0){
            return (mergeNums[len3/2] + mergeNums[len3/2-1]) / 2.0;
        }
        else{
            return mergeNums[len3/2];
        }
    }
	
	
	public static void main(String[] args){
		Q065_Median_of_two_Sorted_Arrays t = new Q065_Median_of_two_Sorted_Arrays();
		int[] nums1 = {1,2,3,4,5,6};
		int[] nums2 = {2,3,4,5};
		System.out.println(t.findMedianSortedArrays(nums1, nums2));
	}
}
