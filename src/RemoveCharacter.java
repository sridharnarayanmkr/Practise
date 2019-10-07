public class RemoveCharacter {
    public static void main(String[] args) {

        String s1 = "removeccharaterfrom";
        String s2 = "string";
        removeCharsFromFirst(s1,s2);

    }

    private static void removeCharsFromFirst(String s1, String s2) {

//        StringBuilder stringBuilder = new StringBuilder(s1);
        for(int i=0;i<s2.length();i++){
            if(s1.contains(""+s2.charAt(i))){
               s1= s1.replace(""+s2.charAt(i),"");
            }
        }
        System.out.println(s1);

    }
}
