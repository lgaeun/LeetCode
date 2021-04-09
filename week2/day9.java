class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(compare(0,words[i], words[j], order) > 0) return false;
            }
        }
        return true;
    }
  
    static int compare(int idx, String s, String t, String order){ // recursive
        if(idx == s.length() || idx == t.length()){  //if length of two string are diff or reach end
            if(s.length() < t.length()) return -1;
            if (s.length() > t.length()) return 1;
            return 0;
        }
        
        if(order.indexOf(s.charAt(idx)) < order.indexOf(t.charAt(idx))) return -1;
        if(order.indexOf(s.charAt(idx)) > order.indexOf(t.charAt(idx))) return 1;
        
        return compare(idx+1, s, t, order);  
    }
    
}
