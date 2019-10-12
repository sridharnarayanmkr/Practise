public class PrintAllSubset {
    public static void main(String[] args) {
        int[] arr ={2,5,3,6};
        printAllSubset(arr,10,"");
    }
//Trial but prints more like a permutation
    private static void printAllSubset(int[] arr, int curr_sum, String s) {
        if(curr_sum==0){
            System.out.println(s);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=curr_sum){
                printAllSubset(arr,curr_sum-arr[i],s+""+arr[i]);
            }
        }

    }
}
