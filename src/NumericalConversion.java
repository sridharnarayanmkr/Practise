public class NumericalConversion {
    public static void main(String[] args) {
//        convertHexToBin("1AC5");
//        convertBinToHex(110001110);
        convertWithInbuilt("1111001010010100001.010110110011011");
    }

    private static void convertWithInbuilt(String s) {
        String[] arr = s.split("\\.");
        StringBuilder str1 = new StringBuilder();
        if(arr[0].length()%4!=0){
            for(int i=0;i<(4-(arr[0].length()%4));i++)
                str1.append(0);
            str1.append(arr[0]);
        }
        if(arr[1].length()%4!=0){
            str1.append(arr[0]);
            for(int i=0;i<(4-(arr[0].length()%4));i++)
                str1.append(0);
        }
        int first = Integer.parseInt(arr[0],2);
        int second = Integer.parseInt(arr[1],2);
        System.out.println(first+" "+second);

        char[] hexChar={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hex="";
        while(first>0){
            int rem=first%16;
            hex=hexChar[rem]+hex;
            first/=16;
        }
        hex+=".";
        while(second>0){
            int rem=second%16;
            hex=hexChar[rem]+hex;
            second/=16;
        }
        System.out.println("Hexadecimal: "+hex);
    }

    private static void convertBinToHex(int num) {
        int dec=0,n=0;
        char[] hexChar={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while (true){
            if(num==0)
                break;
            int tmp=num%10;
            dec+=tmp*Math.pow(2,n);
            n++;
            num/=10;
        }
        System.out.println("Decimal: "+dec);
        String hex="";
        while(dec>0){
            int rem=dec%16;
            hex=hexChar[rem]+hex;
            dec/=16;
        }
        System.out.println("Hexadecimal: "+hex);

    }

    private static void convertHexToBin(String s) {
        String hexChar="0123456789ABCDEF";
        int val=0;
        for(int i=0;i<s.length();i++){
            int d = hexChar.indexOf(s.charAt(i));
            val=16*val+d;
        }
        System.out.println("Decimal: "+val);
        StringBuilder str = new StringBuilder();
        while(val>0){
            str.append(val%2);
            val/=2;
        }
        System.out.println("Binary: "+str.reverse().toString());

    }


}
