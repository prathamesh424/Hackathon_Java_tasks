public class SudokuSolver {
    public static void main(String[] args) {
        int[] [] board = new int[][]{
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
              {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                  {0, 0, 3, 0, 1, 0, 0, 8, 0},
                    {9, 0, 0, 8, 6, 3, 0, 0, 5},
                      {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                         {1, 3, 0, 0, 0, 0, 2, 5, 6,},
                           {0, 0, 0, 0, 0, 0, 0, 7, 4,},
                              {0, 0, 5, 2, 0, 6, 3, 0, 0,}

        };
        System.out.println(solve(board));
        if (solve(board)){
            display(board);
        }
        else {
            System.out.println( "cant solve board  ");
        }
        
    }

    static boolean solve (int [] [] board){
        int n = board.length;
        int row = -1;
        int col = -1 ;

        boolean leftempty = true ;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0){
                row = i ;
                col = j ;
                leftempty = false ;
                break ;
                }
                
            }
            if (leftempty == false){
                break ;
            }        
        }
            if (leftempty ==  true){
                return true ;
            }

         for (int num = 0; num <= 9; num++) {
            if (isSafe(board, row, col, num)){
                board[row][col] = num ;
                if (solve(board)){
                 
                    return true  ;             
                }
            }
            else {
                board[row][col]= 0 ;

            }
         }  
         
         return false  ;

    }


    static void display (int [][] board){
        for (int [] row  : board){
            for (int num : row ){
                System.out.print(num + " ");

            }
            System.out.println();
        }
    }



    
    static boolean isSafe (int [] [] board , int row  , int col , int num ){
        for (int i = 0; i < board.length; i++) {
            if (board[row][col]== num){
                return  false ;
            }
        }

        for (int[] nums : board ){
            if (nums[col] == num){
                return false ;
            }
        }

        int sqRoot = (int) Math.sqrt(board.length);
        int rowStart =  row - row %sqRoot ;
        int colStart = col -col %sqRoot ;

        for (int r = rowStart; r < rowStart + sqRoot; r++) {
            for (int c = colStart; c <colStart + sqRoot; c++) {
                if (board[r][c]== num){
                    return  false ;
                  }
            }
            
        }
    
        return true ;
    }
}
