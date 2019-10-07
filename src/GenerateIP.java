import java.util.ArrayList;

public class GenerateIP {
    public static void main(String[] args) {
        System.out.println(generateIP("25525511135").toString());
    }

    private static ArrayList<String> generateIP(String s) {
        if(s.length()<3 && s.length()>12)
            return new ArrayList<>();
        return convertIP(s);
    }

    private static ArrayList<String> convertIP(String s) {

        String snew =s;
        ArrayList<String> list = new ArrayList<>();
        int size = s.length();

        for(int i=1;i<size-2;i++){
            for(int j=i+1;j<size-1;j++){
                for(int k=j+1;k<size;k++){
                    snew=snew.substring(0,k)+"."+snew.substring(k);
                    snew=snew.substring(0,j)+"."+snew.substring(j);
                    snew=snew.substring(0,i)+"."+snew.substring(i);

                    if(isValidStr(snew)){
                        list.add(snew);
                    }
                    snew=s;
                }
            }
        }
    return list;
    }

    private static boolean isValidStr(String s) {
        String[] arr = s.split("\\.");int val;
        for(String a:arr){
            val=Integer.parseInt(a);
            if(a.length()>3||val<0||val>255)
                return false;
            if(a.length()>1&&val==0)
                return false;
            if(a.length()>1&&val!=0&&a.charAt(0)=='0')
                return false;
        }
    return true;
    }
}
