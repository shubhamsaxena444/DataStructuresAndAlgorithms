package leetcode.amazonAndMicrosoft.arraysAndString;

import java.util.ArrayList;
/*Lets look at how the co-ordinates change when you move from one element to the other in the anti-diagonal.

With every movement, row increases by one, and the column decreases by one ( or in other words (1, -1) gets added to the current co-ordinates ).

Now, all we need to know is the start ( or the first element ) in each diagonal.

Can you figure out which elements qualify as the first elements in each diagonal ?*/
public class Antidiagonal {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < a.size()*2-1; i++)
            res.add(new ArrayList<Integer>());

        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(0).size(); j++){
                res.get(i+j).add(a.get(i).get(j));
            }
        }

        return res;
    }
}
