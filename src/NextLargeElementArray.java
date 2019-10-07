import java.util.Stack;

public class NextLargeElementArray {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        findNextLargeElement(arr);
    }

    private static void findNextLargeElement(int[] arr) {
//        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(!st.empty()){
                if(st.peek()>arr[i]){
                    st.push(arr[i]);
                }else{
                    //System.out.println(arr[i]);
                    while(!st.empty()&&st.peek()!=null&&st.peek()<arr[i]){
                        System.out.println(st.pop());
                    }
                    st.push(arr[i]);
                }
            }else{
                st.push(arr[i]);
            }
        }
        if(!st.empty()){
            System.out.println("--");
            while(!st.empty()&&st.peek()!=null){
               System.out.println(st.pop());
            }
        }

    }
}
