
import java.util.*;


public class Day39 {

    /*Question 1 : Apply Merge sort to sort an array of Strings. (Assume that all the characters in
                all the Strings are in lowercase). */
    
        static String[] StringMergeSort(String [] arr){
            if (arr.length <= 1){
                return arr;
            }
        
            int mid = arr.length / 2 ;
            String [] left = StringMergeSort(Arrays.copyOfRange(arr, 0 , mid));
            String [] right = StringMergeSort(Arrays.copyOfRange(arr, mid, arr.length));
            return Merge(left, right);
        }
                
                  
        private static String [] Merge (String [] first , String [] second){
                String [] mix = new String [first.length + second.length] ;
                int i = 0;
                int j = 0;
                int k = 0;
            
        
                while( i < first.length &&   j < second.length){
                    String s1 = first[i] ;
                    String s2 = second[j] ;
                    int len = Math.min(s1.length(), s2.length());
                    for (int m =0 ;  m < len  ; m++) {
                        if (s1.charAt(m) == s2.charAt(m)) continue ;
                        else if  (s1.charAt(m)  > s2.charAt(m)){
                            mix[k++] = s2 ;
                            j++;
                        }
                        else {
                            mix[k++]= s1 ; 
                            i++ ;
                         }
                         break ;
                    }
                }
        
                while(i < first.length){
                    mix[k] = first[i];
                    k++;
                    i++;
                }
                
                while(j < second.length ){
                    mix[k] = second[j];
                    k++;
                    j++;
                }
                
                return mix ;
            
        }

    

    /*Question 2 : Given an array nums of size n, return the majority element. (MEDIUM)
        The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume
        that the majority element always exists in the array. */


        // shortcut  :- (by given condition using Logic ......)
        public  static int majorityElement (int [] arr) {
            Arrays.sort(arr) ;
            int mid = (arr.length / 2) ;
            return arr[mid] ;
        }

        // using HashMap :- 
        public static int majorityElement1 (int [] arr) {
            int len = arr.length /2 ;
            Map<Integer , Integer > map = new HashMap<>() ;
            for (int i : arr) {
                map.put(i, map.getOrDefault(i, 0) +1) ;
                if (map.get(i) >= len) return i ;
            }
            return -1 ;
        }





    /* Question 3 : find  Inversion count in given Array . */ 


        // Using  Brute Force  : -
    private static int InversionCount (int [] arr) {
        int ans  = 0;
        for (int i = 0;i < arr.length ;i++) {
           for (int j =  i +1; j < arr.length; j++) {
                if (arr[i] > arr[j]) ans++ ;
           }
       }
       return ans ;
    }



        // using Insertion Sort Algorithom :-
    public static int Insertion(int [] arr){
            int ans = 0 ;
            for (int i = 0; i < arr.length-1; i++) {
                for (int j = i+1; j > 0; j--) {
                    if (arr[j] < arr[j-1]){
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                        ans++ ;
                    }
                    else break ;   
                }
            } 
            return ans ;   
        }
    public static void main(String[] args) {


        // Question  1 :- 
        System.out.println("Question 1 Answer  : - ");
        String [] arr  = { "sun", "earth", "mars", "mercury" } ;
        arr = StringMergeSort(arr) ;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();




        // Question 2 : -
        System.out.println("Question 2 Answer  : - ");
        

        int nums[] = {2,2,1,1,1,2,2 ,3 , 5 , 2, 2 };
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement1(nums));


        // Question 3 : -
        System.out.println("Question 3 Answer  : - ");
        int num1 [] = {2, 4  ,1 ,3 , 5 } ;
        System.out.println("Inversion Count " + InversionCount(num1));
        System.out.println("Inversion Count using Insertion Sort : - " +Insertion(num1));
        
    }

    
}