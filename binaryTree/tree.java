public class tree{

    private Node root;
    private Node T2;

    public tree() {
	root = null;
	T2 = null;
    }

    public Node search(int i) {
	Node T = root;
	while (T != null) {
	    T2 = T;
	    int c = T.getData().compareTo(i);
	    if (c == 0) return T;
	    else if (c > 0) T = T.getRight();
	    else T = T.getLeft();
	}
	return T;
    }

    public void insert(int i) {
	Node tmp = new Node(i);
	if (root == null) {
	    root = tmp;
	} else {
	    Node child = search(i);
	    if (child != null) {
		int t = i.compareTo(child.getData());
		if (t > 0) {
		    tmp.setLeft(child);
		} else {
		    tmp.setRight(child);
		}
	    }
	    int t2 = T2.getData().compareTo(i);
	    if (t > 0) {
		t.setLeft(tmp);
	    } else {
		t.setRight(tmp);
	    }
	}
    }

    public static void main(String[] args) {
	tree t = new tree();
	t.insert(1);
	t.insert(2);
    }
    
}
