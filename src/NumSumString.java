public class NumSumString {
    public static void main(String[] args) {
        getSum("1abc23");
    }

    private static void getSum(String s) {
        int sum=0,num=0;
        for(int i=0;i<s.length();i++){
            while(s.charAt(i)>=48 && s.charAt(i)<=57){
                num=num*10+(Character.getNumericValue(s.charAt(i)));
                if(i+1<s.length())
                    i++;
                else
                    break;
            }
            sum+=num;
            num=0;
        }
        System.out.println(sum);
    }
}
