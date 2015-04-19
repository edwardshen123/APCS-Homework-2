public class Node {

    //instance variables for queue
    private Node next;
    private Node before;
    private int priority;
    //csn = current step number [the number of steps made so far]
    private int csn;
    //dist = distance from exit
    private int dist;
    
    //for route trace back
    private Node back;

    private int x, y;
    
    public Node() {
	this(0, 0, 0, 0);
    }

    public Node(int x, int y, int distToExit) {
	this(x, y, 0, distToExit);
    }
    
    public Node(int x, int y, int csn, int distToExit) {
	this.x = x;
	this.y = y;
	next = null;
	back = null;
	this.csn = csn;
	dist = distToExit;
	priority = csn + distToExit;
    }

    public Node getNext() {
	return next;
    }
    public void setNext(Node node) {
	next = node;
    }
    public Node getBefore() {
	return before;
    }
    public void setBefore(Node node) {
	before = node;
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
    public int getcsn() {
	return csn;
    }
}
