package az.mm.algoritms.recursion;

public class StringReverse {

    public static void main(String[] args) {
        System.out.printf("programmer --> %s%n", new StringBuilder("programmer").reverse());
        System.out.printf("programmer --> %s%n%n", reverse("programmer"));
        reverseExplain("programmer");
    }

    public static String reverse(String str) {
        if (str.length() == 0) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static String reverseExplain(String str) {
        if (str.length() == 0) {
            System.out.println("Recursion ends, reverse starts!");
            return str;
        }
        String s = reverseExplain(getSubstring(str)) + getFirstChar(str);
        return s;
    }

    static char getFirstChar(String str) {
        System.out.println(str + " --> " + str.charAt(0));
        return str.charAt(0);
    }

    static String getSubstring(String str) {
        System.out.println(str.substring(1));
        return str.substring(1);
    }

}
