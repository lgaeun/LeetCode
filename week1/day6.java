class Solution {
    public int minOperations(int n) {
//         1.처음 푼 방법: O(n/2)
//         int mid = n/2;
//         int res = n%2==0? 2*mid: 2*mid+1;
//         int ans = 0;
//         for(int i = mid; i < n; i++)
//             ans += (2*i+1)-res;
        
//         return ans;
        
        //2. O(1)풀이
        if(n%2==1){ // Odd Case
		    int N = (n - 1) / 2;  // number of elements before mid element
		    return N * (N + 1); 
    	}
	    int N = n / 2;  // number of elements before mean of mid elements
	    return N * N; 
        
        //3. 또다른 O(1)풀이
        return n * n / 4;
        
    }
}
