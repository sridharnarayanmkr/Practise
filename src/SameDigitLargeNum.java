import java.util.Arrays;

public class SameDigitLargeNum {
    public static void main(String[] args) {
        findNextLargest("534976");
    }

    private static void findNextLargest(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        int pos;
        for(pos=len-1;pos>0;pos--){
            if(arr[pos]>arr[pos-1]){
                break;
            }
        }
        if(pos==0){
            System.out.println("Not");
        }
        else{
            int min=arr[pos-1];
            int x=pos;

            for(int i=pos+1;i<len;i++){
                if(arr[i]>min && arr[x]>arr[i]){
                    x=i;
                }
            }
            swapVal(arr,pos-1,x);
            Arrays.sort(arr,pos,len);

            for(int i=0;i<len;i++){
                System.out.print(arr[i]);
            }
        }



    }

    private static void swapVal(char[] arr, int i, int min) {
        char tmp = arr[i];
        arr[i]=arr[min];
        arr[min]=tmp;
    }

}
