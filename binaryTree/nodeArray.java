import java.util.ArrayList;
public class nodeArray {

    private ArrayList<Node> nodes;

    public nodeArray() {
	nodes = new ArrayList<Node>();
    }

    public void add(Node n) {
	nodes.add(n);
    }
    public Node get(int index) {
	return nodes.get(index);
    }
    public String toString() {
	return nodes.toString();
    }
    public int size() {
	return nodes.size();
    }
}
