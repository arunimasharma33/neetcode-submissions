class Solution {
    public int maxArea(int[] heights) {
        // int maxArea=0;
        // int n= heights.length;
        // for(int i=0; i<n ; i++){
        //     for(int j=i+1; j<n; j++){
        //         int area= (j-i)*Math.min(heights[i], heights[j]);
        //         maxArea= Math.max(area, maxArea);
        //     }
        // }
        // return maxArea;

        int n= heights.length;
        int left=0;
        int right=n-1;
        int maxArea=0;
        while(left<right){
            int area=(right-left)*Math.min(heights[left], heights[right]);
            maxArea= Math.max(area, maxArea);
            if(heights[left]>heights[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
}
