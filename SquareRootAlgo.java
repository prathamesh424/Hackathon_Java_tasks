import java.util.*;

public class SquareRootAlgo {





    static public int  AddQuery (int [] arr  , int []blocks , int sqrt , int l , int r) {
        int ans = 0 ;
            // adding left part
        while (l % sqrt !=  0 ||  l< r || l!= 0) {
            ans += arr[l++];
        }

            // adding mid part 
        while (l+sqrt <= r) {
            ans += blocks[l/sqrt];
            l+=sqrt;
        }

        // adding right 
        while (l <= r){
            ans += arr[l++];
        }
        return ans ;
    }



    public static void main(String[] args) {
        int [] arr =  {1,3,5,2,7,6,3,1,4,8};
        int n = arr.length ;

        int sqrt = (int) Math.sqrt(n);
        int block_id = -1 ;

        int [] blocks = new int[sqrt + 1];
        for (int i = 0 ; i < n ;i++){
            if (i % sqrt == 0) block_id++ ;
            blocks[block_id] += arr[i];
        }

        int a = AddQuery(arr, blocks, sqrt, 2, 7);
        System.out.println(a);



      
    }
    
}
