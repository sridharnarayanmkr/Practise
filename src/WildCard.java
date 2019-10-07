import java.util.Arrays;

public class WildCard {
    public static void main(String[] args) {
        String s = "st*r";
        String p = "s\\*r";
        System.out.println(checkStr(s,p,s.length(),p.length()));
    }

    private static boolean checkStr(String s, String p, int m, int n) {

        boolean[][] arr = new boolean[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(arr[i],false);
        }
        arr[0][0]=true;
        for(int j=1;j<=n;j++){
            if(p.charAt(j-1)=='*'){
                arr[0][j]=arr[0][j-1];
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    arr[i][j]=arr[i-1][j]||arr[i][j-1];
                }else if(p.charAt(j-1)=='\\'){
                    arr[i][j]=arr[i-1][j]||arr[i][j-1];
                    j++;
                    if(s.charAt(i-1)==p.charAt(j-1)){
                        arr[i][j]=arr[i-1][j-1];
                    }else{
                        arr[i][j]=false;
                    }
                }else if(p.charAt(j-1)=='?'){
                    arr[i][j]=arr[i-1][j-1];
                }
                else{
                    arr[i][j]=false;
                }
            }
        }
        return arr[m][n];

    }
}
