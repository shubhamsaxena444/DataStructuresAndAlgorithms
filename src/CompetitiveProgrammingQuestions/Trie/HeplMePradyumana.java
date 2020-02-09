package CompetitiveProgrammingQuestions.Trie;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
/*
* Help Me Pradyumana!
Send Feedback
Pradyumn is tired of using auto - correct feature in his smartphone. He needs to correct his auto - correct more times than the auto - correct corrects him. Pradyumn is thinking to make his own app for mobile which will restrict auto - correct feature, instead it will provide auto - completion. Whenever Pradyumn types factorial, auto - correct changes it to fact. Pradyumn's App will show options such as fact, factorial, factory. Now, he can chose from any of these options. As Pradyumn is busy with his front - end work of his App. He asks you to help him. He said "You will be given set of words(words may repeat too but counted as one only). Now, as user starts the app, he will make queries(in lowercase letters only). So, you have to print all the words of dictionary which have the prefix same as given by user as input. And if no such words are available, add this word to your dictionary." As you know, Pradyumn want this app to be as smart as him :P So, implement a program for him such that he can release it on Fun Store.
INPUT CONSTRAINTS
1≤N≤30000
sum(len(string[i]))≤2∗10^5
1≤Q≤10^3
INPUT FORMAT
Single integer N which denotes the size of words which are input as dictionary
N lines of input, where each line is a string of consisting lowercase letter
Single integer Q which denotes the number of queries.
Q number of lines describing the query string on each line given by user
OUTPUT FORMAT
If auto - completions exists, output all of them in lexicographical order else output "No suggestions" without quotes

NOTE: All strings are lowercase
SAMPLE INPUT
3
fact
factorial
factory
2
fact
pradyumn
SAMPLE OUTPUT
fact
factorial
factory
No suggestions*/
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pradyumn Agrawal coderbond007
 */
 class HelpMePradyumana {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        HeyPleaseHelpMe solver = new HeyPleaseHelpMe();
        solver.solve(1, in, out);
        out.close();
    }

    static class HeyPleaseHelpMe {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            String ans = getAnswer(in);
            out.print(ans);
        }

        public static String getAnswer(FastReader in) {
            int n = in.nextInt();
            HeyPleaseHelpMe.Node root = null;
            String[] words = in.nextStringArray(n);
            for (String word : words) {
                root = insertWord(root, word.toLowerCase());
            }
            StringBuilder stringBuilder = new StringBuilder();
            int Q = in.nextInt();
            for (int q = 0; q < Q; q++) {
                String prefix = in.nextString().toLowerCase();
                List<String> autocompletions = getWords(root, prefix);
                if (autocompletions == null) {
                    root = insertWord(root, prefix);
                    stringBuilder.append("No suggestions\n");
                } else {
                    for (String word : autocompletions) {
                        stringBuilder.append(word + "\n");
                    }
                }
            }
            return stringBuilder.toString();
        }

        public static HeyPleaseHelpMe.Node insertWord(HeyPleaseHelpMe.Node root, String word) {
            if (root == null) {
                root = new HeyPleaseHelpMe.Node();
            }
            HeyPleaseHelpMe.Node v = root;

            for (char letter : word.toCharArray()) {
                HeyPleaseHelpMe.Node temp = v.child[letter - 'a'];
                if (temp == null) {
                    temp = v.child[letter - 'a'] = new HeyPleaseHelpMe.Node();
                }
                v = v.child[letter - 'a'];
            }
            v.isWord = true;
            return root;
        }

        public static List<String> getWords(HeyPleaseHelpMe.Node root, String prefix) {
            HeyPleaseHelpMe.Node v = root;
            List<String> autocompletions = new ArrayList<>();
            for (char letter : prefix.toCharArray()) {
                HeyPleaseHelpMe.Node temp = v.child[letter - 'a'];
                if (temp == null) {
                    return null;
                }
                v = v.child[letter - 'a'];
            }
            dfs(v, autocompletions, new String(prefix));
            return autocompletions;
        }

        public static void dfs(HeyPleaseHelpMe.Node root, List<String> autocompletions, String s) {
            if (root.isWord) {
                autocompletions.add(s);
            }
            for (int i = 0; i < 26; i++) {
                if (root.child[i] != null) {
                    dfs(root.child[i], autocompletions, new String(s + (char) (i + 'a')));
                }
            }
        }

        public static class Node {
            public boolean isWord;
            public HeyPleaseHelpMe.Node[] child;

            public Node() {
                this.isWord = false;
                this.child = new HeyPleaseHelpMe.Node[26];
            }

        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (pnumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= pnumChars) {
                curChar = 0;
                try {
                    pnumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (pnumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c == ',') {
                    c = read();
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String[] nextStringArray(int n) {
            String[] array = new String[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextString();
            }
            return array;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}