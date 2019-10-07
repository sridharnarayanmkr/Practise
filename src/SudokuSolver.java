public class SudokuSolver {
    public static void main(String[] args){
        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        int n = board.length;
        if(solveBoard(board,n)){
            printBoard(board);
        }else{
            System.out.println("Not Possible");
        }
    }

    private static boolean solveBoard(int[][] board, int n) {

        int row=-1,col=-1;
        boolean isEmpty=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    isEmpty=false;
                    break;
                }
            }
            if(!isEmpty)
                break;
        }
        if(isEmpty)
            return true;

        for(int num=1;num<=n;num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=num;
                if(solveBoard(board,n))
                    return true;
                board[row][col]=0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {

        for(int i=0;i<board.length;i++){
            if(board[row][i]==num)
                return false;
        }
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row-row%sqrt;
        int colStart = col-col%sqrt;

        for(int i=rowStart;i<rowStart+sqrt;i++){
            for(int j=colStart;j<colStart+sqrt;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
    return true;
    }

    private static void printBoard(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }


    }
}
