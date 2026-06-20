class Solution {
    public String longestPalindrome(String s) {
        int length= s.length();
        if(length<=1) return s;
        int left;
        int right;
        String result="";
        for(int i=1; i<length; i++){
            //even
            left=i-1;
            right=i;
            while(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                if(left==-1 || right==length) break;
            }
            String palindrome= s.substring(left+1, right);
            if(result.length()<palindrome.length()){
                result= palindrome;
            }
            //odd
            left=i;
            right=i;
            while(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                if(left==-1 || right== length) break;
            }
            palindrome= s.substring(left+1, right);
            if(result.length()<palindrome.length()){
                result= palindrome;
            }
        } 
        return result;
    }
}
