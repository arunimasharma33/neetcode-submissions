class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        ArrayList<Integer> result= new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            int a=pre[0];
            int b= pre[1];
            adj.get(b).add(a);
        }
        int indegree[]= new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
                
            }
        }
        while(!q.isEmpty()){
            int current= q.poll();
            result.add(current);
            
                for(int it: adj.get(current)){
                    indegree[it]--;
                    if(indegree[it]==0){
                        q.add(it);
                    }
                }
            
        }
        return result.size()==numCourses;
    }
}
