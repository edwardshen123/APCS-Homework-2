public class Node{
    private Node next;

    private Node back;
    private int dist;

    private int x, y;
    
    public Node() {
	this(0, 0);
    }
    
    public Node(int x, int y) {
	this.x = x;
	this.y = y;
	next = null;
	back = null;
    }

    public Node getNext() {
	return next;
    }
    public void setNext(Node node) {
	next = node;
    }
    public Node getBack() {
	return back;
    }
    public void setBack(Node node) {
	back = node;
    }
    public int getX() {
	return x;
    }
    public int getY() {
	return y;
    }
}
