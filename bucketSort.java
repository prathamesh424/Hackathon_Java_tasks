import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;




public class bucketSort {
    static void bucketSort(float[] arr  , int n){
        

        if (n<=0){
            return;
        }
        @SuppressWarnings("unchecked")
        Vector<Float> [] buckets = new Vector [n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector <Float> ();
        } 


        for (int j = 0; j < n; j++) {
            float idx = arr[j] * n ;
            buckets [(int) idx].add(arr[j]);

        }

        for (int k = 0; k <n; k++) {
            Collections.sort(buckets[k]);
        }


        int index = 0  ;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size() ; j++) {

                arr[index++] = buckets[i].get(j);     
            }
            
        }
    } 



    public static void main(String[] args) {
        float arr[] = { (float)0.897, (float)0.565,
                        (float)0.656, (float)0.1234,
                        (float)0.665, (float)0.3434 };
        int n = arr.length ;
        bucketSort(arr , n);
        

        for (float f : arr) {
            System.out.print(f + " ");
        }
    }

    
}





 
// class GFG {
 
//     // Function to sort arr[] of size n
//     // using bucket sort
//     static void bucketSort(float arr[], int n)
//     {
//         if (n <= 0)
//             return;
 
//         // 1) Create n empty buckets
//         @SuppressWarnings("unchecked")
//         Vector<Float>[] buckets = new Vector[n];
 
//         for (int i = 0; i < n; i++) {
//             buckets[i] = new Vector<Float>();
//         }
 
//         // 2) Put array elements in different buckets
//         for (int i = 0; i < n; i++) {
//             float idx = arr[i] * n;
//             buckets[(int)idx].add(arr[i]);
//         }
 
//         // 3) Sort individual buckets
//         for (int i = 0; i < n; i++) {
//             Collections.sort(buckets[i]);
//         }
 
//         // 4) Concatenate all buckets into arr[]
//         int index = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < buckets[i].size(); j++) {
//                 arr[index++] = buckets[i].get(j);
//             }
//         }
//     }
 
//     // Driver code
//     public static void main(String args[])
//     {
//         float arr[] = { (float)0.897, (float)0.565,
//                         (float)0.656, (float)0.1234,
//                         (float)0.665, (float)0.3434 };
 
//         int n = arr.length;
//         bucketSort(arr, n);
 
//         System.out.println("Sorted array is ");
//         for (float el : arr) {
//             System.out.print(el + " ");
//         }
//     }
// }










class Solution {
        int [] [] memo ;
        int MOD = (int) 1e9 + 7 ;
        int arrLen;

        public int dp (int curr , int remain){
            if (remain==0){
                if (curr==0){
                    return 1 ;
                }
                return 0 ;
            }

            if (memo[curr][remain] != -1){
                return memo[curr][remain];   
            }

            int ans = dp (curr , remain+1);
            if (curr>0){
                ans = (ans + dp(curr-1 , remain-1)) % MOD;

            }
            if (curr < arrLen -1){
                ans = (ans + dp(curr+1 , remain-1)) % MOD;
                
            }

            memo [curr][remain] = ans ;

            return ans ;
        }

        public int numWays(int arrLen , int  steps){
            arrLen = Math.min(arrLen , steps);
            this.arrLen = arrLen ;
            memo = new int [arrLen][steps+1];

            for (int [] row : memo){
                Arrays.fill(row , -1);

            }

        return dp(0 , steps) ;
    }

}



