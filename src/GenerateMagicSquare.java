public class GenerateMagicSquare {
    public static void main(String[] args) {
        generateSquare(3);
    }

    private static void generateSquare(int n) {
        int i=n/2, j=n-1;
        int[][] magicSquare = new int[n][n];
        for(int num=1;num<=n*n;){
            if(i==-1&&j==n){
                i=0;
                j=n-2;
            }else{
                if(i<0){
                    i=n-1;
                }
                if(j==n){
                    j=0;
                }
            }

            if(magicSquare[i][j]!=0){
                i++;
                j-=2;
                continue;
            }else{
                magicSquare[i][j]=num++;
            }
            i--;j++;
        }
        System.out.println("The Magic Square for "+n+":");
        System.out.println("Sum of each row or column "+n*(n*n+1)/2+":");
        for(i=0; i<n; i++)
        {
            for(j=0; j<n; j++)
                System.out.print(magicSquare[i][j]+" ");
            System.out.println();
        }

    }
}
