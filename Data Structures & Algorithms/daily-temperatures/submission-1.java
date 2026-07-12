class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
       int[] result= new int[n];
    //    for(int left=0; left<n; left++){
    //     int count=1;
    //     for(int right=left+1; right<n; right++){
    //         if(temperatures[right]<=temperatures[left]){
    //             count++;
    //         }else{
    //             result[left]=count;
    //             break;
    //         }
    //     }
    //    }
    //    return result;

    // for(int left=0; left<n; left++){
    //     for(int right=left+1; right<n; right++){
    //         if(temperatures[right]>temperatures[left]){
    //             result[left]=right-left;
    //             break;
    //         }
    //     }
    // }
    // return result;





    Stack<Integer> s= new Stack<>();
    for(int i=n-1; i>=0; i--){
        
        while(!s.isEmpty() && temperatures[i]>=temperatures[s.peek()]){
            s.pop();
        }
        if(!s.isEmpty()){
            result[i]=s.peek()-i;
            
        }
        s.push(i);
    }
    return result;
    }
}
