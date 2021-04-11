class Solution {
    static int n,m;
    static int[][] dp;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        m = matrix.length; n = matrix[0].length;
        dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                max = Math.max(max, solve(matrix, i, j));
        }
        return max;
    }
    static int solve(int[][] mat, int x, int y){
        if(dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx >= m || ny<0 || ny>=n || mat[nx][ny] <= mat[x][y]) continue;
            dp[x][y] = Math.max(dp[x][y], solve(mat,nx,ny) + 1);
        }
        return dp[x][y];
    }
}

// time: O(nm), space: O(nm)
