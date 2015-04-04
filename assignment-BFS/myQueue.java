public class myQueue {

    //Node
    private Node front;

    public myQueue() {
	front = null;
    }

    public void enqueue(Node n) {
	Node tmp = n;
	tmp.setNext(front);
	front = tmp;
    }

    //add to back of queue
    public void enqueue(int x, int y) {
	Node tmp = new Node(x, y);
	tmp.setNext(front);
	front = tmp;
    }

    //remove and return front
    public Node dequeue() {
	if (!empty()) {
	    Node retnode = front;
	    front = front.getNext();
	    retnode.setNext(null);
	    return retnode;
	} else {
	    return null;
	}
    }

    //check if queue is empty
    public boolean empty() {
	return front == null;
    }

    //return front
    public Node head() {
	return front;
    }

    public String toString() {
	Node tmp = front.getNext();
	String s = "";
	while (tmp != null) {
	    s += tmp.getProcessed() + " ---> ";
	    tmp = tmp.getNext();
	}
	return s;
    }
}
