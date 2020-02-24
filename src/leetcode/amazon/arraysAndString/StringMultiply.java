package leetcode.amazon.arraysAndString;

public class StringMultiply {
    public static String multiply(String a, String b) {
        int[] res = new int[a.length() + b.length()];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                res[i + j + 1] += (a.charAt(i) - '0') * (b.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = res.length-1; i >= 0; i--) {
            int val = res[i] + carry;
            res[i] = val % 10;
            carry = val / 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < res.length-1 && res[i] == 0) {
            i++;
        }
        while (i < res.length) {
            sb.append( (char) (res[i] + '0') );
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123","32"));
    }
}
