class Solution {
    public int countSubstrings(String s) {
        int length=s.length();
        
        int count=0;
        int left;
        int right;

        for(int i=0; i<length; i++){
            //even
            left=i-1;
            right=i;
            
            while(left >= 0 && right < length && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
               
            }
            //odd
            left=i;
            right=i;
            while(left >= 0 && right < length && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
                
            }
        }
        return count;
    }
}
