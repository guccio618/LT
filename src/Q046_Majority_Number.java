import java.util.ArrayList;


public class Q046_Majority_Number {
	// by Jackie
	public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0){
            return 0;
        }
        int res = 0, count = 0, len = nums.size();
        for(int i = 0; i < len; ++i){
            int num = nums.get(i);
            if(num == res){
                count++;
            }
            else if(count == 0){
                res = num;
            }
            else{
                count--;
            }
        }
        
        count = 0;
        for(int i = 0; i < len; ++i){
            if(nums.get(i) == res){
                count++;
            }
        }
        if(count > len / 2){
            return res;
        }
        else{
            return -1;
        }
    }
	
	// 也可以用另一个方法： Arrays.sort(nums), 然后选取nums[len/2+1]; O(n*logn)
}
