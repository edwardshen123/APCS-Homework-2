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

    public static ArrayList<Integer> sort(ArrayList<Integer> a) {
	if (a.size() <= 1) {
	    return a;
	}
	
	ArrayList<Integer> b = new ArrayList<Integer>();
	int temp = a.size() / 2;
	while (a.size() > temp) {
	    b.add(a.remove(0));
	}
	ArrayList<Integer> A1 = sort(b);
	ArrayList<Integer> A2 = sort(a);

	return merge(A1, A2);
    }

    public static int[] merge(int[] a, int[] b) {
	int[] c = new int[a.length + b.length];
	int aIndex = 0;
	int bIndex = 0;
	int cIndex = 0;
	while (aIndex < a.length && bIndex < b.length) {
	    if (a[aIndex] > b[bIndex]) {
		c[cIndex] = b[bIndex];
		bIndex++;
	    } else {
		c[cIndex] = a[aIndex];
		aIndex++;
	    }
	    cIndex++;
	}
	while (aIndex < a.length) {
	    c[cIndex] = a[aIndex];
	    aIndex++;
	    cIndex++;
	}
	while (bIndex < b.length) {
	    c[cIndex] = b[bIndex];
	    bIndex++;
	    cIndex++;
	}
	return c;
    }

    public static int[] sort(int[] a) {
	if (a.length <= 1) {
	    return a;
	}

	int[] b = new int[a.length / 2];
	int[] c = new int[a.length - a.length / 2];

	for (int aIndex = 0; aIndex < a.length; aIndex++) {
	    if (aIndex < a.length / 2) {
		b[aIndex] = a[aIndex];
	    } else {
		System.out.println(aIndex);
		c[aIndex + a.length /  2 - a.length] = a[aIndex];
	    }
	}

	b = sort(b);
	c = sort(c);

	return merge(b, c);
    }
    
    public static void main(String[] args) {
	/*
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
	ArrayList<Integer> c = new ArrayList<Integer>();
	c.add(10);
	c.add(4);
	c.add(5);
	c.add(0);
	c.add(3);
	System.out.println(MergeSort.sort(c));
	*/

	int[] a = {34, 234, 10, 30, 2, 9};
	System.out.println(MergeSort.sort(a));
    }
}
