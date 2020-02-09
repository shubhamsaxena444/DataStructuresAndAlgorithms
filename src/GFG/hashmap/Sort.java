package hashmap;

import java.util.*;

public class Sort {
   static String[][] groupingDishes(String[][] dishes) {

        int d  =  dishes.length;
        int m = dishes[0].length;

        TreeMap<String,TreeSet<String>> hm = new TreeMap<>();
        for(int i =0;i<d;i++){
            String dish = dishes[i][0];
            for(int j =1;j<m;j++){
                hm.putIfAbsent(dishes[i][j],new TreeSet<String>());
                hm.get(dishes[i][j]).add(dish);
            }

        }
        List<List<String>> ss = new ArrayList<>();
        // int i =0;
        for(Map.Entry<String,TreeSet<String>> e : hm.entrySet()){
            List<String> temp = new ArrayList<String>();
            ss.add(temp);
            temp.add(e.getKey());
            //dishes[i][0] = e.getKey();
            // int j =1;
            for(String s : e.getValue()){
                // dishes[i][j] = s;
                temp.add(s);
                // j++;
            }

            // i++;
        }

        String[][] sss = new String[ss.size()][d+1];

        for(int i =0;i<ss.size();i++){
            for(int j =0;j<d+1;j++){
                sss[i][j] =ss.get(i).get(j);
            }
        }

        return sss;
    }

    public static void main(String[] args) {
        String[][] dishes =new String[][]{ {"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
        {"Quesadilla", "Chicken", "Cheese", "Sauce"},
            {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};
        groupingDishes(dishes);

    }
}
