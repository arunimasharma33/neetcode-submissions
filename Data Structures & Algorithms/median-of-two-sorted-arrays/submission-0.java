class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;
        int[] nums= new int[n+m];
        int left=0;
        int right=0;
        int main=0;
        while(left<n && right<m){
            if(nums1[left]<=nums2[right]){
                nums[main]=nums1[left];
                left++;
                main++;
            }
            else if(nums1[left]>nums2[right]){
                nums[main]=nums2[right];
                right++;
                main++;
            }
        }
        while(left<n){
            nums[main]=nums1[left];
                left++;
                main++;
        }
        while(right<m){
            nums[main]=nums2[right];
            right++;
            main++;
        }
        if((m+n)%2!=0){
            int ind=(m+n)/2;
            return (double)nums[ind];
        }else{
            int ind=(m+n)/2;
            double val=((double)nums[ind]+(double)nums[ind-1])/2;
            return val;
        }
    }
}
