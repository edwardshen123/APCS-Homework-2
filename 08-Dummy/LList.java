public class LList{
    private Node l;
    private int length = 0;

    public LList() {
	l = new Node("");
    }
	
    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
	length++;
    }
    
    public String get(int n) {
	if (n < 0 || n > length) {
	    return "Can't access";
	}
	int i = 0;
	Node tmp = l;
	while (i < n) {
	    tmp = tmp.getNext();
	    i++;
	}
	return tmp.toString();
    }

    public void add(int n, String s) {
	if (n < 0 || n > length) {
	    return;
	}
	if (n == 0) {
	    add(s);
	} else {
	    int i = 0;
	    Node newNode = new Node(s);
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

    public Node remove(int n) {
	if (n < 0 || n >= length) {
	    return new Node("Can't remove");
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
	return removed;
    }

    public String toString(){
	String s = "";
	Node tmp = l;
	int lCounter;
	for (lCounter = length; lCounter > 0 ; lCounter--){
	    s = s + tmp;
	    if (tmp.getNext() != null) {
		s = s + " --> ";
	    }
	    tmp=tmp.getNext();
	}
	return s;
    }
}
