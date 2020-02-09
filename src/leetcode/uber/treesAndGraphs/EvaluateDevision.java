package leetcode.uber.treesAndGraphs;

import java.util.*;

/*
* Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].


The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.*/
public class EvaluateDevision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String x = equation.get(0);
            String y = equation.get(1);
            map.putIfAbsent(x, new HashMap<>());
            map.putIfAbsent(y, new HashMap<>());
            map.get(x).put(x, 1.0);
            map.get(x).put(y, value);
            map.get(y).put(y, 1.0);
            map.get(y).put(x, 1 / value);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Double res = calculate(queries.get(i), map, new HashSet<>());
            if (res != null) results[i] = res;
            else results[i] = -1;
        }

        return results;
    }

    Double calculate(List<String> query, Map<String, Map<String, Double>> map, Set<String> visited) {
        String x = query.get(0);
        String y = query.get(1);
        if (map.get(x) == null || map.get(y) == null) return -1.0;
        Double result = map.get(x).get(y);
        if (result != null) return result;
        result = 1.0;
        //We don't find y inside available results;
        Map<String, Double> availableEquations = map.get(x);
        for (String key : availableEquations.keySet()) {
            if (key.equals(x)) continue;
            if (visited.contains(key)) continue;
            visited.add(key);
            result = result * availableEquations.get(key);
            Double subResult = calculate(Arrays.asList(key, y), map, visited);
            if (subResult != null) {
                map.get(key).put(y, subResult);
                result *= subResult;
                map.get(x).put(y, result);
                return result;
            }
            result /= availableEquations.get(key);
        }

        return null;
    }
}


