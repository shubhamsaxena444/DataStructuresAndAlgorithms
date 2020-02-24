package GFG.intrerviewBit;

import java.util.Stack;

public class histogram {
    public int largestRectangleArea(int[] A) {

        Stack<Integer> s = new Stack<>();

        /* Precompute left end of rectangle for each bar at index i */

        int[] leftEnd = new int[A.length];

        for(int i=0; i < A.length; i++){

            while(!s.empty() && A[s.peek()] >= A[i])
                s.pop();

            leftEnd[i] = s.empty() ? 0 : (s.peek() + 1);

            s.push(i);
        }

        /* Empty the stack */
        while(!s.empty()) s.pop();

        /* Precompute right end of rectangle for each bar at index i */

        int[] rightEnd = new int[A.length];

        for(int i=A.length-1; i >= 0; i--){

            while(!s.empty() && A[s.peek()] >= A[i])
                s.pop();

            rightEnd[i] = s.empty() ? A.length-1 : (s.peek() - 1);

            s.push(i);
        }

        /* Compute Maximum area possible for each bar */
        int maxarea = 0;
        for(int i = 0; i < A.length; i++){
            int area = (rightEnd[i] - leftEnd[i] + 1) * A[i];
            maxarea = Math.max(maxarea, area);
        }

        return maxarea;

    }
}
