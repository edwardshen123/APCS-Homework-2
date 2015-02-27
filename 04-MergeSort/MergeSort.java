import java.util.ArrayList;
import java.util.Random;

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

	int length = a.length;
	
	int[] b = new int[length / 2];
	int[] c = new int[length - a.length / 2];
	int cIndex = 0;

        for (int aIndex = 0; aIndex < length; aIndex++) {
	    if (aIndex < length / 2) {
		b[aIndex] = a[aIndex];
	    } else {
		c[cIndex] = a[aIndex];
		cIndex++;
	    }
	}

	b = sort(b);
	c = sort(c);

	return merge(b, c);
    }

    public static String toString(int[] a) {
	String s = "{";
	for (int aIndex = 0; aIndex < a.length; aIndex++) {
	    if (aIndex < a.length - 1) {
		s += a[aIndex] + ", ";
	    } else {
		s += a[aIndex];
	    }
	}
	s += "}\n";
	return s;
    }
    
    public static void main(String[] args) {
	/*
	Random rand = new Random();
	ArrayList<Integer> a = new ArrayList<Integer>();
	ArrayList<Integer> b = new ArrayList<Integer>();
	for (int aIndex = 0; aIndex < 5; aIndex++) {
	    a.add(rand.nextInt(50) * (aIndex + 1));
	}
	for (int bIndex = 0; bIndex < 5; bIndex++) {
	    b.add(rand.nextInt(50) * (bIndex + 1));
	}
	System.out.println(a);
	System.out.println(b);
	System.out.println(MergeSort.merge(a, b));
	ArrayList<Integer> c = new ArrayList<Integer>();
	for (int cIndex = 0; cIndex < 5; cIndex++) {
	    c.add(rand.nextInt(50));
	}
	System.out.println(c);
	System.out.println(MergeSort.sort(c));
	*/

	int[] d = {34, 234, 10, 30, 2, 9};
	System.out.println(toString(MergeSort.sort(d)));
    }
}
