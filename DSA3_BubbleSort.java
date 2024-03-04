import java.util.Arrays;

public class DSA3_BubbleSort {
    
    public static void main(String[] args) {
        int [] arr = {2,4,7,8,10,1};
        Bubble(arr);
        System.out.println(Arrays.toString(arr));


    }



    static void Bubble(int arr[]){
            boolean swapped;   // if array is sorted for that not complete all loops and break as the array is sorted 
            for (int index = 0; index < arr.length; index++) {
                swapped =false;
                for (int j = 1; j < arr.length-index; j++) {
                    if (arr[j] < arr[j-1]){
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                        swapped = true ;
                    }
                    
                }
                if (!swapped){
                    break;
                }
            }
    }
    
}

