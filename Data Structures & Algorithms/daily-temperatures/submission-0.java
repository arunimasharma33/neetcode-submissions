class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
       int[] result= new int[n];
       for(int left=0; left<n; left++){
        int count=1;
        for(int right=left+1; right<n; right++){
            if(temperatures[right]<=temperatures[left]){
                count++;
            }else{
                result[left]=count;
                break;
            }
        }
       }
       return result;
    }
}
