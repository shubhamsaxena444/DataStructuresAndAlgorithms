package GFG.tests;

import java.util.Scanner;

public class sol2 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in );


        System.out.println(solution(new int[]{1,4,-1,3,2}));

    }
    class Node{
        int v;
        Node next;

        public Node(int v) {
            this.v = v;
        }
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length ==0)return 0;

       // Node head = new Node(-1);
     //   Node cur = head;
        int index = 0;
        int i=0;
        while(index != -1){
          //  cur.next = new Node(A[index]);
            try {
                index = A[index];
            }catch (ArrayIndexOutOfBoundsException e){
                return -1;
            }
         //   cur =cur.next;
            i++;
        }

        return i;
    }
}
