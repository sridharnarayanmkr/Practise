public class IdempotentMatrix {
    public static void main(String[] args) {
        int mat[][] = {{2, -2, 4},
                {-1, 3, 4},
                {1, -2, -3}};

        System.out.println(checkIdempotent(mat));
    }

    private static boolean checkIdempotent(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        multiplyMatrix(mat,res);
//        System.out.println(checkMatrix(mat,res));

        return checkMatrix(mat,res);
    }

    private static boolean checkMatrix(int[][] mat, int[][] res) {
        int N=mat.length;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(mat[i][j]!=res[i][j]){
                    return false;
                }
            }
        }
        return true;

    }

    private static void multiplyMatrix(int[][] mat, int[][] res) {

        int N=mat.length;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                res[i][j]=0;
                for(int k=0;k<N;k++){
                    res[i][j]+=mat[i][k]*mat[k][j];
                }
            }
        }
    }
}
