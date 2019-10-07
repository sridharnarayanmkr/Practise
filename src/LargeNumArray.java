import java.util.Arrays;

public class LargeNumArray {
    public static void main(String[] args) {

        String[] arr ={"3","30","34","5","9"};
        Arrays.sort(arr,(s1,s2)->{
            String a = s1+s2;
            String b = s2+s1;
            return b.compareTo(a);
        });
        for(String s:arr){
            System.out.print(s);
        }
    }
}

