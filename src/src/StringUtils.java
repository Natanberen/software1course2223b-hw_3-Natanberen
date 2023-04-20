public class StringUtils {

    public static String findSortedSequence(String str) {
        String[] words = str.split(" ");
        String st = words[0];
        String st1 = "";
        int cnt = 1;
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            System.out.println(words[i].compareTo(words[i + 1]));
            if (words[i].compareTo(words[i + 1]) <= 0) {
                st = st + " " + words[i + 1];
                System.out.println(st);
                cnt++;
            }
            if (words[i].compareTo(words[i + 1]) > 0 || i + 1 == words.length - 1) {
                //System.out.println(st);
                if (cnt >= max) {
                    max = cnt;
                    st1 = st;
                }
                st = words[i + 1];
                cnt = 1;
            }

        }
        if (max == 1)
            return words[words.length - 1];


        return st1;
    }


    public static boolean isEditDistanceOne(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            // If the length difference is greater than 1, it's impossible
            return false;
        }
        if (a.equals(b))
            return true;
        int editCount = 0;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                editCount++;
                if (editCount > 1) {
                    return false;
                }
                if (a.length() > b.length()) {
                    i++;
                } else if (a.length() < b.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
        if (i < a.length() || j < b.length()) {
            editCount++;
        }
        return editCount == 1;

    }

}