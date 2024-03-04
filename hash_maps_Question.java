import java.util.*;

public class hash_maps_Question {
    public static void majorityElement (int nums[]){
        HashMap <Integer, Integer > map = new HashMap<>();
        int n = nums.length ;
        for (int i = 0 ; i <n ; i++){
            if (map.containsKey(nums[i])){
                map.put (nums[i] , map.get(nums[i]) + 1);
            }
            else {
                map.put (nums[i] ,1);
            }
        }

        for (int key : map.keySet()){
            if (map.get(key) > n/3){
                System.out.print(key + " ");         
            }
        }
    }

    public static int Intersection (int [] arr1 , int [] arr2){
        int count =0 ;
        HashSet <Integer> set = new HashSet<>();
        for (int i = 0 ; i < arr1.length ; i++){
            set.add(arr1[i]);}
        
        for (int j = 0 ; j <arr2.length ; j++ ){
            if(set.contains(arr2[j])){
                System.out.println(arr2[j]);
                set.remove(arr2[j]) ;
                count++;
            }
        }
        return count ;
 }

    public static String  Iternernary (HashMap <String , String > ticket){
        HashMap <String , String > revMap = new HashMap<>();   
        for (String key : ticket.keySet()){
            revMap.put(ticket.get(key) , key);
        }

        for (String key : ticket.keySet()){
            if (!revMap.containsKey(key)){
                return key ;
                        
            }
        }    
        return null ;    
    }


    public static int SubarraySum( int [] arr , int k){
        HashMap <Integer , Integer > map = new HashMap<>() ;
        map.put(0, 1);
        int ans = 0 ;
        int sum = 0 ;
            
        for (int i = 0  ; i <arr.length ; i++){
           sum += arr[i] ;

           if  (map.containsKey (sum-k)) {
                ans += map.get(sum-k);
           }

           if (map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
           }
           else{
                map.put(sum, 1) ;         
           }
        }
           return ans  ;
            }


    public static void main(String[] args) {
      /*   int [] nums = {1,3,2,5,1,3,1,5,5,5,1};
        majorityElement(nums); */

        /*int arr1 [] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        System.out.println( "count is  :- "+Intersection(arr1, arr2));
        */


        /*HashMap <String ,String > ticket = new HashMap<>( );
        ticket.put("chennai", "bengaluru");
        ticket.put("mumbai", "delhi");
        ticket.put("goa", "chennai");
        ticket.put("delhi", "goa" ) ;
        String start = Iternernary (ticket);

        while (ticket.containsKey(start)){
                System.out.print(start + "--->");
                start = ticket.get(start);
        }
        System.out.println(start);
        */

        int []arr = {10,2,-2,-20,10};
        int k = -10 ;
        System.out.println(SubarraySum(arr, k));

    }
}
