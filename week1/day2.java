class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String s : strs){
            int[] counts = countZeroOnes(s);
            for(int i = m; i >= counts[0]; i--){ //0의 개수까지
                for(int j = n; j >= counts[1]; j--){
                    dp[i][j] = Math.max(1 + dp[i-counts[0]][j-counts[1]], dp[i][j]);
                }
            }      
        }
        return dp[m][n];           
    }
    static int[] countZeroOnes(String str){
        int[] res = new int[2];
        for(char ch : str.toCharArray()){
            res[ch-'0']++;
        }
        return res;
    }
}
