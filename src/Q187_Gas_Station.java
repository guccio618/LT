
public class Q187_Gas_Station {
	public int canCompleteCircuit(int[] gas, int[] cost) {
         if(gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length){
             return -1;
         }
         int startIndex = 0, endIndex = 1;
         int n = gas.length;
         int profit = gas[startIndex] - cost[startIndex];
         
         while(++startIndex < n){
        	 profit = gas[startIndex] - cost[startIndex];
        	 if(profit >= 0){
        		 break;
        	 }
         }
         
         if(startIndex == n){
        	 return -1;
         } else{
        	 endIndex = (startIndex + 1) % n;
         }        
        
         while(n > 1 && startIndex != endIndex){
             if(profit >= 0){
                 profit += gas[endIndex] - cost[endIndex];
                 endIndex = (endIndex + 1) % n;
             } else{
                 startIndex = (startIndex == 0) ? n - 1 : startIndex - 1;
                 profit += gas[startIndex] - cost[startIndex];
             }
         }
         return (profit >= 0) ? startIndex : -1;
	}
	
	
	public static void main(String[] args){
		Q187_Gas_Station t = new Q187_Gas_Station();
		int[] gas = {0,4,1,3};
		int[] cost = {1,1,4,1};
		System.out.println(t.canCompleteCircuit(gas, cost));
	}
}
