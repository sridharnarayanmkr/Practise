import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr ={7,10,4,3,20,15};
        System.out.println(findKthSmallestElement(arr,5));
    }

    private static int findKthSmallestElement(int[] arr,int k) {
        Set<Integer> set = new TreeSet<Integer>();
        for(int i=0;i<arr.length;i++)
            set.add(arr[i]);
        System.out.println(set);
        Iterator i = set.iterator();
        int count=0,val;
        while(i.hasNext()){
            val=(int)i.next();
            if(count==k-1)
                return val;
            count++;
        }
        return 0;
    }
}
