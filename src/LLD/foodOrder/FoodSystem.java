package LLD.foodOrder;

import java.util.*;

enum Strategy{
    BEST_RATED

}
public class FoodSystem {

    PriorityQueue<Restaurant> bestRated = new PriorityQueue<>(new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant o1, Restaurant o2) {
            return o1.rating -o2.rating ;
        }


    });

    void autoAssign(){


    }

    void onboardRestaurant(Restaurant restaurant){
        bestRated.add(restaurant);
    }

    void placeOrder(Map<Item , Integer> items, Strategy strategy){
        if(strategy.equals(Strategy.BEST_RATED)){
            Restaurant restaurant = null;
            while(!bestRated.isEmpty() && restaurant.canProcess() ==false){
               restaurant = bestRated.poll();
            }
            if(restaurant ==null){
                System.out.println("CAN NOT PROCESS ORDER");
            }else{
                Order order = new Order(items,status.ACCEPTED);
                restaurant.placeOrder(order);
            }

        }
    }
}
