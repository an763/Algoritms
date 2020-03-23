import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    Node head;
    Node tail;
    Map<Integer,Node> map;
    int val;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            val = temp.val;
            remove(temp);
            add(temp);
        }else{
            val = -1;
        }
        return val;
    }
    
    public void put(int key, int value) {
       if(map.containsKey(key)){
           Node temp = map.get(key);
           temp.val = value;
           remove(temp);
           add(temp);
       }else{
           if(map.size() == capacity){
               map.remove(tail.prev.key);
               remove(tail.prev);
           }               
               Node temp = new Node();
               temp.val = value;
               temp.key = key;
               add(temp);
               map.put(key,temp);
           }
       }
    
    private void add(Node node){
        Node head_next = head.next;
        head.next = node;
        node.next = head_next;
        node.prev = head;
        head_next.prev = node;
    }
    
    private void remove(Node node){
        Node node_next = node.next;
        Node node_prev = node.prev;
        
        node_next.prev = node_prev;
        node_prev.next = node_next;        
    }
    
    class Node{
        int key;
        int val;
        Node prev;
        Node next;        
    }
        
    }
    
    


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */