class Solution {
    public List<String> generateParenthesis(int n) {
        
        ArrayList<String> result= new ArrayList<>();
        StringBuilder ds= new StringBuilder();
        backtracking(n,n , result, ds);
        return result;
    }
    public void backtracking(int open, int close ,ArrayList<String> result, StringBuilder ds){
       if(open==0 && close==0){
        result.add(ds.toString());
        return;
       }
       if(open>0){
        ds.append("(");
        backtracking(open-1, close, result, ds);
        ds.deleteCharAt(ds.length()-1);
       }
       if(close>open){
        ds.append(")");
        backtracking(open, close-1, result, ds);
        ds.deleteCharAt(ds.length()-1);
       }
        
    }
}
