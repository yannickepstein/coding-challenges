/**
 * Whenever we **read** a key, we will put it at the end of the queue of
 * things to remove first.
 * When we add a new key, we will put it at the end of the queue.
 * When we change a key, we don't adapt it. We want to optimize reads not writes.
 */
public class LRUCache {
    
    private final int capacity;
    private final Map<Integer, Integer> content = new HashMap<>();
    private final Map<Integer, CacheNode> queuePointers = new HashMap<>();
    private CacheNode head = new CacheNode();
    private CacheNode tail = new CacheNode();

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new InvalidArgumentException("capacity <= 0 is not allowed");
        }
        this.capacity = capacity;
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (queuePointers.containsKey(key)) {
            var node = queuePointers.get(key);
            removeNode(node);
            offerNode(node);
        }
        return content.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if (content.containsKey(key)) {
            content.put(key, value);
            return;
        }
        if (content.size() == capacity) {
            evictLRU();
        }
        content.put(key, value);
        var node = new CacheNode(key);
        offerNode(node);
        queuePointers.put(key, node);
    }
    
    private void evictLRU() {
       var node = tail.prev;
       content.remove(node.key);
       queuePointers.remove(node.key);
       removeNode(node);
    }
    
    private void removeNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void offerNode(CacheNode node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }
    
    static class CacheNode {
        int key;
        CacheNode next; // needs to be double linked, s.t. we can remove them easily when accessing a key
        CacheNode prev;
        
        public CacheNode() {}
        
        public CacheNode(int key) {
            this.key = key;
        }
    }
}
