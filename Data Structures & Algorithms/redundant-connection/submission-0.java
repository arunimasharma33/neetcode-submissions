class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[]: edges){
            boolean visited[]= new boolean[n+1];
            int u= edge[0];
            int v= edge[1];
            if(dfs(u, v, visited, adj)){
                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[]{-1, -1};
    }
    public boolean dfs(int u, int v, boolean visited[], ArrayList<ArrayList<Integer>> adj){
        visited[u]=true;
        if(u==v) return true;
        for(int nb: adj.get(u)){
            if(!visited[nb] && dfs(nb, v, visited, adj)){
                return true;
            }
        }
        return false;
    }
}
