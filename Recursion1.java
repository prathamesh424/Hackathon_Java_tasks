import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion1 {
    public static void main(String[] args) {     
    subserq("", "abc");

    System.out.println(lsubset("", "cba"));

    System.out.println(ASCIIsubset("", "abc"));

    //1:-
        int [] arr =  {1,2,3,4,5};
        System.out.println(numsubset(arr));


        //2 :-
        List<List<Integer>> ans = numsubset(arr);
        for (List <Integer> list : ans ){
            System.out.println(list);
        }


        // for duplicate :-
        int [] arr1 =  {2,1,2};
        List<List<Integer>> ans1 = numsubsetDuplicate(arr1);
        for (List <Integer> list : ans1){
            System.out.println(list);
        }
        System.out.println(numsubsetDuplicate(arr1));

        // permutations :-
        parmutations("","abc");

       System.out.println( parmutationslist("", "abc"));

        // in list form 

        digitalpha("", "12");
        System.out.println(digitalphalist("", "123"));

        // count of above :=
        System.out.println(digitalphacount("", "12"));

        // dice ;-

        dice("", 4);
        System.out.println(dicelist("", 4));

    }


















    // sub set making
    static void subserq (String p , String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c = up.charAt(0);
        subserq(p+c, up.substring(1));
        subserq(p, up.substring(1));
    }


    // sub set returing in arraylist

    static ArrayList<String> lsubset (String empty , String Tochange){
      
        if (Tochange.isEmpty()){
            ArrayList<String> l1 = new ArrayList<>();
            l1.add(empty);
            return l1;
        }

        char c = Tochange.charAt(0);

        ArrayList <String> left = lsubset(c+empty, Tochange.substring(1));
        ArrayList <String> right = lsubset(empty, Tochange.substring(1));
        left.addAll(right);
        return left;


    }

    // return with ASCII value :=
     static ArrayList<String> ASCIIsubset (String empty , String Tochange){
      
        if (Tochange.isEmpty()){
            ArrayList<String> l1 = new ArrayList<>();
            l1.add(empty);
            return l1;
        }

        char c = Tochange.charAt(0);

        ArrayList <String> first = ASCIIsubset(c+empty, Tochange.substring(1));
        ArrayList <String> second = ASCIIsubset(empty, Tochange.substring(1));
        ArrayList <String> third = ASCIIsubset((empty) + (c + 0), Tochange.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;

   }

   // by iterrative process :- 

   static List<List<Integer>> numsubset (int [] arr){
    List<List<Integer>> Outer = new ArrayList<>();
    Outer.add(new ArrayList<>());

    for (int num : arr){
        int n = Outer.size();
        for (int i = 0; i < n; i++) {
            List <Integer> Inner = new ArrayList<>(Outer.get(i));
            Inner.add(num);
            Outer.add(Inner);      
        }
    }

    return Outer;
   }


   // above for duplicate 
   static List<List<Integer>> numsubsetDuplicate (int [] arr){
    List<List<Integer>> Outer = new ArrayList<>();
    Outer.add(new ArrayList<>());
    Arrays.sort(arr);
    int start = 0 ;
    int end = 0;
    for (int i = 0; i < arr.length; i++) {
         start = 0;
        if (i > 0 && arr[i]==arr[i-1]){
            start = end -1 ;

        }
        end  =Outer.size()-1 ;
        int n = Outer.size();
        for (int j = start; j < n; j++) {
            List <Integer> Inner = new ArrayList<>(Outer.get(j));
            Inner.add(arr[i]);
            Outer.add(Inner);      
        }
    }

    return Outer;
   }





   // parmutations :-

   static void parmutations (String p  , String up){
    if (up.isEmpty()){
        System.out.println(p);
        return;
    }

    char ch = up.charAt(0);

    for (int i = 0; i <= p.length(); i++) {
        String f = p.substring(0 , i);
        String s = p.substring(i ,p.length());
        parmutations(f+ch+s, up.substring(1));
        
    }
   }


   static ArrayList<String> parmutationslist (String p  , String up){
    if (up.isEmpty()){
       ArrayList<String> list = new ArrayList<>();
        list.add(p);
        return list ;
    }
    char ch = up.charAt(0);
      ArrayList<String> ans  = new ArrayList<>();
    for (int i = 0; i <= p.length(); i++) {
        String f = p.substring(0 , i);
        String s = p.substring(i ,p.length());
       ans.addAll( parmutationslist(f+ch+s, up.substring(1)));
        
    }
    return ans ;
   }


        // mobile digit pad conversion :-
   static void digitalpha (String p , String up){
    if (up.isEmpty()){
        System.out.println(p);
        return;
    }  
    
    int digit = up.charAt(0) - '0' ;      // to convert '2' into 2

    for (int i = (digit-1)* 3; i < digit *3; i++) {
        char ch = (char) ('a' + i );
        digitalpha(p+ch, up.substring(1));     
    }
   }


   //list form of above 
static ArrayList <String> digitalphalist (String p , String up){
    if (up.isEmpty()){
        ArrayList<String > list = new ArrayList<>();
        list.add(p);
        return list ;
    }  
    int digit = up.charAt(0) - '0' ;      // to convert '2' into 2

    ArrayList<String> ans = new ArrayList<>();

    for (int i = (digit-1)* 3; i < digit *3; i++) {
        char ch = (char) ('a' + i );
        ans.addAll(digitalphalist(p+ch, up.substring(1)));     
    }
    return ans ;
}


        // counting only permutation:- 
    static int digitalphacount (String p , String up){
    if (up.isEmpty()){
       
        return 1 ;
    }  
    int digit = up.charAt(0) - '0' ;      // to convert '2' into 2
    int count = 0 ;
    for (int i = (digit-1)* 3; i < digit *3; i++) {
        char ch = (char) ('a' + i );
        count = count +digitalphacount(p+ch, up.substring(1));     
    }
    return count ;
   }



   // dice target finding ;-

   static void dice (String p , int target){
    if (target == 0){
        System.out.println(p);
        return;
    }
    for (int i = 1; i <= 6  && i <= target; i++) {
        dice(p +i, target -i);    
    }
   }


    //list 
static ArrayList <String > dicelist (String p , int target){
    if (target== 0){
        ArrayList<String  > list = new ArrayList<>();
        list.add(p);
        return list;
    }
     ArrayList<String > list = new ArrayList<>();

    for (int i = 1; i <= 6  && i <= target; i++) {   
        list.addAll(dicelist(p +i, target -i));
    }
    return list ;
}


}

