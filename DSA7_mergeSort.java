import java.util.Arrays;

public class DSA7_mergeSort {

public static void main(String[] args) {
    int []arr = {3,5,2,6,1};
  
    int [] arr1 = (MergeSort(arr));
    arr1.toString();
    System.out.println(arr1);
    
}

static int[] MergeSort(int [] arr){
    if (arr.length == 1){
        return arr;
    }

    int mid = arr.length / 2 ;
    int [] left = MergeSort(Arrays.copyOfRange(arr, 0 , mid));
    int [] right = MergeSort(Arrays.copyOfRange(arr, mid, arr.length));

    return Merge(left, right);
}


 
private static int [] Merge (int [] first , int [] second){
        int [] mix = new int [first.length + second.length] ;
        int i = 0;
        int j = 0;
        int k = 0;
    

        while( i < first.length &&   j < second.length){
            if (first[i] < second[j]){
                mix[k] = first[i];
                i++ ;

            }
            else{
                mix[k] = second[j];
                j++;
            }
                
        k++;
        }

        while(i < first.length){
            mix[k] = first[i];
            k++;
            i++;
        }
        
        while(j < second.length ){
            mix[k] = second[j];
            k++;
            j++;
        }
            return mix ;
    }




} 




