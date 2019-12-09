import java.util.Arrays;

public class CandyDistribution {
    /*
    Given N candies and K people. In the first turn, the first person gets 1 candy,
    the second gets 2 candies, and so on till K people. In the next turn, the first person gets K+1 candies,
    the second person gets k+2 candies and so on. If the number of candies is less than the required number of candies
    at every turn, then the person receives the remaining number of candies.
    The task is to find the total number of candies every person has at the end.
     */

    public static void main(String[] args){
        int candies=100;
        int k=4;
        printCandyDistribution(candies,k);

    }

    private static void printCandyDistribution(int N, int K) {
        int[] arr = new int[K];
        //Filling for the first time with below loop
        for(int i=0;i<K;i++){
            if(N-(i+1)>0){
                arr[i]=i+1;
                N-=(i+1);
            }else{
                arr[i]=N;
                N=0;
            }
        }
        int tmp= K;
        for(int i=N;i>0;){
            tmp++;
            if(i-tmp<=0){
                if(tmp%K==0){
                    arr[K-1]+=i;
                    i=0;
                }else{
                    arr[(tmp%K)-1]+=i;
                    i=0;
                }
            }
            else{
                if(tmp%K==0){
                    arr[K-1]+=(tmp);
                    i-=tmp;
                }else{
                    arr[(tmp%K)-1]+=(tmp);
                    i-=tmp;
                }

            }
        }

        for(int i:arr)
            System.out.print(i+" ");
    }
}
