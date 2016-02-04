import java.util.HashMap;


public class Q500_test {
	public int getLen(String str){
		int len = 1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); ++i){
			if(!map.containsKey(str.charAt(i))){
				map.put(str.charAt(i), i);
			} else{
				int l = i - map.get(str.charAt(i)) + 1;
				map.put(str.charAt(i), i);
				len = Math.max(len, l);
			}
		}
		return len;
	}
	
	
	public static void main(String[] args){
		Q500_test t = new Q500_test();
		System.out.println(t.getLen("abcdb"));
	}
}
