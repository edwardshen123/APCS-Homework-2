import java.util.ArrayList;

public class MergeSort {

    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	ArrayList<Integer> c = new ArrayList<Integer>();
	while (a.size() > 0 && b.size() > 0) {
	    if (a.get(0) < b.get(0)) {
		c.add(a.remove(0));
	    } else {
		c.add(b.remove(0));
	    }
	}
	while (a.size() > 0) {
	    c.add(a.remove(0));
	}
	while (b.size() > 0) {
	    c.add(b.remove(0));
	}
	return c;
    }
    
    public static void main(String[] args) {
	ArrayList<Integer> a = new ArrayList<Integer>();
	ArrayList<Integer> b = new ArrayList<Integer>();
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(4);
	a.add(5);
	b.add(0);
	b.add(3);
	b.add(4);
	b.add(6);
	b.add(7);
	System.out.println(MergeSort.merge(a, b));
    }
    
}
