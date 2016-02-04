import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;


public class Q137_Clone_Graph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        
        dfsHelper(node, copy, map);
        return copy;
    }
    
    public void dfsHelper(UndirectedGraphNode node, UndirectedGraphNode copy, Map<Integer, UndirectedGraphNode> map){
        map.put(copy.label, copy);
        
        for(UndirectedGraphNode n : node.neighbors){
            if(!map.containsKey(n.label)){
               UndirectedGraphNode newCopy = new UndirectedGraphNode(n.label);
               dfsHelper(n, newCopy, map);
               copy.neighbors.add(newCopy);
            } else{
                copy.neighbors.add(map.get(n.label));
            }
        }
    }
}


class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
