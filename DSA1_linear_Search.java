
import java.util.Arrays;

public class DSA1_linear_Search {

        public static void main(String[] args) {
            //for 1
        //int arr[] = { 12,54,56,-5, -6,-3,8};
         //  int ans = min(arr);
         //  System.out.println(ans);


                //for 2
        //  int arr[][] = {
        //     {1,43,43,46}
        //     ,{-3,-4,7,78},
        //     {45,65,8,9}};
        //     int target = 9;           
        //   int [] ans = Find_num(arr, target);
        //    System.out.println(Arrays.toString (ans));
         
             //for 3
        //  int arr[][] = {
        //     {1,43,43,46}
        //     ,{-3,-4,7,78},
        //     {45,65,8,9}};
           
        //     System.out.println( Find_minNum(arr));
        //     System.out.println( Find_maxNum(arr));     
        
        

                    //for 4;
            
            // System.out.println(digits(456));
            // System.out.println(even(67));
            // int arr[]={23,3453,445,321,575,111111,56,87,9};
            //System.out.println(findNum(arr));



                // for 5 ;
            int arr [] [] = { {23,45,322}, {455,2888}, {408 , 80 , 37}} ;
                System.out.println(Richest(arr));
            

                    
        }





        //question 1 :-to check a min number in array 
     
    // static int  min (int [] arr ){
    //      int ans = arr[0];
    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i] < ans ) {
    //             ans = arr[i]; }   
    //     }
    //     return ans ;
       
    // }




          // question 2 :- check for number in 2D array

//      static int [] Find_num (int [][] arr , int  target){
//             for (int row = 0; row < arr.length; row++) {
//                 for (int col = 0; col < arr[row].length; col++) {     
//                     if (arr[row][col]==target){
//                         return new int[]{row,col};

//                     }          
//                 }           
//             }   
//             return new int[]{-1,-1};
//     }
    
    
// }

      //  question 3 = cheack min and max in 2D array

//          static int  Find_minNum (int [][] arr){
//             int min = Integer.MAX_VALUE;
//             for (int [] Row : arr) {
//                 for (int element : Row) {
//                     if (element < min){
//                         min = element;
//                     }                   
//                 }                
//             }
//             return min;
         
// }

//     static int  Find_maxNum (int [][] arr){
//             int max = Integer.MIN_VALUE;
//             for (int [] Row : arr) {
//                 for (int element : Row) {
//                     if (element > max){
//                         max = element;
//                     }                   
//                 }                
//             }
//             return max;
//         }

            // question 4 :- find even number that have even diogits in array


       
                // find digit in number 
        /*static int digits(int num ){

            if (num <0){
                num = num * -1;
            }

            if (num ==0){
                return 1 ;
            }
            int digit = 0;
           while (num > 0) {
                digit++;
                num =   num / 10 ;
                }
            return digit;
        }
                //find digits are even or odd
        static boolean even( int num){
           int noOfDigits = digits(num);
            return noOfDigits % 2 == 0 ;
        }
                    // make count of that number have even digits nd iterrate the array
        static int findNum(int [] arr){
            int count = 0;
            for (int num : arr) {
                if(even(num)){
                    count++;
                }   
            }
            return count;
        }*/

            //  Queation 5:- find richest man in array  [ { contain accounts and their balace}-1st person .....  ]


                static int Richest( int allPeople[][] ){

                        int ans = Integer.MIN_VALUE;
                    for (int person = 0; person < allPeople.length; person++) {
                        int sum = 0;
                        for (int accounts = 0; accounts < allPeople[person].length; accounts++) {
                            sum += allPeople[person][accounts];     
                        }
                        
                        if (sum > ans){
                            ans = sum ;     
                        }           
                    }
                     return ans ;
                }
        


}