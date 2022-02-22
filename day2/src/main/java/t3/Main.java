package t3;

/**
 * @author tzq0301
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        String str = "asdgjlsjgkdsjl";
        str = doStr(String::toUpperCase, str);
        str = doStr(s -> s.substring(2, 4), str);
        System.out.println(str);
    }

    public static String doStr(StringDemo function, String str) {
        return function.getValue(str);
    }
}
