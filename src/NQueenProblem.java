public class NQueenProblem {
    static  int N=8;
    public static void main(String[] args) {
        int[][] board={{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
//        int board[][] = { { 0, 0, 0, 0 },
//                { 0, 0, 0, 0 },
//                { 0, 0, 0, 0 },
//                { 0, 0, 0, 0 } };

        if(solveBoard(board,0)){
            printBoard(board);
        }else{
            System.out.println("Not Possible");
        }

    }

    private static boolean solveBoard(int[][] board, int col) {
        if(col>=N){
            return true;
        }
        for(int i=0;i<N;i++){

            if(isSafe(board,i,col)){
                board[i][col]=1;
                if(solveBoard(board,col+1)){
                    return true;
                }
                board[i][col]=0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {

        for(int i=0;i<col;i++){
            if(board[row][i]==1)
                return false;
        }
        for(int i=row,j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1)
                return false;
        }
        for(int i=row,j=col;i<N&&j>=0;i++,j--){
            if(board[i][j]==1)
                return false;
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
