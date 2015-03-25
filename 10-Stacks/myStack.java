public class myStack<E> {

    private Node<E> current;

    public myStack() {
	current = new Node<E>();
    }

    public void push(E data) {
	Node<E> tmp = new Node<E>(data);
	current.setAbove(tmp);
	tmp.setBelow(current);
	current = tmp;
    }

    public E pop() {
	Node<E> tmp = current;
	Node<E> next = current.getBelow();
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
	Node<E> tmp = current;
	while (tmp.getBelow() != null) {
	    s += tmp.getData() + " --> ";
	    tmp = tmp.getBelow();
	}
	return s;
    }
    
}
