import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String str = "CATSANDDOG";
        HashSet<String> hset = new HashSet<>();
        hset.add("CAT");
        hset.add("SAND");
        hset.add("DOG");
        hset.add("CATS");
        hset.add("AND");

        ArrayList<String> res = breakWord(str, hset);
        System.out.println(res);
    }

    private static ArrayList<String> breakWord(String s, HashSet<String> set) {
//        if(s==null||s.length()==0){
//            return new ArrayList<String>();
//        }
        List<List<String>> pos = new ArrayList<List<String>>(s.length() + 1);
        for (int i = 0; i <= s.length(); i++) {
            pos.add(null);
        }
        pos.set(0, new ArrayList<>());

        for (int i = 0; i < s.length(); i++) {
            if (pos.get(i) == null)
                continue;

            for (String word : set) {
                int len = word.length();
                int end = len + i;
                if (end > s.length()) {
                    continue;
                }
                if (s.substring(i, end).equals(word)) {
                    if (pos.get(end) == null) {
                        pos.set(end, new ArrayList<String>());
                    }
                    pos.get(end).add(word);
                }
            }
        }

        ArrayList<String> res = new ArrayList<String>();
        if (pos.get(s.length()) == null){
            System.out.println("Empty");
            return res;
        }

        ArrayList<String> tmp = new ArrayList<String>();
        printWord(pos, s.length(), res, tmp);
        return res;
    }

    private static void printWord(List<List<String>> pos, int length, ArrayList<String> res, ArrayList<String> tmp) {

        if (length <= 0) {
            res.add(String.join(" ", tmp));
//            System.out.println(String.join(" ", tmp));
            return;
        }

        for (String word : pos.get(length)) {
            tmp.add(0,word);
            printWord(pos, length - word.length(), res, tmp);
            tmp.remove(0);
        }


    }
}
