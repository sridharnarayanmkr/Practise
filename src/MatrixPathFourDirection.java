public class MatrixPathFourDirection {
    public static void main(String[] args) {
        int[][] mat = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        int[][] vis = new int[mat.length][mat[0].length];
        System.out.println(finMinimumCostPath(mat,vis,0,0,3,3));
    }

    private static boolean finMinimumCostPath(int[][] mat, int[][] vis, int i, int j, int m, int n) {
        vis[i][j]=1;
        if(i==m && j==n){
            for(int a=0;a<=m;a++){
                for(int b=0;b<=n;b++){
                    System.out.print(vis[a][b]+" ");
                }
                System.out.println();
            }
            return true;
        }
        if(isSafe(mat,vis,i+1,j,m,n)&&finMinimumCostPath(mat,vis,i+1,j,m,n)){
            return true;
        }
        if(isSafe(mat,vis,i,j+1,m,n)&&finMinimumCostPath(mat,vis,i,j+1,m,n)){
            return true;
        }
        vis[i][j]=0;
        return false;

    }

    private static boolean isSafe(int[][] mat, int[][] vis, int i, int j, int m, int n) {

        if(i>=0 && j>=0 && i<=m && j<=n){
            if(vis[i][j]==0 && mat[i][j]!=0){
                return true;
            }
        }
        return false;

    }
}
