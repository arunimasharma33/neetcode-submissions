class Solution {
    
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        if(n==0) return;
        for(int i=0; i<n; i++){
            dfs(i, 0, board);
            dfs(i, m-1, board);
        }
        for(int i=0; i<m; i++){
            dfs(0, i, board);
            dfs(n-1, i, board);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                if(board[i][j]=='O') board[i][j]='X'; 
                if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }
    public void dfs(int row, int col, char[][] board) {
    int n = board.length;
    int m = board[0].length;

    // Base case: out of bounds or not 'O'
    if (row < 0 || col < 0 || row >= n || col >= m || board[row][col] != 'O') {
        return;
    }

    board[row][col] = '#'; // mark safe

    // Explore neighbors
    dfs(row + 1, col, board);
    dfs(row - 1, col, board);
    dfs(row, col + 1, board);
    dfs(row, col - 1, board);
}
}
