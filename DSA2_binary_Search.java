import java.util.Arrays;

public class DSA2_binary_Search {
    public static void main(String[] args) {
        
       /*  // for 1 
        int arr [] = {-24 ,-20 ,- 14 , -8 , 0 , 9 , 12, 14 , 16 , 24 , 36 ,48};
        int target = 14 ;
        int ans = binary_Search( arr , target);
        System.out.println(ans);
        */

        /*      
                    // for 2
        
        int arr [] = {-24 ,-20 ,- 14 , -8 , 0 , 9 , 12, 14 , 16 , 24 , 36 ,48};
        int target = 14 ;
        int arr1 [] = {48 , 35, 29 ,27 ,23 ,17 ,18 , 9 ,3 , -1 , -4};
        int target1 = 23;
        int ans = binary_SearchFor_unknown_assending_or_not( arr , target);
        System.out.println(ans);
        int ans1 = binary_SearchFor_unknown_assending_or_not( arr1 , target1);
        System.out.println(ans1);
            */ 



        // for 3 and 4 :
        /*int target = 15;
        int arr [] = {-24 ,-20 ,- 14 , -8 , 0 , 9 , 12, 14 , 16 , 24 , 36 ,48};
        int ans = binary_Ceiling_Search( arr , target);
        System.out.println(ans);
        int ans1 = binary_floor_Search( arr , target);
        System.out.println(ans1);
        */

                // for 5 :-
        /*         
        int [] numbers = {5,7,7,7,7,7,7,8,45,7,20,56};
        int target = 7;
        String ans  = startrange(numbers, target);
        System.out.println(ans);
        */
        



                    // for 6:
        /*int arr [] = {-24 ,-20 ,- 14 , -8 , 0 , 9 , 12, 14 , 16 , 24 , 36 ,48};
        int target = 48 ;
        System.out.println(ans(arr, target));
        */
        

                // for 7 :-
        /*int [] mountain = {2,4,6,8,10,12,15,23,9,7,5,3,1};
        int ans  = Mountain(mountain);
        System.out.println(ans);
        */


                // for 8 :-
        /*  
        int [] mountain = {2,4,6,8,10,12,15,23,9,7,5,3,1};
        int ans = target_Find(mountain, 7 );
        System.out.println(ans);
            */

                    // for 9:-
        /*int [] rotation = {3,4,5,6 ,7,0,1,2};
        // for non repeated element
        System.out.println(FindRotation(rotation , true));
        int [] dup_rot = {3,4,5,6,6,7,0,1,2,2};
        System.out.println(FindRotation(dup_rot, false));
            */
    }







            //Question 1 :-
    /*static int binary_Search (int arr [] ,int target) {

        int start = 0;
        int end = arr.length-1 ;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]){
                end = mid -1 ;
            }
            else if (target > arr[mid]){
                start = mid + 1 ;
            }
            else{
                return mid;
            }
        }

            return -1;

    }*/




                // Question 2 :- 


        
        /*static int binary_SearchFor_unknown_assending_or_not (int arr [] ,int target) {

        int start = 0;
        int end = arr.length-1 ;

        boolean isAsending = (arr[start]< arr[end]);
       
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if ( target == arr[mid]){
                return mid ;

            }

            if (isAsending){
                if (target < arr[mid]){
                  end = mid -1 ;
                 }
                else {
                 start = mid + 1 ;
                 }
                }
            else {
                if (target > arr[mid]){
                  end = mid -1 ;
                 }
                else {
                 start = mid + 1 ;
                 }

                }
             
        }

            return -1;

    }*/




                // Question 3 :- find ceiling(smaller number that is >=target) og target number
      /*   static int binary_Ceiling_Search (int arr [] ,int target) {

        int start = 0;
        int end = arr.length-1 ;

        

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target > arr[arr.length-1]){   // for if target is larger than the highest number 
                return -1;
            }
            if (target < arr[mid]){
                end = mid -1 ;
            }
            else if (target > arr[mid]){
                start = mid + 1 ;
            }
            else{
                return mid;
            }
        }

            return start;
    }



            // Question 4 :- find floor(grater number that is <=target) og target number
     static int binary_floor_Search (int arr [] ,int target) {

        int start = 0;
        int end = arr.length-1 ;

        

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target > arr[arr.length-1]){   // for if target is larger than the highest number 
                return -1;
            }
            if (target < arr[mid]){
                end = mid -1 ;
            }
            else if (target > arr[mid]){
                start = mid + 1 ;
            }
            else{
                return mid;
            }
        }

            return end;
    }*/


            //  Question 5 :- find last and first index of requtired target

    /* 
    
    public static String startrange (int [] numbers , int target){
        int [] ans = {-1 ,-1};
        int start = search(numbers , target ,true);
        int end = search(numbers, target, false);
        ans[0]= start;
        ans[1] = end;
        String s = Arrays.toString(ans);
        return s ;

    }


    static int search(int [] arr ,int target ,boolean is_first_index){
        int ans = -1;
        int start = 0;
        int end = arr.length-1 ;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]){
                end = mid -1 ;
            }
            else if (target > arr[mid]){
                start = mid + 1 ;
            }
            else{
                ans = mid ;
                if (is_first_index){
                    end = mid -1;
                }
                else{
                    start = mid +1;
                }
            }
        }
            return ans;

    }*/





        //Question  6 :- find target in infinite  length array no useing .length 
    
    /*static int ans (int [] arr , int target){
        int start = 0;
        int end = 1;

        while (target>arr[end]) {
        int newStart = end +1;
        // this end is my  because length out of bound error
        end = end + (end -start + 1) ;

        //original
        // end = end +(end - start +1)*2 ;

        start = newStart ; 
        }
        return search(arr, target, start, end);
    }


    static int search(int [] arr ,int target , int start , int end ){
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]){
                end = mid -1 ;
            }
            else if (target > arr[mid]){
                start = mid + 1 ;
            }
            else{
                return mid;
            }
        }
            return -1;

    }*/

            // Question  7 :- find the peck of the mountain array
            
        /*static int Mountain (int [] mountain){
            int start = 0;
            int end = mountain.length-1;

            while (start < end) {
                int mid = start + (end -start) / 2 ;
                if (mountain[mid] > mountain[mid+1]){
                    // you in decreasing side or mid is the element
                    end = mid ;
                }

                else{
                    // you are in the incrasing side of the array
                    // mid is not the peaknumber 
                    start = mid +1 ;
                }
                
            }
                // both start and end are moving towards the peak number then any can we return start or end 

            return start ;

        }*/






                //Question 8 :- find the element in mountain array

   /*  static int target_Find (int mountain [] , int target){
        int peak = Mountain(mountain);
        int First = binary_SearchFor_unknown_assending_or_not(mountain, target, 0, peak);
        if (First != -1 ){
            return First ;
        }
        return binary_SearchFor_unknown_assending_or_not(mountain, target, peak+1, mountain.length-1);

    }

    static int Mountain (int [] mountain){
            int start = 0;
            int end = mountain.length-1;

            while (start < end) {
                int mid = start + (end -start) / 2 ;
                if (mountain[mid] > mountain[mid+1]){
                    // you in decreasing side or mid is the element
                    end = mid ;
                }

                else{
                    // you are in the incrasing side of the array
                    // mid is not the peaknumber 
                    start = mid +1 ;
                }
                
            }
                // both start and end are moving towards the peak number then any can we return start or end 

            return start ; // peak index
        

        }

    static int binary_SearchFor_unknown_assending_or_not (int arr [] ,int target , int start ,int end) {
        boolean isAsending = (arr[start]< arr[end]);
       
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if ( target == arr[mid]){
                return mid ;

            }

            if (isAsending){
                if (target < arr[mid]){
                  end = mid -1 ;
                 }
                else {
                 start = mid + 1 ;
                 }
                }
            else {
                if (target > arr[mid]){
                  end = mid -1 ;
                 }
                else {
                 start = mid + 1 ;
                 }

                }            
        }

        return -1;

         }*/



                // Question 9 :- find rotation of array 
    
    /*static int  FindRotation(int[] arr , boolean duplicate){
        if (duplicate){
        int pivot = FindPivot(arr);
        return pivot+1 ;
        }
        else if (!duplicate){
            int pivot = FindPivotIn_Duplicate(arr);
            return pivot+1;
        }
        return 0 ;
    }


    // for non duplicate containing array
    static int FindPivot (int [] arr){
        int start = 0;
        int end = arr.length-1;

        while(start<= end){
            int mid = start + (end -start)/2 ;
                //case1
            if (mid < end  && arr[mid]>arr[mid+1]){
                return mid ;
            }       //case2
            if (mid > start && arr[mid]<arr[mid -1]){
                return mid-1;
            }      //case 3
            if (arr[start] >= arr[mid]){
                end = mid-1;
            }
                //case4   start element < mid element 
            else {
                start = mid +1;
            }
        }
        return -1 ;
    }
     
     // for  duplicate containing array
static int FindPivotIn_Duplicate (int [] arr){
        int start = 0;
        int end = arr.length-1;

    while(start<= end){
            int mid = start + (end -start)/2 ;
                //case1
        if (mid < end  && arr[mid]>arr[mid+1]){
                return mid ;
            }       //case2
            if (mid > start && arr[mid]<arr[mid -1]){
                return mid-1;
            }      //case 3
            if (arr[mid]== arr[start] && arr[mid] == arr[end]){
                if (arr[start] > arr[start+1]){
                    return  start;
                }
                start++ ;
                if (arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;
            }
        else if (arr[start] <arr[mid] || arr[start]==arr[mid] && arr[end] < arr[mid] ){
                        start = mid+1;
                }
        else{
                end = mid-1;
            }
            
        }
        return -1 ;
    }*/


    public class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = findFirst(nums, target);
            result[1] = findLast(nums, target);
            return result;
        }
        
        private int findFirst(int[] nums, int target){
            int idx = -1;
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(nums[mid] >= target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
                if(nums[mid] == target) idx = mid;
            }
            return idx;
        }
        
        private int findLast(int[] nums, int target){
            int idx = -1;
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(nums[mid] <= target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
                if(nums[mid] == target) idx = mid;
            }
            return idx;
        }

    }

 }



