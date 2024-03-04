import java.util.Arrays;

public class DSA4_SelectionSort {
    public static void main(String[] args) {
        int [] arr = {10 ,45,64 ,67 ,9, 3, 5, 2 ,0  ,-2};
        Selection(arr);
        System.out.println(Arrays.toString(arr));
        
    }

    static void Selection(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int end = arr.length - i -1;
            int maxIndex = MAXindex(arr , 0 , end);
            swap(arr, maxIndex, end);
        }

    }

    static int MAXindex(int [] arr ,int start ,int end){
        int max = start ;
        for (int index = start; index <= end; index++) {
            if (arr[max]< arr[index]){
                 max = index ;
            }      
        }
        return max ;
    }

    static void swap (int [] arr , int first ,int second){
       int temp = arr[first];
       arr[first]= arr[second];
       arr[second]= temp;
    }



}
