import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("\\s+");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
