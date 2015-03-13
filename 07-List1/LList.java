public class LList{
    private Node l=null;
    
    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
    }

    public String find(int n) {
	if (n < 0) {
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

    public void insert(int n, String s) {
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
    }

    public String toString(){
	String s = "";
	Node tmp;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }
}
