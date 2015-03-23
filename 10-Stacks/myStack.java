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
    }

    public E pop() {
    }

    public boolean empty() {
    }

    public E top() {
    }

    public String toString() {
	
    }
    
    public static void main(String[] args) {
    }
    
}
