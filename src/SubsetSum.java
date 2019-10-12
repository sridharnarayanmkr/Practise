import java.util.ArrayList;

public class SubsetSum {
    //    static boolean[][] dp;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        findPrintSubsets(arr, arr.length, 10);
    }

    private static void findPrintSubsets(int[] arr, int length, int sum) {

        boolean[][] dp = new boolean[length][sum + 1];
        for (int i = 0; i < length; i++) {
            dp[i][0] = true;
        }
//        for (int j = 1; j <= sum; j++) {
//            dp[0][j] = false;
//        }
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i]];
                }
            }
        }
//        int i=length,j=sum;
//        while(i>0 && j>0){
//            if(dp[i-1][j]){
//                i-=1;
//            }else{
//                System.out.println(arr[i-1]);
//                j-=arr[i-1];
//                i-=1;
//            }
//        }
        ArrayList<Integer> list = new ArrayList<>();
        printAllSubset(arr, length - 1, sum, list, dp);
    }

    private static void printAllSubset(int[] arr, int i, int sum, ArrayList<Integer> list, boolean[][] dp) {
//        System.out.println(list);

        if (i == 0 && sum != 0) {
            list.add(arr[i]);
            System.out.println(list);
            list.clear();
            return;
        }
        if (i == 0 && sum == 0) {
            System.out.println(list);
            list.clear();
            return;
        }
        if (dp[i - 1][sum]) {
            ArrayList<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            printAllSubset(arr, i - 1, sum, newList, dp);
        }
        if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) {
            list.add(arr[i]);
            printAllSubset(arr, i - 1, sum - arr[i], list, dp);
        }

    }
}
