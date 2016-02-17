
public class Q428_Pow {
	// by Jackie using Divide & Conquer without recursion
	public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        boolean negativeFlag = (n < 0) ? true : false;
        if(negativeFlag == true){
            n = -n;
        }
        double res = 1;
        while(n > 1){
            if(n % 2 == 1){
                res *= x;
            }
            x = x * x;
            n /= 2;
        }
        
        if(negativeFlag == true){
            return 1 / (res * x);
        } else {
            return (res * x);
        }
    }
	
	
	
	// by Jackie using Divide & Conquer with recursion
	public double myPow2(double x, int n) {
        if(n == 0){
            return 1;
        }
        boolean negtiveFlag = (n < 0) ? true : false;
        if(negtiveFlag == true){
            n = -n;
            return 1 / helper(x, n);
        } else{
            return helper(x, n);
        }
    }
    
    public double helper(double x, int n){
        if(n == 0){
            return 1;
        } else if(n == 1){
            return x;
        }
        double res = 1;
        if(n % 2 == 1){
            res *= x;
        }
        res = res * helper(x, n/2) * helper(x, n/2);
        return res;
    }
    
    
    
    
    public static void main(String[] args){
    	Q428_Pow t = new Q428_Pow();
    	System.out.println(t.myPow(2, 3));
    }
}
