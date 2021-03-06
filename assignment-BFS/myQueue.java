public class myQueue {

    //Node
    private Node front;
    private Node end;

    public myQueue() {
	front = null;
	end = front;
    }

    public void enqueue(Node n) {
	if (front == null) {
	    front = n;
	    end = front;
	} else {
	    end.setNext(n);
	    end = n;
	}
    }

    //add to back of queue
    public void enqueue(int x, int y) {
	Node tmp = new Node(x, y);
	enqueue(tmp);
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
	Node tmp = front;
	String s = "";
	while (tmp != null) {
	    s += "(" + tmp.getX() + "," + tmp.getY() + ") ---> ";
	    tmp = tmp.getNext();
	}
	return s;
    }
}
