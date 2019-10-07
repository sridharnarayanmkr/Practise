public class MatrixWord {
    static int M=3,N=3;
    public static void main(String[] args) {
        char boggle[][] = { { 'G', 'I', 'Z' },
                { 'U', 'E', 'K' },
                { 'Q', 'S', 'E' } };
        boolean[][] vis = new boolean[boggle.length][boggle[0].length];
        findWords(boggle,vis);
    }

    private static void findWords(char[][] boggle, boolean[][] vis) {
        String str ="";
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                findWordUtil(boggle,i,j,vis,str);
            }
        }
    }

    private static void findWordUtil(char[][] boggle, int i, int j, boolean[][] vis, String str) {

        vis[i][j] =true;
        str+=boggle[i][j];
        if(isWord(str)){
            System.out.println(str);
        }

        for(int row=i-1;row<=i+1&&row<M;row++){
            for(int col=j-1;col<=j+1&&col<N;col++){
                if(row>=0&&col>=0&&!vis[row][col])
                    findWordUtil(boggle,row,col,vis,str);
            }
        }

        str=""+str.charAt(str.length()-1);
        vis[i][j]=false;
    }

    private static boolean isWord(String str) {
        String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ"};
        for (int i = 0; i < dictionary.length; i++)
            if (str.equals(dictionary[i]))
                return true;
        return false;
    }
}
