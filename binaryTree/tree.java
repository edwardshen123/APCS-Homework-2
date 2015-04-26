import java.util.ArrayList;

public class tree{

    private Node root;
    private Node T2;

    private ArrayList<nodeArray> nodes = new ArrayList<nodeArray>();

    public tree() {
	root = null;
	T2 = null;
    }

    public Node search(int i) {
	Node T = root;
	while (T != null) {
	    T2 = T;
	    int c = T.compareTo(i);
	    if (c == 0) return T;
	    else if (c < 0) T = T.getRight();
	    else T = T.getLeft();
	}
	return T;
    }

    //broken
    public void insert(int i) {
	Node tmp = new Node(i);
	if (root == null) {
	    root = tmp;
	} else {
	    Node child = search(i);
	    if (child != null) {
		int t = child.compareTo(i);
		if (t < 0) {
		    tmp.setLeft(child);
		} else {
		    tmp.setRight(child);
		}
	    }
	    int t2 = T2.compareTo(i);
	    if (t2 > 0) {
		T2.setLeft(tmp);
	    } else {
		T2.setRight(tmp);
	    }
	}
    }

    public boolean moreLayers(nodeArray na) {
	for (int i = 0; i < na.size(); i++) {
	    if (na.get(i) != null) {
		return true;
	    }
	}
	return false;
    }

    public void createLayers() {
	nodeArray na = new nodeArray();
	na.add(root);
	nodes.add(na);
	boolean hasMore = moreLayers(na);
	while (hasMore) {
	    nodeArray prev = na;
	    na = new nodeArray();
	    for (int i = 0; i < prev.size(); i++) {
		if (prev.get(i) != null) {
		    na.add(prev.get(i).getLeft());
		    na.add(prev.get(i).getRight());
		} else {
		    na.add(null);
		    na.add(null);
		}
	    }
	    nodes.add(na);
	    hasMore = moreLayers(na);
	}
    }

    public String toString() {
	createLayers();
	String s = "";
	for (int i = 0; i < nodes.size(); i++) {
	    s += nodes.get(i) + "\n";
	}
	return s;
    }

    public static void main(String[] args) {
	tree t = new tree();
	t.insert(1);
	t.insert(2);
	t.insert(3);
	t.insert(5);
	t.insert(4);
	System.out.println(t.search(3));
	System.out.println(t);
    }
    
}
