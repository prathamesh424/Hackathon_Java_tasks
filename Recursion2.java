import java.util.ArrayList;

public class Recursion2 {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
        path("", 3, 3);

        //2

        boolean [] [] board = {
            {true ,true , true},
            {true ,true , true},
            {true ,true , true}
        };

        allpaths("", board, 0, 0);




     // N QUEEN QUESTION
     int n = 4 ;
     boolean [] [] board1 = new boolean[n][n];
     Queen q = new Queen();
     System.out.println(q.queens(board1,0));




    }
            // mase  path question 
    static int count (int r ,int c){
        if (r==1 || c==1){
            return 1 ;
        }
        int left = count(r-1, c);
        int right = count(r ,c-1);
        return left+ right ;
    }


    static void path (String p , int r , int c){
        if (r==1 && c==1){
            System.out.println(p);
            return  ;
        }
        if (r>1){
            path(p + 'D', r-1, c);
        }
         if (c>1){
            path(p + 'R', r, c-1);
        }


    }
        // in all dirtion :=
    
    static void allpaths(String p , boolean maze [] [] , int r  , int c){
        if (r == maze.length-1 && c == maze[0].length-1){
          
            System.out.println(p);
            return;
        }
        if (!maze[r][c]){
            return ;
        }
            // to mark visited place false and not go to them 
        maze [r] [c] = false ;

        if (r < maze.length-1){
            allpaths(p+'D', maze, r+1, c);
        }
         if (c < maze[0].length-1){
            allpaths(p+'R', maze, r, c+1);
        }
         if (r>0){
            allpaths(p+'U', maze, r-1, c);
        }
         if (c>0){
            allpaths(p+'L', maze, r, c-1);
        }

            // to reverse the changes that made to allow the next recursion call happen 
            
        maze [r] [c] = true ;
    }

}


class Queen {
    static int queens(boolean [] [] board , int r){
            if (r== board.length){
                display (board);
                System.out.println( );
                return 1 ;
            }

            int count = 0 ;
                // place for Queen 
            for (int c = 0; c < board.length; c++) {
                if (isSafe(board , r , c)){
                    board[r][c] = true ;
                    count += queens(board, r+1);
                    board[r][c] = false;
                }   
            }
            return count ;
    }


    static boolean isSafe (boolean board[][] , int r  , int c){

            // vertical row check 
        for (int i = 0; i < r; i++) {
            if (board[i][c] ){
                return false ;
            }
        }

        int maxLeft = Math.min(r, c);
            // left diagonal
         for (int i = 1; i <= maxLeft; i++) {
            if (board[r-i][c-i]){
                return false ;
            }   
        }
            // right diagonal 
        int maxRight = Math.min(r, board.length -c-1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[r-i][c+i]){
                return false ;
            }   
        }


        return true ;
    }


    static void display (boolean [][] board){
        for (boolean[] r : board){
            for(boolean element : r){
                if (element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println(    );
           
        }
    }

}