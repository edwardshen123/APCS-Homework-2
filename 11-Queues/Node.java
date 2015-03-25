public class Node<E>{
    private Node next;
    private Node before;
    private E data;

    public Node() {
	data = null;
	next = null;
	before = null;
    }
    
    public Node(E data) {
	this.data = data;
	next = null;
	before = null;
    }

    public Node getBefore() {
	return before;
    }
    public void setBefore(Node node) {
	before = node;
    }
    public Node getNext() {
	return next;
    }
    public void setNext(Node node) {
	next = node;
    }
    public E getData() {
	return data;
    }
    public void setData(E data) {
	this.data = data;
    }

    public String toString() {
	String s = "" + data;
	return s;
    }
}
