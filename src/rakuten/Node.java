package rakuten;

import java.util.ArrayList;

public class Node {

    private String name;
    private ArrayList<Node> children;
    
    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<Node>();
    }

    public String getName() {
        return this.name;
    }

    public int nodeCount() {
        return this.children.size();
    }

    public Node getNode(int index) throws IndexOutOfBoundsException {      
        return this.children.get(index);
    }
    public void addNode(Node child) {
        this.children.add(child);
    }
}
        

