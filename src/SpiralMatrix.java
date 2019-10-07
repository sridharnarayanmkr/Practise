public class SpiralMatrix {
    public static void main(String[] args) {
        int mat[][] = {{2, -2, 4,3},
                {-1, 3, 4,3},
                {1, -2, -3,0}};
        printSpiral(mat);
    }

    private static void printSpiral(int[][] mat) {

        int k=0,l=0;
        int m=mat.length, n =mat[0].length;

        while(k<m && l<n){
            for(int i=l;i<n;i++){
                System.out.print(mat[k][i]+" ");
            }
            k++;
            for(int i=k;i<m;i++){
                System.out.print(mat[i][n-1]+" ");
            }
            n--;
            if(k<m){
                for(int i=n-1;i>=l;i--){
                    System.out.print(mat[m-1][i]+" ");
                }
                m--;
            }
            if(l<n){
                for(int i=m-1;i>=k;i--){
                    System.out.print(mat[i][l]+" ");
                }
                l++;
            }
        }

    }
}
