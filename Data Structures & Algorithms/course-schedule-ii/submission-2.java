class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new ArrayList<>();
        List<Integer> result= new ArrayList<>();
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
        
        while(!q.isEmpty()){
            int current= q.poll();
            result.add(current);
            
            for(int it: adj.get(current)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                    
                }
            }
        }
        if (result.size() == numCourses) {
            int[] order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = result.get(i);
            }
            return order;
        } else {
            return new int[0]; // cycle detected
        }
        
    }
}
