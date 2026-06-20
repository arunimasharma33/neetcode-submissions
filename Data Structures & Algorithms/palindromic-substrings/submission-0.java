class Solution {
    public int countSubstrings(String s) {
        int length=s.length();
        if(length==0) return 0;
        if(length==1) return 1;
        int count=1;
        int left;
        int right;

        for(int i=1; i<length; i++){
            //even
            left=i-1;
            right=i;
            while(s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
                if(left==-1 || right==length) break;
            }
            //odd
            left=i;
            right=i;
            while(s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
                if(left==-1 || right==length) break;
            }
        }
        return count;
    }
}
