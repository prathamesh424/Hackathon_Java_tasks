class Solution23 {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1 ;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                boolean find = true;
                for (int j = 1 ; j < needle.length(); j++) {
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        find = false;
                        break;
                    }                  
                }

                if(find){
                    return i;
                }
            }
            
        }
        return -1;
    }
}



public class reverseLL {
    public static void main(String[] args) {
        
    }
    
}
