package leetcode.googleAndFacebook.frequentlyasked;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]*/
public class TextJustification {

   /* Maintain variables
    i) currentWidth (sum of length of char in words seen so far + spaces)
    ii) charLength (sum of length of char in words seen so far)
    iii) list (maintains the words that can be accomodated in a line)
    When currentWidth exceeds maxWidth, justify the words seen so far and reset the variables and clear the list.
    For Justification, depending upon the list size, SingleSpace or MultiSpace method can be called.
    For the last line, use the single space method which will add single space and padding if the string does not reach maxWidth.*/
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int maxWidth = Integer.parseInt(sc.nextLine());
       String words[] = sc.nextLine().split(" ");
       TextJustification t = new TextJustification();
       t.fullJustify(words,maxWidth).stream().forEach(x-> System.out.println(x)  );
   }
    public List<String> fullJustify(String[] words, int maxWidth) {
        int currentWidth = 0;
        int charLength = 0;
        List<String> list = new ArrayList<>();
        List<String> output = new ArrayList<>();
        for (String word : words) {
            if (currentWidth + word.length() <= maxWidth) {
                currentWidth += word.length() + 1;
                charLength += word.length();
                list.add(word);
            } else {
                if (list.size() == 1) {
                    output.add(addSingleSpace(list, maxWidth));
                } else {
                    output.add(addMultiSpaces(list, charLength, maxWidth));
                }

                list.clear();
                currentWidth = word.length() + 1;
                charLength = word.length();
                list.add(word);
            }
        }
        if (list.size() > 0) {
            output.add(addSingleSpace(list, maxWidth));
        }
        return output;
    }

    String addSingleSpace(List<String> words, int maxWidth) {
        StringBuilder output = new StringBuilder();
        for (String word: words) {
            if (output.length() > 0) {
                output.append(" ");
            }
            output.append(word);
        }
        while (output.length() < maxWidth) {
            output.append(" ");
        }
        return output.toString();
    }

    String addMultiSpaces(List<String> words, int charLength, int maxWidth) {
        StringBuilder output = new StringBuilder();
        int freeSpace = maxWidth - charLength; //compute freeSpace
        int size = words.size() - 1;
        int min = freeSpace / size; //minimum free space between two consecutive words
        int count = 0;
        for (int j = 0; j < words.size(); j++) {
            output.append(words.get(j));
            // no need to add space after last word
            if (j == words.size() - 1) {
                continue;
            }
            for (int i = 1; i <= min; i++) {
                output.append(" ");
            }
            // if remainder is not 0, words on the left will have more padding
            if (count < (freeSpace % size)) {
                output.append(" ");
                count++;
            }
        }
        return output.toString();
    }
}
