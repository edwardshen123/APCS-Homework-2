public class Node{
    private Node next;
    private int priority;
    //csn = current step number [the number of steps made so far]
    private int csn;
    
    private Node back;
    private int dist;

    private int x, y;
    
    public Node() {
	this(0, 0, 0);
    }
    
    public Node(int x, int y, int p) {
	this.x = x;
	this.y = y;
	next = null;
	back = null;
	priority = p;
	csn = 0;
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
    public int getPriority() {
	return priority;
    }
    public void setPriority(int newP) {
	priority = newP;
    }
    public int getcsn() {
	return csn;
    }
    public void setcsn(int ncsn) {
	csn = ncsn;
    }
}
