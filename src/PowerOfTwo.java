import java.util.ArrayList;
import java.util.List;

public class PowerOfTwo {

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(3);arr.add(8);arr.add(12);arr.add(16);
        List<Integer> res = isPower(arr);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
    public static List<Integer> isPower(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        boolean check;
        for(int i=0;i<arr.size();i++){
            check =arr.get(i)!=0 && ((arr.get(i)&(arr.get(i)-1)) == 0);
            if(check){
                result.add(1);
            }else
                result.add(0);
        }
        return result;
    }
//    static boolean isPowerOfTwo (int x)
//    {
//      /* First x in the below expression is
//        for the case when x is 0 */
//        return x!=0 && ((x&(x-1)) == 0);
//
//    }
}
