public class HexadecimalSubtraction {
    public static void main(String[] args) {
        String s1 = "974B";
        String s2= "587C";
        int n1=Integer.parseInt(s1,16);
        int n2 = Integer.parseInt(s2,16);
        System.out.println(Integer.toHexString(n1-n2));
    }
}
