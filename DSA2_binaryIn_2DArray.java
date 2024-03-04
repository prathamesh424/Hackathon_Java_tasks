import java.util.Arrays;

public class DSA2_binaryIn_2DArray {
public static void main(String[] args) {
    int [][] matrix = {{15,25,35,45} ,{28,29,37,49} ,{33,34,38 ,50}};
    int target = 38;
    int ans [] = Search(matrix, target);
    String s = Arrays.toString(ans);
    System.out.println(s);
}

static int [] Search(int [][] matrix ,int target){
    
    int r = 0 ;
    int c = matrix.length-1;
    while (r<matrix.length && c >=0) {
        if (matrix[r][c] == target){
           return new int[] { r ,c };
        }
        if (matrix[r][c]<target){
            r++ ;
        }
        else{
            c--;
        }     
    }
    return new int[] {-1,-1} ;


}

}