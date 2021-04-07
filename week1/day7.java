class Solution {
    public boolean halvesAreAlike(String s) {
        int voweldiff = 0, mid = s.length()/2;
        for(int i = 0; i < mid; i++){
            voweldiff += check(s.charAt(i)) - check(s.charAt(mid+i));
        }        
        return voweldiff==0;
    }
    static int check(char c){
       if (c=='A' || c=='E' || c=='I' || c=='O' || c=='U' || c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return 1;
        else return 0;
    }
}
