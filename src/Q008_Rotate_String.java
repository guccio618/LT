
public class Q008_Rotate_String {
	// by Ninechapter
	public void rotateString(char[] A, int offset) {
        // write your code here
         if (A == null || A.length == 0) {
            return;
        }
        
        offset = offset % A.length;
        reverse(A, 0, A.length - offset - 1);
        reverse(A, A.length - offset, A.length - 1);
        reverse(A, 0, A.length - 1);
        return;
    }
    
    private void reverse(char[] A, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
