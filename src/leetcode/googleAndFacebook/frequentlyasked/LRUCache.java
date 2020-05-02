package leetcode.googleAndFacebook.frequentlyasked;

import java.util.*;
/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
// */
public class LRUCache {
    class Element{
        int k;
        int v;
        Element(int k,int v){
            this.k = k;
            this.v = v;
        }
    }
    int cap ;
    Deque<Element> q ;
    HashMap<Integer,Element> map ;

    public LRUCache(int capacity) {
        cap = capacity;
        q = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key) == false){
            return -1;
        }else{
            // modify the ds, by placing key element to rear

            q.remove(map.get(key));
            q.addLast(map.get(key));
            return map.get(key).v;
        }
    }

    public void put(int key, int value) {
        Element el =new Element(key,value);
        if(q.size() <cap ){
            if(!map.containsKey(key)){
                //add the current item

                q.addLast(el);
                map.put(key,el);
            }else{

                q.remove(map.get(key));
                q.addLast(el);
                map.put(key,el);
            }
        }else if(!map.containsKey(key)){
            //cache miss
            //evict LRU item
            Element front =  q.removeFirst();
            map.remove(front.k);
            //add the current item

            q.addLast(el);
            map.put(key,el);
        }else{
            //cache hit
            //relocate lement to rear
            q.remove(map.get(key));
            q.addLast(el);
            map.put(key,el);
        }
    }
}
