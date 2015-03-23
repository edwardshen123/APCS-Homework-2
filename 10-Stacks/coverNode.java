import java.util.*;

public class coverNode<E> implements Iterator<E> {
    private Node<E> below;
    private Node<E> above;

    public coverNode(Node node) {
	below = node;
	above = null;
    }

    public boolean hasNext() {
	return below.getBelow() != null;
    }

    public E next() {
	E retval = below.getData();
	above = below;
	below = below.getBelow();
	return retval;
    }

    public void remove() {
	if (above != null) {
	    above.getAbove().setBelow(below);
	    below.setAbove(above.getAbove());
	    above = above.getAbove();
	}
    }
    
}

