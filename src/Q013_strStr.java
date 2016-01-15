
public class Q013_strStr {
	// by Jackie
	public int strStr(String source, String target) {
        //write your code here
        if(source == null || target == null) {
            return -1;
        }
        if(source.length() < target.length()){
            return -1;
        }
        if(source.length() == 0 || target.length() == 0){
            return 0;
        }
        
        int sLen = source.length(), tLen = target.length();
        for(int i = 0; i < sLen - tLen + 1; ++i){
            int j = 0;
            for( ; j < tLen; ++j){
                if(source.charAt(i+j) != target.charAt(j))
                    break;
            }
            if(j == tLen){
                return i;
            }
        }
        return -1;
    }
}
