
public class Q141_Sqrt_x {
	// by Jackie
	public int sqrt(int x) {
        if(x == 0){
            return 0;
        }
        long left = 1, right = x;
        
       while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if(right * right <= x){
            return (int) right;
        } 
        else{
            return (int) left;
        }
    }
}
