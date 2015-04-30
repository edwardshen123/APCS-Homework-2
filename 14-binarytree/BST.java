import java.io.*;
import java.util.*;
public class BST{
    //root of the tree
    Node r;
    
    public Node search(Node t, int i){
	if (t==null || t.getData()==i)
	    return t;
	else if (t.getData() < i)
	    return search(t.getRight(),i);
	else
	    return search(t.getLeft(),i);	
    }
    
    public String search(int i){
	Node retval = search(r,i);
	if (retval==null)
	    return "Not Found";
	else
	    return ""+retval;
    }
    
    public void insert(int i){
	Node n = new Node(i);
	Node t2=null;
	Node t = r;
	if (r==null){
	    r=n;
	    return;
	}
	
	while (t!=null){
	    t2 = t;
	    if (t.getData()==i)
		return;
	    else if (t.getData() < i)
		t=t.getRight();
	    else if (t.getData() > i)
		t=t.getLeft();
	    else
		return;
	}
	
	
	if (i>t2.getData())
	    t2.setRight(n);
	else
	    t2.setLeft(n);
    }

    /*
      Remove
      1) Use search to get pointer T to node to be removed and T2 to its parent
      2)
        a) T is a leaf, point T2's left or right to null
	b) T has 1 child, point T2's left or right to its non-null child
	c)
	  1) T has 2 children, find largest on left subtree ( or smallest on right) L = T.getLeft() while (L.getRight()!=null) L = L.getRight();
	  2) Copy the data from L into T
	  3) Remove (T.getLeft(), L.getData())
     */
    public void remove(Node root, int removed) {
	//The Search
	Node t2=null;
	Node t = root;
	while (t!=null){
	    if (t.getData()==removed)
		break;
	    else {
		t2 = t;
		if (t.getData() < removed)
		    t=t.getRight();
		else if (t.getData() > removed)
		    t=t.getLeft();
	    }
	}
	if (t != null) {
	    //The Remove
	    if (t.getLeft() != null && t.getRight() != null) {
		Node L = t.getRight();
		while (L.getLeft() != null) {
		    L = L.getLeft();
		}
		t = L;
		remove(t.getRight(), L.getData());
	    } else if (t.getLeft() != null) {
		if (t2.getLeft() == t) t2.setLeft(t.getLeft());
		else t2.setRight(t.getLeft());
	    } else if (t.getRight() != null) {
		if (t2.getLeft() == t) t2.setLeft(t.getRight());
		else t2.setRight(t.getRight());
	    } else {
		if (t2.getLeft() == t) t2.setLeft(null);
		else t2.setRight(null);
	    }
	}
    }

    public void remove(int removed) {
	remove(r, removed);
    }

    //In-Order Traversal (prints all data set in order)
    public String traverse(Node t){
	if (t == null) {
	    return "null";
	} else {
	    return traverse(t.getLeft()) + ", " + t.getData() + ", " + traverse(t.getRight());
	}
    }
    public String toString(){
	return traverse(r);
    }
    
    public static void main(String[] args){
	BST t = new BST();
	Random r = new Random();
	for (int i = 0; i < 20; i ++){
	    int z = r.nextInt(100);
	    //System.out.println(z);
	    t.insert(z);
	}
	t.insert(0);
	System.out.println(t);
	t.remove(0);
	System.out.println(t);
    }
}






								


		
