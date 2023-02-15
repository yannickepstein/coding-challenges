public LFUCache {
    
    private final int capacity;
    private final Map<Integer, Integer> content = new HashMap<>();
    private final Map<Integer, Integer> usage = new HashMap<>();
    private final Map<Integer, CacheNode> queuePointer = new HashMap<>();
    private final CacheNode head = new CacheNode();
    private final CacheNode tail = new CacheNode();    
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if (queuePointer.containsKey(key)) {
            usage.merge(key, 1, Integer::sum);
            var node = queuePointer.get(key);
            bubbleDown(node);
        }
        return content.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if (content.containsKey(key)) {
            content.put(key, value);
            usage.merge(key, 1, Integer::sum);
            var node = queuePointer.get(key);
            bubbleDown(node);
            return;
        }
        if (content.size() == capacity) {
            evictLFU();
        }
        content.put(key, value);
        usage.put(key, 0);
        var node = new CacheNode(key);
        queuePointer.put(key, node);
        offerNode(node);
        bubbleDown(node);
    }
    
    private void bubbleDown(CacheNode node) {
        while (node.prev != head && usage.get(node.prev.key) <= usage.get(node.key)) {
            var newNext = node.prev;
            newNext.next = node.next;
            node.next.prev = newNext;
            node.prev = newNext.prev;
            newNext.prev = node;
            node.next = newNext;
        }
    }
    
    private void evictLFU() {
        var node = tail.prev;
        content.remove(node.key);
        queuePointer.remove(node.key);
        usage.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void offerNode(CacheNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }

    static class CacheNode {
        int key;
        CacheNode next;
        CacheNode prev;
        
        public CacheNode() {}
        
        public CacheNode(int key) {
            this.key = key;
        }
    }
}
