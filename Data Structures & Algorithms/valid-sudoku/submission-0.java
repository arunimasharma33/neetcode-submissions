class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length; //rows
        int m= board[0].length;
        for(int i=0;i<n; i++){
            HashSet<Character> set= new HashSet<>();
            for(int j=0; j<m; j++){
                if(board[i][j]!='.'){
                    
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
        }
        for(int j=0 ; j<m; j++){
            HashSet<Character> set= new HashSet<>();
            for(int i=0; i<n; i++){
                if(board[i][j]!='.'){
                    
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
        }
        //block
        for(int block=0; block<9; block++){
            HashSet<Character> set= new HashSet<>();
            for(int i=block/3 * 3 ; i<block/3*3 +3 ; i++){
                for(int j=block%3 *3 ; j<block%3 *3 +3 ; j++){
                    if(board[i][j]!='.'){
                    
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
                }
            }
        }
        return true;
    }
}
