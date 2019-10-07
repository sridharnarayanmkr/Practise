import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class ChocolateDistribution {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(getDistribution(arr, 5));
    }

    private static int getDistribution(int[] arr, int a) {
        TreeSet<Integer> hset = new TreeSet<>();
        for (int v : arr) {
            hset.add(v);
        }
        ArrayList<Integer> arrayList = new ArrayList<>(hset);
        System.out.println(arrayList.get(4));
        return (arrayList.get(a-1) - arrayList.get(0));
    }
}
