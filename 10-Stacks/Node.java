public class Node<E>{
    private Node above;
    private Node below;
    private E data;

    public Node() {
	data = null;
	above = null;
	below = null;
    }
    
    public Node(E data) {
	this.data = data;
	above = null;
	below = null;
    }

    public Node getAbove() {
	return above;
    }
    public void setAbove(Node node) {
	above = node;
    }
    public Node getBelow() {
	return below;
    }
    public void setBelow(Node node) {
	below = node;
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
