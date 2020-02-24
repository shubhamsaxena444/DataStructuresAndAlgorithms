package leetcode.amazon.arraysAndString;

import java.util.Scanner;

public class IntegerToEnglishWord {

    public static void main(String[] args) {
        final IntegerToEnglishWord n = new IntegerToEnglishWord();
        n.print();
    }

    /**
     *
     */
    private void print() {
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
        Hundred(100), Thousand(1000), Million(1000000),Billion(1000000000);
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

        num = n;
        while (num > 0) {
            if (num >= Power.Billion.value) {
                printPrefix(s, num / Power.Billion.value);
                s.append(" " + Power.Billion.name() );
                num %= Power.Billion.value;
            }else if (num >= Power.Million.value) {
                printPrefix(s, num / Power.Million.value);
                s.append(" " + Power.Million.name() );
                num %= Power.Million.value;
            } else if (num >= Power.Thousand.value) {
                printPrefix(s, num / Power.Thousand.value);
                s.append(" " + Power.Thousand.name() );
                num %= Power.Thousand.value;
            }else{
                printPrefix(s, num);
                //remember to put num =0 , when done
                num = 0;
            }
        }

        return s;
    }

    /**
     * @param s
     * @param num can be from 1 upto 999
     */
    private void printPrefix(final StringBuilder s, int num) {
        while(num>0) {

            if (num >= Power.Hundred.value && num <= 999) {
                final int x = num / Power.Hundred.value;
                s.append(" " + Unit.getValue(x));
                s.append(" " + Power.getValue(100));
                num %= Power.Hundred.value;
            }else if (num >= Ten.Twenty.value && num <= 99) {
                final int x = num / Ten.Ten.value;
                s.append(" "+ Ten.getValue(x * 10));
                num%=10;
            } else if (num >= Ten.Ten.value && num <= Ten.Nineteen.value) {
                s.append(" "+Ten.getValue(num));
                //remember to put num =0 , when done
                num=0;
            } else {
                s.append(" "+Unit.getValue(num));
                //remember to put num =0 , when done
                num=0;
            }
        }
    }
}
