
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class MissingNumber{
            //Quedstion 1 :- Find missing Number 
    public int MissingNumber (int [] arr){
        int i = 0 ;
       while(i<arr.length){
        int correct = arr[i];
           if(arr[i] <arr.length && arr[correct] !=arr[i]){
                int temp = arr[i]; 
                arr[i] = arr[correct];
                arr[correct] = temp ;
            }
            else{
                i++;
            }  
       }
       for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j ){
                return j;
            }
        
       }

    

       return arr.length;
    }


            //Quedstion 2 :- Find missing Numbers 
   
    public List<Integer> MissingNumberMany (int [] arr){

        List<Integer> ans = new ArrayList<>();
        int i = 0 ;
       while(i<arr.length){
        int correct = arr[i];
           if(arr[i] <arr.length && arr[correct] !=arr[i]){
                int temp = arr[i]; 
                arr[i] = arr[correct];
                arr[correct] = temp ;
            }
            else{
                i++;
            }  
       }
       
       for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j ){
                ans.add(j);
           
            } 
                        

       }
    return ans ;    
}

        //Question 3 :- find Duplicate number 
    public int FindDuplicate (int arr []){
         int i = 0 ;
       while(i< arr.length){
            int correct = arr[i] -1;

        if (arr[i] != i+1){
            if (arr[correct] !=arr[i]){
                int temp = arr[i]; 
                arr[i] = arr[correct];
                arr[correct] = temp ;
            }
            else{
               return arr[i];
            }
        }
        else{
                i++;
        }
    }
        return-1;
}



        // Question 4 :- Find all Duplicate in array
        
    public List Find_All_Duplicate (int arr []){   
        List<Integer> ans = new ArrayList<>();    
        int i = 0 ;
       while(i<arr.length){
            int correct = arr[i] -1;
           if (arr[correct] !=arr[i]){
                int temp = arr[i]; 
                arr[i] = arr[correct];
                arr[correct] = temp ;
            }
            else{
                i++;
            } 
       }     
         for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j+1 ){
                ans.add(arr[j]);
            }            
       }
      return ans ;
  }




           // Question 5 :- find duplicate and repeated number 
   public List Find_repeated_Duplicate (int arr []){   
        List<Integer> ans = new ArrayList<>();    
        int i = 0 ;
       while(i<arr.length){
            int correct = arr[i] -1;
           if (arr[correct] !=arr[i]){
                int temp = arr[i]; 
                arr[i] = arr[correct];
                arr[correct] = temp ;
            }
            else{
                i++;
            } 
       }     
         for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j+1 ){
                ans.add(arr[j]);
                ans.add(j+1);
            }            
       }
      return ans ;
  }



    // Question 6:- find 1st missing positive number :-

    public int MissingPositive(int [] arr){
        // swapping 

        int i = 0 ;
        while(i < arr.length){
            int correct = arr[i] -1;
           if ( arr[i] >0 && arr [i]<=arr.length && arr[correct] !=arr[i]){
                int temp = arr[i]; 
                arr[i] = arr[correct];
                arr[correct] = temp ;
            }
            else{
                i++;
            } 
            }
         //finding missing number:-
         for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j+1){
                return j+1 ;
            }    
         }

         return arr.length+1;
        }







  
} 




public class DSA6_CyclicSort {
    public static void main(String[] args) {
        //introdution 
        System.out.println("introduction");
        int [] arr = {3,5,2,1,4};
        Cyclic(arr);
        System.out.println(Arrays.toString(arr));
        

        //for 1:- 
    System.out.println("Question 1 ans :-");
    int [] arr1 = {3,2,1,0,4};
    MissingNumber m1 = new MissingNumber();
    System.out.println(m1.MissingNumber(arr1));
    

        //for 2:-
    System.out.println("Question 2 ans :-");
    int [] arr2 = {3,2,5,2};
    MissingNumber m2 = new MissingNumber();
    System.out.println(m2.MissingNumberMany(arr2));
    
    

    //for 3:-
    System.out.println("Question 3 ans :-");
    int [] arr3 = {3,1,2,4,2};
    MissingNumber m3 = new MissingNumber();
    System.out.println(m3.FindDuplicate(arr3));
        


    // for 4 
    System.out.println("Question 4 ans :-");
    int [] arr4 = {3,1,2,4,3,2};
    MissingNumber m4 = new MissingNumber();
    System.out.println(m4.Find_All_Duplicate(arr4));



    // for 5 
    System.out.println("Question 5 ans :-");
    int [] arr5 = {3,1,2,4,4,1};
    MissingNumber m5 = new MissingNumber();
    System.out.println(m4.Find_repeated_Duplicate(arr5));



        // for 6 
    System.out.println("Question 6 ans :-");
    int [] arr6 = {3,1,2,-1,5,0};
    MissingNumber m6 = new MissingNumber();
    System.out.println(m4.MissingPositive(arr6));



    }




    //Introdution  to cyclic sort 

static void Cyclic (int [] arr){
        int i = 0 ;
       while(i<arr.length){
            int correct = arr[i] -1;
           if (arr[correct] !=arr[i]){
                int temp = arr[i]; 
                arr[i] = arr[correct];
                arr[correct] = temp ;
            }
            else{
                i++;
            }
        
       }
    } 

}