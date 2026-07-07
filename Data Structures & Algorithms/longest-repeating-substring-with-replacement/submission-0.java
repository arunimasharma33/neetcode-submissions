class Solution {
    public int characterReplacement(String s, int k) {
        int n= s.length();
        int left=0;
        int maxFreq= 0;
        int maxWindow=0;
        HashMap<Character, Integer> map= new HashMap<>();
        for(int right=0; right<n; right++){
            char c= s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            maxFreq= Math.max(maxFreq, map.get(c));
            int window= right-left+1;
            //condition
            if(window-maxFreq > k){
                //shrink
                char charAtLeft= s.charAt(left);
                map.put(charAtLeft, map.get(charAtLeft)-1);
                left++;
            }
            window= right-left+1;
            maxWindow= Math.max(maxWindow, window);
        }
        return maxWindow;
    }
}
