package hacker_rank;

public class AppendAndDelete {
    public static void main(String[] args) {
//        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
        System.out.println(appendAndDelete("abcd", "abcdert", 10));
//        System.out.println(appendAndDelete("y", "yu", 2));
//        System.out.println(appendAndDelete(
//                "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv",
//                "bsdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv", 100));
    }

    static String appendAndDelete(String s, String t, int k) {
        int commonIndex = getCommonIndex(s, t);
        System.out.println(commonIndex);


        return ((s.length() + t.length() - commonIndex * 2) <= k) ? "Yes" : "No";
    }

    private static int getCommonIndex(String s, String t) {
        for (int i = Math.min(s.length(), t.length()); 0 < i; i--) {
            if (t.substring(0, i).equals(s.substring(0, i))) return i;
        }
        return 0;
    }
}
