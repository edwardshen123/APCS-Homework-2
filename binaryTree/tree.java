public class tree{

    private Node root;

    public tree() {
	root = null;
    }

    public Node search(integer i) {
	Node T = root;
	Node T2;
	while (T != null) {
	    T2 = T;
	    int c = T.getData().compareTo(i);
	    if (c == 0) return T;
	    else if (c > 0) T = T.getRight();
	    else T = T.getLeft();
	}
	return T;
    }

    public void insert(integer i) {
	Node tmp = new Node(i);
    }
    
}
