public class MatrixPalindrome {
    public static void main(String[] args) {
        char arr[][] = {{'a', 'a', 'a', 'b'},
                {'b', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'}};
        String str = "";
        printPalindromeString(str, arr, 0, 0, 3, 4);
    }

    private static void printPalindromeString(String s, char[][] arr, int i, int j, int m, int n) {

        if (i < m - 1 || j < n - 1) {
            if (i < m - 1) {
                printPalindromeString(s + arr[i][j], arr, i + 1, j, m, n);
            }
            if (j < n - 1) {
                printPalindromeString(s + arr[i][j], arr, i, j + 1, m, n);
            }
        } else {
            s += arr[m - 1][n - 1];
            if (isPalindrome(s)) {
                System.out.println(s);
            }
        }

    }

    private static boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);
        if (s.equals(str.reverse().toString())) {
            return true;
        }
        return false;
    }
}
