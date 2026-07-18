class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int maxVal= piles[0];
        for(int i=1; i<n; i++){
            if(piles[i]>maxVal){
                maxVal=piles[i];
            }
        }
        int left=1;
        int right=maxVal;
        while(left<right){
            int mid=(right+left)/2;
            if(canEat(mid, h, piles)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
    public boolean canEat(int k, int h, int[]piles){
        int n=piles.length;
        int hour=0;
        for(int i=0; i<n; i++){
            hour+=(piles[i]+k-1)/k;
        }
        if(hour<=h) return true;
        else return false;
    }
}
