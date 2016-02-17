import java.util.PriorityQueue;
import java.util.Queue;


public class Q081_Data_Stream_Median {
	public int[] medianII(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        
        Queue<Integer> maxHeap = new PriorityQueue<Integer>();
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        int median = nums[0];
        int len = nums.length;
        int[] res = new int[len];
        res[0] = median;
        
        for(int i = 1; i < len; ++i){
        	if (nums[i] < median) {
                maxHeap.add(-nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(median);
                median = -maxHeap.poll();
            } else if (maxHeap.size() + 1 < minHeap.size()) {
                maxHeap.add(-median);
                median = minHeap.poll();
            }
            res[i] = median;
        }       
        return res;
    }
	
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5};
		Q081_Data_Stream_Median t = new Q081_Data_Stream_Median();
		int[] res = t.medianII(nums);
		
		for(int i = 0; i < res.length; ++i){
			System.out.print(res[i] + ", ");
		}
	}
}
