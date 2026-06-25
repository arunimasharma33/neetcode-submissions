class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new ArrayList<>();
        int result[]= new int[numCourses];
        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            int u= pre[0];
            int v=pre[1];
            adj.get(v).add(u);
        }
        int indeg[]= new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int it: adj.get(i)){
                indeg[it]++;
            }
        }
        for(int i=0; i<numCourses; i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int i=0;
        while(!q.isEmpty() && i<numCourses){
            int current= q.poll();
            result[i]=current;
            i++;
            for(int it: adj.get(current)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                    
                }
            }
        }
        return i == numCourses ? result : new int[0];
    }
}
