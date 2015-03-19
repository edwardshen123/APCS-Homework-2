public class LList{
    private Node l;
    private int length = 0;

    public LList() {
	l = new Node(0);
    }
	
    public void add(int d){
	Node tmp = new Node(d);
	tmp.setNext(l);
	l = tmp;
	length++;
    }
    
    public int get(int n) {
	if (n < 0 || n > length) {
	    throw new IndexOutOfBoundsException();
	}
	int i = 0;
	Node tmp = l;
	while (i < n) {
	    tmp = tmp.getNext();
	    i++;
	}
	return tmp.getData();
    }

    public void add(int n, int d) {
	if (n < 0 || n > length) {
	    return;
	}
	if (n == 0) {
	    add(d);
	} else {
	    int i = 0;
	    Node newNode = new Node(d);
	    Node tmp = l;
	    while (i + 1 < n) {
		tmp = tmp.getNext();
		i++;
	    }
	    newNode.setNext(tmp.getNext());
	    tmp.setNext(newNode);
	}
	length++;
    }

    /*
    public int remove(int n) {
	if (n < 0 || n > length) {
	    return "Can't remove";
	}
	if (n == 0) {
	    l = l.getNext();
	}
	int index = n - 1;
	Node tmp = l;
	while (index > 0) {
	    tmp = tmp.getNext();
	    index--;
	}
	Node removed = tmp.getNext();
	tmp.setNext(tmp.getNext().getNext());
	return removed.getData();
    }
    */

    public boolean remove(int i) {
	Node tmp = l;
	for (int n = 0; n < length; n++) {
	    if (tmp.getNext().getData() == i) {
		Node removed = tmp.getNext();
		tmp.setNext(removed.getNext());
		return true;
	    }
	    tmp = tmp.getNext();
	}
	return false;
    }

    /* Piggy Backing Pointers
       public boolean remove(int i) {
       Node T = l.getNext();
       Node T2 = l;
       while (T != null) {
       if (T.getData() == n) {
       T2.setNext(T.getNext());
       return True;
       }
       T2 = T;
       T = T.getNext();
       }
       return false;
       }
     */
    
    public int length() {
	return length;
    }

    public String toString(){
	String s = "";
	Node tmp = l;
	int lCounter;
	for (lCounter = length; lCounter > 0 ; lCounter--){
	    s = s + tmp;
	    if (lCounter > 1) {
		s = s + " --> ";
	    }
	    tmp=tmp.getNext();
	}
	return s;
    }
}
