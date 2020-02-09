package leetcode.uber.treesAndGraphs;

import java.util.LinkedList;
import java.util.*;
/*
* Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
             * */
public class ReconstructItinerary {
//TC = O(E+V)

    List<String> result = new ArrayList();

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap();
        for(List<String> list : tickets) {
            PriorityQueue<String> temp = graph.getOrDefault(list.get(0), new PriorityQueue());
            temp.add(list.get(1));
            graph.put(list.get(0), temp);
        }
        dfs(graph, "JFK");
        return result;
    }

    public void dfs(HashMap<String, PriorityQueue<String>> graph, String start) {
        PriorityQueue<String> n = graph.get(start);

        if(n == null){
            result.add(0, start);
            return;
        }

        while(!n.isEmpty()){
            String arr = n.remove();
            dfs(graph, arr);
        }
        result.add(0, start);
    }
}
