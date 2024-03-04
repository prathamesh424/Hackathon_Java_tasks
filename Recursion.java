public class Recursion {
    public static void main(String[] args) {
       System.out.println(Fibonacci(13));
       System.out.println(factorial(5));
       System.out.println(sum(1235));
        System.out.println(product(1235));  
        int arr [] = {1,2,3,45};
        System.out.println(check(arr, 0));
        System.out.println(target(arr, 35, 0));
        triangle(100, 0);
    }


    //write a fibbonaci saries using recursion :-

    static int Fibonacci(int num){
            if (num <2){
                return num;
            }
        
        return  Fibonacci(num-1)+Fibonacci(num-2);

    }

    // factorial

    static int factorial (int n){
        if (n==1 || n==0){
            return 1 ;      
        }

        return n * factorial(n-1);
    }
     //sum of digit 

    static int sum (int n){
        if (n == 0 ){
            return 0 ;
        }
        return (n % 10) + sum(n/10);
    }
    
     //product of digit 
    static int product (int n){
        if (n%10 == n ){
            return n ;
        }
        return (n % 10) * product(n/10);
    }

    // array  is sorted or not 
    static boolean check (int [] arr , int n ){  
        if (n == arr.length-1){
            return true ;
        }
     return arr[n] < arr [n+1] && check(arr, n+1);
    }
       // find target


    static int target(int [] arr , int target , int n){
        if (n == arr.length){
            return -1;
        }
        if (arr[n] == target){
            return n;
        }
        
       return target(arr, target, n+1);
    }


    static void triangle(int r , int c){
        if (r== 0){
            return;
        }
        if (c < r){
            System.out.print("*");
            triangle(r, c+1);
        }
        else {
            System.out.println(" ");
            triangle(r-1, 0);
        }
    }
}
