import java.util.Arrays;

public class DSA5_InsertionSort {
    public static void main(String[] args) {
        int [] arr = {10 ,45,64 ,67 ,9, 3, 5, 2 ,0  ,-2};
        Insertion(arr);
        System.out.println(Arrays.toString(arr));
        
    }

    static void Insertion(int [] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--) {

                if (arr[j] < arr[j-1]){
                   int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else {
                    break;
                }
                
            }
            
        }    
    }
    
}
