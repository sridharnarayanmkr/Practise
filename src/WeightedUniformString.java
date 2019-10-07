import java.util.Vector;

public class WeightedUniformString {
    public static void main(String[] args) {
        int[] q = {9,7,8,12,5};
        String[] out = weightedUniformStrings("aaabbbbcccddd", q);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }

    static String[] weightedUniformStrings(String s, int[] queries) {
        Vector<Integer> hset = new Vector<>();
        String[] result = new String[queries.length];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (checkUniformity(str)) {
                    hset.add(calculateWeight(str));
                }
            }
        }
        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            if (hset.contains(queries[i])) {
                result[j++] = "Yes";
            } else {
                result[j++] = "No";
            }
        }
        return result;
    }

    private static boolean checkUniformity(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    static int calculateWeight(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(i) - 'a' + 1;
        }
        return result;
    }
}
