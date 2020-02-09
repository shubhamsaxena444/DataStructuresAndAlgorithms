package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class Sol3 {

    static class Pair{
        Integer id;
        Integer score;

        public Pair(Integer id, Integer score) {
            this.id = id;
            this.score = score;
        }
    }
    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        // Write your code here
        // put pos and neg keywords in set<String>

        //lets maintain a pq of n size, wi=hich will have a pair<hotel id, score>
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.score > o2.score){
                    return -1;
                }else if(o1.score < o2.score){
                    return 1;
                }else{
                    if(o1.id > o2.id){
                        return 1;
                    }else if(o1.id > o2.id){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        });


        HashSet<String> pos = (HashSet<String>) Arrays.stream(positiveKeywords.split(" ")).map(x->x.toLowerCase()).collect(Collectors.toSet());
        HashSet<String> neg = (HashSet<String>) Arrays.stream(negativeKeywords.split(" ")).map(x->x.toLowerCase()).collect(Collectors.toSet());

        HashMap<Integer,Integer> map = new HashMap<>();

        int n = hotelIds.size();
        int m = reviews.size();
        //since m and n are always same.
        if(n!=m){
            return new ArrayList<>();
        }
        for(int i =0;i<n;i++){
            int score =0;
            //get the ith review and split
            for(String keyword : reviews.get(i).split(" ")){
                //trim the string
                keyword = keyword.replace('.',' ');

                keyword = keyword.replace(',',' ');

                keyword = keyword.replace('!',' ');
                keyword= keyword.trim();
                keyword = keyword.toLowerCase();
                //for each keyword
                if(pos.contains(keyword)){
                    score+=3;
                }else if(neg.contains(keyword)){
                    score -= 1;
                }else{
                    //skip
                }
            }
            if(map.get(hotelIds.get(i)) ==null){
                map.put(hotelIds.get(i),score);
            }else{
                Integer value = map.get(hotelIds.get(i)) + score;
                map.put(hotelIds.get(i), value);
            }
        }
        //put each entry in pq;
        for(Map.Entry pair: map.entrySet()){
            //key =  id, val = score
            pq.add(new Pair((int)pair.getKey(),(int)pair.getValue()));
        }
        List<Integer> res = new ArrayList<>();
        while(k-->0 && !pq.isEmpty()){
            res.add(pq.remove().id);
        }
        return res;
    }

    public static void main(String[] args) {
        String positiveKeywords ="breakfast beach citycenter location metro view staff price";
        String negativeKeywords= "not";
        List<Integer> hotelIds = new ArrayList<>(Arrays.asList(5 ,1 ,2 ,1 ,1 ,2 ,5));
        List<String> reviews = new ArrayList<>(Arrays.asList(
"This hotel has a nice view of the citycenter. The location is perfect.",
                "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
                "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
                "Good price but I couldn't take my dog and there were other guests with dogs!",
                "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."


        ));
        int k =2;
        awardTopKHotels(positiveKeywords,negativeKeywords,hotelIds,reviews,k).stream().forEach(x-> System.out.println(x));
    }

}
