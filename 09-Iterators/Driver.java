import java.util.*;

public class Driver{
    public static void main(String[] args) {
	LList<String> l = new LList<String>();
	LList<Integer> l2 = new LList<Integer>();
	
	l.add("Hello");
	l.add("world");
	l.add("abc");
	l.add("something");
	l.add("else");
	
	//System.out.println(l);

	for (int i=0;i < 5; i++){
	    l2.add(i);
	}
	
	System.out.println(l2);

	/*

	Iterator<String> i = l.iterator();
	while (i.hasNext())
	    System.out.println(i.next());		
	*/

	Iterator<Integer> i2 = l2.iterator();
	while (i2.hasNext()) {
	    System.out.println(i2.next());
	    i2.remove();
	}

	System.out.println(l2);

	/*
	//Java for each or for in loops
	for (String s: l) {
	    System.out.print(s + ", ");
	}
	*/
	
	
    }
}
