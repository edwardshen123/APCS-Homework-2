public class Node{
    private Node next;

    private int x, y;
    
    private boolean processed;

    public Node() {
	this.Node(0, 0);
    }
    
    public Node(int x, int y) {
	processed = false;
	this.x = x;
	this.y = y;
	next = null;
    }

    public Node getNext() {
	return next;
    }
    public void setNext(Node node) {
	next = node;
    }
    public boolean getProcessed() {
	return processed;
    }
    public void setProcessed(boolean b) {
	processed = b;
    }
    public int getX() {
	return x;
    }
    public int getY() {
	return y;
    }

}
