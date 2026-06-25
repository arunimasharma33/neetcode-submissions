/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node, Node> map= new HashMap<>();
        Queue<Node> q= new LinkedList<>();
        Node clone= new Node(node.val);
        q.add(node);
        map.put(node, clone);
        while(!q.isEmpty()){
            Node current=q.poll();
            for(Node nb: current.neighbors){
                if(!map.containsKey(nb)){
                    Node nbclone= new Node(nb.val);
                    q.add(nb);
                    map.put(nb, nbclone);
                }
                map.get(current).neighbors.add(map.get(nb));
            }
        }
        return clone;
    }
}