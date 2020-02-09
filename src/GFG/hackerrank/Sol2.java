package hackerrank;
import java.util.*;
public class Sol2 {
    public static int minSum(List<Integer> num, int k) {
        // Write your code here

        //take a PQ of max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // push all element  to pq
        for(Integer i: num){
            pq.add(i);
        }
        while(k-->0){
            // take the max element and devide it by 2

            Integer newElement = (int) Math.ceil(pq.poll()/2.0);
            //put the element back
            pq.add(newElement);
        }
        return pq.stream().mapToInt(Integer::intValue).sum();

    }
}
