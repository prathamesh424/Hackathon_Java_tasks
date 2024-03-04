import java.util.Arrays;
import java.util.HashMap;

public class countingSort {
    public static void countSort (int [] arr){
        if ( arr == null || arr.length <= 1) return;

        int large = arr[0];
        for (int i : arr) {
            if (i > large) large = i ;
        }

        int [] freq= new int[large + 1];

        for (int i : arr) {
            freq[i]++ ;
        }

        System.out.println( " Print the array  := ");
        int k = 0 ;
        for (int i = 0 ; i <= large; i++){
            while ( freq[i] > 0 ){
                arr[k++] = i ;
                freq[i]--;
            }
        }
    }

    public static void usingMap (int [] arr){
        if ( arr == null || arr.length <= 1) return;

        int large = arr[0];
        
        for (int i : arr) {
            if (i > large) large = i ;
        }

        //new Approach := 
        int min = Arrays.stream(arr).min().getAsInt() ;

        HashMap <Integer ,Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i , map.getOrDefault(i , 0) + 1) ;
        }
        int k = 0 ;
        for (int i = min  ; i <= large; i++){
            int count = map.getOrDefault(i, 0);
            for (int j = 0 ; j < count ;j++){
                arr[k++]= i ;
            }    
        }




    }

    public static void main(String[] args) {
        int [] arr = {5 , 7 ,4 , 3 , 3 , 1};
        countSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


        usingMap(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
}
