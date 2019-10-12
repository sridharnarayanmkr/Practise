import java.util.Set;
import java.util.TreeSet;

public class ArrayLeader {
    //An element of array is leader if it is greater than or equal to all the elements to its right side.
    // Also, the rightmost element is always a leader.
    public static void main(String[] args) {
        int[] arr ={16,17,4,3,5,2};
        System.out.println(findLeaders(arr));
    }

    private static Set<Integer> findLeaders(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        int curr_leader=Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>curr_leader){
                set.add(arr[i]);
                curr_leader=arr[i];
            }
        }
        return set;
    }
}
