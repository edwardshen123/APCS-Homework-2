import java.util.*;

public class myStack<E> implements Iterable<E>{

    private Node<E> current;

    public myStack() {
	current = new Node<E>();
    }

    public Iterator<E> iterator() {
	coverNode n = new coverNode<E>(current.getBelow());
	return n;
    }

    public void push(E data) {
	Node tmp = new Node(data);
	current.setAbove(tmp);
	tmp.setBelow(current);
	current = tmp;
    }

    public E pop() {
	Node tmp = current;
	Node next = current.getBelow();
	current = next;
	current.setAbove(null);
	return tmp.getData();
    }

    public boolean empty() {
	return current.getBelow() == null;
    }

    public E top() {
	return current.getData();
    }

    public String toString() {
	String s = "";
	Node tmp = current;
	while (tmp.getBelow() != null) {
	    s += tmp.getData() + "\n";
	    tmp = tmp.getBelow();
	}
	return s;
    }
    
    public static void main(String[] args) {
    }
    
}
