package leetcode.amazon.arraysAndString;

public class IntegerToEnglishWord {

    public static void main(String[] args) {
        final IntegerToEnglishWord n = new IntegerToEnglishWord();
        n.print();
    }

    /**
     *
     */
    private void print() {
        // System.out.println(Unit.getValue(6));
        // final Scanner sc = new Scanner(System.in);
        // final int n = sc.nextInt();
        for (int n = 1; n < Integer.MAX_VALUE;) {
            if (n < 0) {
                System.exit(0);
            }
            System.out.println(n + " ->  " + numToWords(n).toString());
            n = n * 13;
        }
    }

    private enum Unit {
        One(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9);
        private final int value;

        Unit(int value) {
            this.value = value;
        }

        private static String getValue(int value) {
            for (final Unit e : Unit.values()) {
                if (e.value == value) {
                    return e.name();
                }
            }
            return null;// not found
        }
    }

    private enum Ten {
        Ten(10), Eleven(11), Twelwe(12), Thirteen(13), Fourteen(14), Fifteen(15), Sixteen(16), Seventeen(17), Eighteen(
                18), Nineteen(19), Twenty(
                20), Thirty(30), Forty(40), Fifty(50), Sixty(60), Seventy(70), Eighty(80), Ninty(90);
        private final int value;

        Ten(int value) {
            this.value = value;
        }

        private static String getValue(int value) {
            for (final Ten e : Ten.values()) {
                if (e.value == value) {
                    return e.name();
                }
            }
            return null;// not found
        }
    }

    private enum Power {
        Hundred(100), Thousand(1000), Million(1000000);
        private final int value;

        Power(int value) {
            this.value = value;
        }

        private static String getValue(int value) {
            for (final Power e : Power.values()) {
                if (e.value == value) {
                    return e.name();
                }
            }
            return null;// not found
        }
    }

    private StringBuilder numToWords(final int n) {
        final StringBuilder s = new StringBuilder("");
        int num = n;
        if (n == 0) {
            return s.append("Zero");
        }
        // find the number of digits in n;
        // int digit = 0;
        // while (num >= 0) {
        // digit++;
        // num /= 10;
        // }
        num = n;
        while (num > 0) {
            if (num >= Power.Million.value) {
                printTens(s, num / Power.Million.value);
                s.append(" " + Power.Million.name() + " ");
                num %= Power.Million.value;
            } else if (num >= Power.Thousand.value) {
                int x = num / Power.Thousand.value;
                if (x >= Power.Hundred.value) {
                    printTens(s, x / Power.Hundred.value);
                    s.append(" " + Power.Hundred.name() + " ");
                    x %= Power.Hundred.value;
                }
                printTens(s, x);
                s.append(" " + Power.Thousand.name() + " ");
                num %= Power.Thousand.value;
            } else if (num >= Power.Hundred.value) {

                printTens(s, num / Power.Hundred.value);
                s.append(" " + Power.Hundred.name() + " ");
                num %= Power.Hundred.value;
            } else {
                printTens(s, num);
                num = 0;
            }
        }

        return s;
    }

    /**
     * @param s
     * @param num
     */
    private void printTens(final StringBuilder s, int num) {

        if (num >= Ten.Twenty.value && num <= 99) {
            final int x = num / Ten.Ten.value;
            s.append(Ten.getValue(x * 10));
            s.append(" " + Unit.getValue(num % 10));
        } else if (num >= Ten.Ten.value && num <= Ten.Nineteen.value) {
            s.append(Ten.getValue(num));
        } else {
            s.append(Unit.getValue(num));
        }
    }
}
