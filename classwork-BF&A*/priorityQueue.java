public class priorityQueue {

    private int length;

    //Node
    private Node front;
    private Node end;

    public priorityQueue() {
	front = null;
	end = front;
	length = 0;
    }

    //Add node based on priority
    public void enqueue(Node n) {
	if (front == null) {
	    front = n;
	    end = front;
	} else {
	    Node tmp = front;
	    int i = tmp.getPriority();
	    while (tmp != null && i < n.getPriority()) {
		tmp = tmp.getNext();
		if (tmp != null) {
		    i = tmp.getPriority();
		}
	    }
	    Node prev;
	    if (tmp == null) {
		prev = end;
	    } else {
		prev = tmp.getBefore();
	    }
	    insert(prev, tmp, n);
	}
	length++;
    }

    //add to back of queue
    public void enqueue(int x, int y, int distToExit) {
	Node tmp = new Node(x, y, distToExit);
	enqueue(tmp);
    }

    //remove and return front
    public Node dequeue() {
	if (!empty()) {
	    Node retnode = front;
	    front = front.getNext();
	    if (front != null) {
		front.setBefore(null);
	    }
	    retnode.setNext(null);
	    length--;
	    return retnode;
	} else {
	    return null;
	}
    }

    //Inserts a node between two nodes
    public void insert(Node prev, Node next, Node insert) {
	if (prev == null) {
	    insert.setNext(next);
	    next.setBefore(insert);
	    front = insert;
	} else if (next == null) {
	    prev.setNext(insert);
	    insert.setBefore(prev);
	    insert.setNext(next);
	    end = insert;
	} else {
	    prev.setNext(insert);
	    insert.setBefore(prev);
	    insert.setNext(next);
	    next.setBefore(insert);
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

    //return length
    public int length() {
	return length;
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
