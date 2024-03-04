


public class StringMetchingAlgo {
    private static int PRIME = 101 ;

    private static double HashCalculation (String st) {
        double hash = 0;
        for (int i =0 ;i < st.length() ;i++){
            hash +=  st.charAt(i) * Math.pow(PRIME, i) ;
        }
        return hash;
    }

    private static double updateHash (double prevHash , char oldChar , char newChar  , int length) {
        double newhash = (prevHash - oldChar) / PRIME ;
        newhash = (newhash  + newChar * Math.pow(PRIME, length -1)) ;

        return newhash ;
    }

    private static void  Search (String text , String pattern){
        int len = pattern.length() ;
        double patternHash  = HashCalculation(pattern);
        double textHash = HashCalculation(text.substring(0, len));

        for (int i=0 ; i<=text.length() - len ; i++){
            if (patternHash == textHash){
                if (text.substring(i , i +len).equals(pattern)){
                    System.out.println("pattern found at :" + i);
                }
            }

            if (i< text.length() - len) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt( i + len), len) ;
            }
        }
    }
    


    public static void main(String[] args) {
        Search("ApoorvkunalRahul" , "kunal");
    }
}
