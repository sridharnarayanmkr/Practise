
public class MinimumJump {

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,2,4,2,0,1,1};
        int size=10;
        int out = check(arr,size);
        System.out.println("  Jumps --- "+out);
    }
    private static int check(int[] arr, int n) {
        int[] jumps=new int[n];int i,j;
        jumps[0]=0;
        int[] ele=new int[n];
        ele[0]=-1;
        for(i=1;i<n;i++){jumps[i]=Integer.MAX_VALUE;
            for(j=0;j<i;j++){
                if(i<=j+arr[j]){
                    //jumps[i]=Math.min(jumps[i], jumps[j]+1);
                    if(jumps[i]>(jumps[j]+1)) {
                        jumps[i] = jumps[j] + 1;
                        ele[i] = j;
                    }

                }
            }
            System.out.println();
        }
        for(i=n-1;i>0;){
            System.out.println(arr[i]);
            i=ele[i];
        }
        System.out.println(arr[0]);
        return jumps[n-1];
    }

}
