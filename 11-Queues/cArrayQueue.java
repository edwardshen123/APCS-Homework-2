import java.util.Arrays;

public class cArrayQueue {

    private int front;
    private int end;
    private int direction;
    private int length;
    private int[] a;

    public cArrayQueue() {
	a = new int[100];
	front = 0;
	end = 0;
	direction = 1;
	calcLength();
    }

    /*
    public void enqueue(int data) {
	if (end < a.length) {
	    a[end] = data;
	    end++;
	}
    }

    public int dequeue() {
	if (!empty()) {
	    int tmp = a[front];
	    a[front] = -1;
	    front++;
	    return tmp;
	}
	return -1;
    }
    */

    public void enqueue(int data) {
	calcLength();
    }
    public int dequeue() {
	if (!empty()) {
	    if (direction > 0) {
		int tmp = a[front];
		a[front] = -1;
		front++;
	    } else {
		int tmp = a[end];
		a[end] = -1;
		end--;
	    }
	    calcLength();
	    return tmp;
	} else {
	    return -1;
	}
    }

    public void swap() {
	direction = direction * -1;
    }

    public void adjust() {
	//useless
    }

    public void calcLength() {
	length = end - front;
    }

    public boolean empty() {
	return length == 0;
    }

    public String toString() {
	return Arrays.toString(a);
    }

    public static void main(String[] args) {
	cArrayQueue caq = new cArrayQueue();
	int i = 0;
	while (i < 10) {
	    caq.enqueue(i);
	    i++;
	}
	System.out.println(caq);
    }
}
