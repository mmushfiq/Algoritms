package az.mm.algoritms.recursion;

public class StringReverse {

public static void main(String[] args) {
    reverseExplain("programmer");
}

public static String reverseExplain(String str) {
    if (str.length() == 0) {
        System.out.println("Recursion ends, reverse starts!");
        return str;
    }
    String s = reverseExplain(getSubstring(str)) + getFirstChar(str);
    return s;
}

private static char getFirstChar(String str) {
    System.out.println(str + " --> " + str.charAt(0));
    return str.charAt(0);
}

private static String getSubstring(String str) {
    System.out.println(str.substring(1));
    return str.substring(1);
}
}
