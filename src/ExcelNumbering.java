public class ExcelNumbering {
    public static void main(String[] args) {
        System.out.println(findCell(676));
    }

    private static String findCell(int num) {

        StringBuilder col = new StringBuilder();
        while(num>0){
            int rem = num%26;
            if(rem==0){
                col.append("Z");
                num=(num/26)-1;
            }else{
                col.append((char)((rem-1)+'A'));
                num/=26;
            }
        }
        return col.reverse().toString();

    }

}
