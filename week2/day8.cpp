//1. recursive
vector<string> mappings = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}, ans;    
vector<string> letterCombinations(string digits) {
	if(digits == "") return ans;         // no combinations formed without any digits
	helper(digits, 0, "");              
	return ans;
}
// recursive helper function
void helper(string &digits, int i, string combi){	
	if(i == size(digits)) {  // base condition - push when we have recursed for all digits
		ans.push_back(combi);    
		return;
	}
	// add and recurse for each character (chosen from current digit-charcter mapping)
	for(auto &c : mappings[digits[i] - '2'])
		helper(digits, i + 1, combi + c);
}

//2. backtrack
vector<string> mappings = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}, ans;
vector<string> letterCombinations(string digits) {
	if(digits == "") return {};        
	string combination = "";
	helper(digits, 0, combination);
	return ans; 
}
//                  passing by reference ⬇️ so copies are not made at each function call
void helper(string &digits, int i, string &combi){
	if(i == size(digits)) {
		ans.push_back(combi);    
		return;
	}
	for(auto &c : mappings[digits[i] - '2']){
		combi.push_back(c);            // add a character from mappings for current position,
		helper(digits, i + 1, combi);  // and recurse for next positions
		combi.pop_back();              // backtrack
	}   
}

// Time Complexity : O(4^N*N), where N, is the length of input string. 
// 4^N for building every possible string combination and N to form the string by joining each character.
// Here, 4 is chosen assuming the worst case where each digit will be 7 or 9 and we would have 4*4*4*4 total string combinations.

// Space Complexity : O(N), the max recursion depth will be N, where N is the length of input string. 
// If the space required for ans is considered as well, the complexity will be O(4^N).
