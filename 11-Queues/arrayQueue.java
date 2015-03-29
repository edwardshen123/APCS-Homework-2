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
    /* With data shift
    public void enqueue(int data) {
	if (full()) {
	    adjust('a');
	}
	a[end] = data;
	end++;
	calcLength();
    }

    public int dequeue() {
	if (!empty()) {
	    int tmp = a[front];
	    adjust('d');
	    end--;
	    calcLength();
	    return tmp;
	} else {
	    return -1;
	}
    }
    
    public void adjust(char mode) {
	if (mode == 'a') {
	    int[] b = new int[a.length + 10];
	    int i = 0;
	    while (i < a.length) {
		b[i] = a[i];
		i++;
	    }
	    a = b;
	}
	if (mode == 'd') {
	    int[] b = new int[a.length];
	    int i = 0;
	    while (i < length - 1) {
		b[i] = a[front + i + 1];
		i++;
	    }
	    a = b;
	}
    }
    */

    //without data shift
    public void enqueue(int data) {
	if (reachedEnd()) {
            adjust();
        }
        a[end] = data;
        end++;
        calcLength();
    }
    public int dequeue() {
	if (!empty()) {
	    int tmp = a[front];
	    a[front] = -1;
	    front++;
	    calcLength();
	    return tmp;
	} else {
	    return -1;
	}
    }
    public void adjust() {
	int[] b = new int[a.length + 10];
	int i = 0;
	while (i < a.length) {
	    b[i] = a[i];
	    i++;
	}
	a = b;
    }

    public boolean empty() {
	return front == end;
    }
    public boolean reachedEnd() {
	return end > length;
    }
    public void calcLength() {
	length = end - front;
    }

    public boolean full() {
	return length >= a.length;
    }
    
    public String toString() {
	return Arrays.toString(a);
    }

    public static void main(String[] args) {
	arrayQueue aq = new arrayQueue();
	int i = 0;
	while (i < 10) {
	    aq.enqueue(i);
	    i++;
	}
	aq.dequeue();
	aq.enqueue(11);
	System.out.println(aq);
    }
}
