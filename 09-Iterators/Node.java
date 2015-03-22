public class Node<E>{
    private E data;
    private Node<E> next;
    private Node<E> previous;
    
    public Node(){
	data = null;
	next = null;
	previous = null;
    }
    public Node(E s){
	data = s;
	next = null;
	previous = null;
    }
    public void setData(E s){
	data = s;
    }
    public E getData(){
	return data;
    }
    public void setNext(Node<E> n){
	next = n;
    }
    public Node<E> getNext(){
	return next;
    }
    public void setPrevious(Node<E> p) {
	previous = p;
    }
    public Node<E> getPrevious() {
	return previous;
    }
    public String toString(){
	return ""+data;
    }
}
