class Solution {
public:
    bool halvesAreAlike(string s) {
        int voweldiff = 0, mid = size(s)/2;
        for(int i = 0; i < mid; i++)
            voweldiff += check(s[i]) - check(s[i+mid]);
        return !voweldiff;
    }
    bool check(char &c){
        return c == 'a' || c == 'e' || c =='i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
};

// time: O(n), space: O(1)
