class Solution {
    public boolean validTree(int n, int[][] edges) {
        int length=edges.length;
        if(length!=n-1) return false;
        List<List<Integer>> adj= new ArrayList<>();
        boolean visited[]=new boolean[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        visited[0]=true;
        dfs(0, visited, adj);
        for(int i=0; i<n; i++){
            if(visited[i]==false){
                return false;
            }
        }
        return true;
    }
    public void dfs(int node, boolean visited[], List<List<Integer>> adj){
        
        for(int it: adj.get(node)){
            if(!visited[it]){
                visited[it]=true;
                dfs(it, visited, adj);
            }
        }
    }
}
