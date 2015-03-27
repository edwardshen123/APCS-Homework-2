public class myQueue<E> {

    //Node
    private Node<E> front;
    private Node<E> end;

    public myQueue() {
	front = new Node<E>();
	end = front;
    }

    //add to back of queue
    public void enqueue(E data) {
	Node<E> tmp = new Node<E>(data);
	tmp.setBefore(end);
	end.setNext(tmp);
	end = tmp;
    }

    //remove and return front
    public E dequeue() {
	if (!empty()) {
	    Node tmp = front.getNext();
	    Node next = tmp.getNext();
	    front.setNext(next);
	    next.setBefore(front);
	    return (E)tmp.getData();
	} else {
	    return null;
	}
    }

    //check if queue is empty
    public boolean empty() {
	return front == end && front == null;
    }

    //return front
    public E head() {
	return (E)front.getNext().getData();
    }

    public String toString() {
	Node<E> tmp = front.getNext();
	String s = "";
	while (tmp != end) {
	    s += tmp.getData() + " ---> ";
	    tmp = tmp.getNext();
	}
	s += tmp.getData();
	return s;
    }

    public static void main(String[] args) {
	myQueue<Integer> mq = new myQueue<Integer>();
	int i = 0;
	while (i < 10) {
	    mq.enqueue(i);
	    i++;
	}
	mq.enqueue(5);
	mq.enqueue(6);
	System.out.println(mq);
	for (i = 0; i < 12; i++) {
		System.out.println(mq.dequeue());
	}
	System.out.println(mq);
    }
}
