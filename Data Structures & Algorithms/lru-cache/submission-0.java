class LRUCache {
    class Node{
        Node prev, next;
        int key, val;
        Node(int k, int v){
            this.key=k;
            this.val= v;
        }
    }
    HashMap<Integer, Node> map= new HashMap<>();
    Node head= new Node(-1, -1);
    Node tail= new Node(-1,-1);
    
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
    tail.prev= head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){

            Node node=map.get(key);
            
            delete(node);
            insert(node);
            return node.val;

        }else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node= map.get(key);
            node.val=value;
            delete(node);
            insert(node);
        }else{
            if(map.size()==capacity){
                delete(tail.prev);
                insert(new Node(key, value));
            }else{
                insert(new Node(key, value));
            }
        }
    }
    public void delete(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev= node.prev;
    }
    public void insert(Node node){
        map.put(node.key, node);
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }
}
