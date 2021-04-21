class Solution {
    static int[] dp;
    public int combinationSum4(int[] nums,int target) {
        dp = new int[target+1];
        dp[0] = 1;
        for(int i= 1; i <= target; i++){
            for(int num : nums){
                if(num <= i) dp[i] += dp[i-num];  //1:(1+0) 2:(2+0, 1+1, 0+2) 3:(3+0, 2+1, 1+2)
            }
        }
        return dp[target];
    }
    
}
