public class MatrixPath {
    static  int count=0;
    public static void main(String[] args) {

        int[][] mat = {{1,2,3},{4,5,6}};
        int m= mat.length;
        int n = mat[0].length;

        printMatrixPath(mat,0,0,m,n,new int[m+n-1],0);
        System.out.println(count);

    }

    private static void printMatrixPath(int[][] mat, int i, int j, int m, int n, int[] path, int index) {

        path[index]=mat[i][j];

        if(i==m-1){
            for(int k=j+1;k<n;k++){
                path[index+k-j]=mat[i][k];
            }
            for(int l=0;l<(index+n-j);l++){
                System.out.print(path[l]+" ");
            }
            count++;
            System.out.println();
            return;
        }
        if(j==n-1){
            for(int k=i+1;k<m;k++){
                path[index+k-i]=mat[k][j];
            }
            for(int l=0;l<(index+m-i);l++){
                System.out.print(path[l]+" ");
            }
            count++;
            System.out.println();
            return;

        }

        printMatrixPath(mat,i+1,j,m,n,path,index+1);
        printMatrixPath(mat,i,j+1,m,n,path,index+1);
    }
}
