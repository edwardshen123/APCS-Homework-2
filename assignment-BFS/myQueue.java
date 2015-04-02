public class myQueue {

    //Node
    private Node front;
    private Node end;

    public myQueue() {
	front = new Node();
	end = front;
    }

    //add to back of queue
    public void enqueue(int x, int y) {
	Node tmp = new Node(x, y);
	end.setNext(tmp);
	end = tmp;
    }

    //remove and return front
    public Node dequeue() {
	if (!empty()) {
	    Node tmp = front.getNext();
	    Node next = tmp.getNext();
	    front.setNext(next);
	    return tmp;
	} else {
	    return null;
	}
    }

    //check if queue is empty
    public boolean empty() {
	return front == end && front == null;
    }

    //return front
    public Node head() {
	return front.getNext();
    }

    public String toString() {
	Node tmp = front.getNext();
	String s = "";
	while (tmp != end) {
	    s += tmp.getProcessed() + " ---> ";
	    tmp = tmp.getNext();
	}
	s += tmp.getProcessed();
	return s;
    }
}
