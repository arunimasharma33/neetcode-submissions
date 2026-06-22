class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> components= new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u= edge[0];
            int v= edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[]= new boolean[n];
        for(int i=0; i<n ; i++){
            if(!visited[i]){
                ArrayList<Integer> component= new ArrayList<>();
                dfs(i, adj, visited, component);
                components.add(component);
            }
        }
        return components.size();
    }
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean visited[],ArrayList<Integer> component ){
            visited[i]=true;
            component.add(i);
            for(int it: adj.get(i)){
                if(!visited[it]){
                    dfs(it, adj, visited, component);
                }
            }
        }
}
