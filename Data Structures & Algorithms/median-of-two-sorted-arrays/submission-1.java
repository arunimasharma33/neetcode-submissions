class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        if(n>m){
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalLeft=(n+m+1)/2;
        int left=0;
        int right=n;
        while(left<=right){
            int i=(left+right)/2;
            int j=totalLeft-i;

            int left1max= (i==0)? Integer.MIN_VALUE : nums1[i-1];
            int left2max= (j==0)? Integer.MIN_VALUE : nums2[j-1];
            int right1min= (i==n)? Integer.MAX_VALUE : nums1[i];
            int right2min= (j==m)? Integer.MAX_VALUE : nums2[j];

            if(left1max<=right2min && left2max<=right1min){
                if((n+m)%2 !=0 ){
                    return (double)Math.max(left1max,left2max);
                }else{
                    return (Math.max(left1max, left2max)+ Math.min(right1min, right2min))/2.0;
                }
            }else if(left1max>right2min){
                right=i-1;
            }else{
                left=i+1;
            }
        }
        return -1;
    }
}
