import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


/* Question 1 ::- find the highest count of sum can be possible */
class twoStacks{
    static int  TwoStacks(int maxSum , int []a , int b[]){
        return TwoStacks(maxSum, a , b ,0 , 0) - 1;

    }

    private static int TwoStacks (int maxSum  , int[] a , int [] b , int sum , int count ){
        if (sum>maxSum){
                return count ;               
            }

        if (a.length== 0 || b.length == 0  ){
            return count ;
        }

        int ansL = TwoStacks(maxSum, Arrays.copyOfRange(a,1 ,a.length), b, sum + a[0], count+1) ;
        int ansR = TwoStacks(maxSum, a , Arrays.copyOfRange(b,1 ,b.length), sum + b[0], count+1) ;
        

        return Math.max(ansL, ansR);
    }
}

/*  Question 2 ::- find the largest area of histogram  */
class LargestAreaHistogram{

    public int largestAreaHistogram (int [] heights){
    Stack <Integer> stack = new Stack<>();
    int max = 0 ;

    stack.push(0);

    for (int i = 1 ; i < heights.length ; i++){
        while(!stack.isEmpty() && heights[i] < heights [stack.peek()]){
             max = getMax(heights , stack , max , i);
             
        }
        stack.push(i);
    }

    int j = heights.length;
    while(!stack.isEmpty()){
        max = getMax(heights , stack , max , j);

    }
        return max ; 

     }

    private int getMax(int [] arr , Stack<Integer> stack , int max , int i){
        int area ;

        int popped = stack.pop();
        if (stack.isEmpty()){
            area = arr[popped] * i ;    
        }
        else{
            area = arr[popped] * (i - 1 - stack.peek());
        }
        return Math.max(max , area);
    }
}

/* Question 3  :- where a bracket string is valid or not */

class bracket {
    public boolean isValid (String s ){
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){
            if (ch == '(' || ch == '[' || ch == '{' ){
                stack.push(ch);               
            }
            else {
                if (ch == ')'){
                    if (stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                 }
                if (ch == ']'){
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                 }
                if (ch == '}'){
                    if (stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                 }
                }
        }
        return stack.isEmpty() ;
    }
}


public class staksQuestion {
    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        twoStacks ts = new twoStacks();
       /*

       

       System.out.println("no of test cases:-");
        int t = sc.nextInt();

        for  (int i = 0 ; i < t ;i++){
            System.out.println("write length of first array , length of second array , max sum");
            int n = sc.nextInt();
            int m = sc.nextInt() ;
            int x = sc.nextInt();
            int [] a  = new int[n] ;
            int []b = new int[m];
            System.out.println("write first array ");
            for (int j = 0 ;j < n ; j++){
                a[j]= sc.nextInt();
            }
            System.out.println("write second array ");
            for (int j = 0 ;j < m ; j++){
                b[j]= sc.nextInt();
            }
            System.out.println("highest count number :- ");
            System.out.println(ts.TwoStacks(x ,a, b));
        }*/

         
        /*int [] heights = {2,1,5,6,2,3};
        LargestAreaHistogram l = new LargestAreaHistogram();
        System.out.println(l.largestAreaHistogram(heights));
        */
       
    }

}


