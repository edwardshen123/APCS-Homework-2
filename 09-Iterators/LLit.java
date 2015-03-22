import java.util.*;

public class LLit<E> implements Iterator<E>{
    private Node<E> t;
    private Node<E> p;
    public LLit(Node<E> n){
	t=n;
	p=null;
    }
    
    public boolean hasNext(){
	return t!=null;
    }
    
    public E next(){
	E retval = t.getData();
	p = t;
	t=t.getNext();
	return retval;
    }

    public void remove() {
	if (p != null) {
	    p.getPrevious().setNext(t);
	}
    }
}
