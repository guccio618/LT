import java.util.ArrayList;
import java.util.Arrays;


public class Q018_Subsets_II {
	// by Jackie
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] nums = new int[S.size()];
        for(int i = 0, size = S.size(); i < size; ++i){
            nums[i] = S.get(i);
        }
        Arrays.sort(nums);
        subsetHelper(res, list, nums, 0);
        return res;
    }
    
    public void subsetHelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] nums, int pos){
        res.add(new ArrayList(list));
        
        for(int i = pos; i < nums.length; ++i){
            if(i > pos && nums[i-1] == nums[i]){
                continue;
            }
            list.add(nums[i]);
            subsetHelper(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
