public class TRIE {
    static class Node {
        Node [] child  ;
        boolean eow ;

        public Node(){
            child = new Node[26];
            for (int i = 0 ; i <26 ; i++){
                child[i]= null ;

            }
            eow  = false ;          
        }
    }

    static Node root = new Node() ;

    public static void insert (String word) {
         Node current = root ;
        for (int i = 0 ; i <word.length() ; i++){
            int index = word.charAt(i) - 'a' ;

            if(current.child[index] == null){
                current.child[index] = new Node() ;
            }

            if ( i== word.length()-1){
                current.child[index].eow = true ;
            }

            current = current.child[index];
        }
    }
        
    public static boolean search (String key) {
           Node current = root ;
        for (int i = 0 ; i < key.length() ; i++){
            int index = key.charAt(i) - 'a' ;
            Node node = current.child[index];

            if(node  == null){
               return false ;
            }

            if (i== key.length() - 1 && node.eow == false){
                return false ;

            }
            current = current.child[index];     
        }

        return true;    
    }

    public static boolean wordBreak (String key){
        if(key.length()==0){
            return true;
        }
        for (int i = 1 ; i <=key.length() ; i++){
                String firstPart = key.substring(0, i);
                String secondPart =key.substring(i);

            if (search(firstPart) && wordBreak(secondPart)){
                return true;
            }
        }
        return false ;
    }


    public static boolean startWith (String key) {
           Node current = root ;
        for (int i = 0 ; i < key.length() ; i++){
            int index = key.charAt(i) - 'a' ;
            Node node = current.child[index];

            if(node  == null){
               return false ;
            }

            current = current.child[index];     
        }

        return true;    
    }
    public static int NodeCount(Node root){
        int count =0 ;
        if(root == null){
            return count = 0;
        }

        for (int i = 0 ; i < 26 ;i++){
            if (root.child[i] != null){
                count += NodeCount(root.child[i]);
              
            }
        }
        return count +1 ;
    }
    public static String ans  = "";
    public static void longestWord (Node root  , StringBuilder temp){
        if (root== null){
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null && root.child[i].eow == true){
                temp.append((char)(i +'a'));
                if (temp.length() > ans.length()){
                    ans = temp.toString();                   
                }
                longestWord(root.child[i], temp);

                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
       /*  String Words [] = {"the", "a", "there" , "their", "any"};
        for (int i = 0 ; i < Words.length ; i++ ){
            insert(Words[i]);
        }

       System.out.println( search("their"));    */
    
    /*String arr[] = {"i" , "like" , "sam" , "samsung" , "mobile"};
    String key = "ilikesamsung ";
    for (int i = 0 ; i < arr.length ; i++ ){
        insert(arr[i]);
    }
    System.out.println(wordBreak(key));*/


  /*   String arr[] = {"i" , "like" , "sam" , "samsung" , "mobile"};
    String key = "mob";
    for (int i = 0 ; i < arr.length ; i++ ){
        insert(arr[i]);
    }
    System.out.println(startWith(key));
    */

    /*String str = "ababa" ;
    for (int i = 0; i < str.length(); i++) {
        String suffix = str.substring(i);
        insert(suffix);
    }
    System.out.println(NodeCount(root));
    */

    String word [] = {"a", "banana" , "ap" ,"app", "appleeyw", "apply", "appl"} ;
    for (int i = 0; i < word.length; i++) {
        insert(word[i]);
    }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
} 
}
