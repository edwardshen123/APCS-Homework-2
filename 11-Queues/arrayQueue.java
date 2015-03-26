import java.util.Arrays;

public class arrayQueue {

    private int front;
    private int end;
    private int length;
    private int[] a;

    public arrayQueue() {
	a = new int[10];
	front = 0;
	end = 0;
	length = 0;
    }

    public void enqueue(int data) {
	calcLength();
	if (length + 1 > a.length) {
	    adjust();
	}
	a[end] = data;
	end++;
	calcLength();
    }

    public int dequeue() {
	if (!empty()) {
	    int tmp = a[front];
	    adjust();
	    end--;
	    calcLength();
	    return tmp;
	} else {
	    return -1;
	}
    }

    public boolean empty() {
	return front == end;
    }
    
    public void adjust() {
	if (full()) {
	    int[] b = new int[a.length + 10];
	    int i = 0;
	    while (i < a.length) {
		b[i] = a[i];
		i++;
	    }
	    a = b;
	} else {
	    int[] b = new int[a.length];
	    int i = 0;
	    while (i < length) {
		b[i] = a[front + i];
		i++;
	    }
	    a = b;
	}
    }

    public void calcLength() {
	length = end - front;
    }

    public boolean full() {
	return length == a.length;
    }
    
    public String toString() {
	return Arrays.toString(a);
    }

    public static void main(String[] args) {
	arrayQueue aq = new arrayQueue();
	int i = 0;
	while (i < 20) {
	    aq.enqueue(i);
	    i++;
	}
	aq.dequeue();
	System.out.println(aq);
    }
}
