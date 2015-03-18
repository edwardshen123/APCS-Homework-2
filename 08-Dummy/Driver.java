import java.util.Random;
import java.util.LinkedList;
import java.util.ArrayList;

public class Driver{
    public static void main(String[] args) {
	LList l = new LList();
	LinkedList<Integer> ll = new LinkedList<Integer>();
	long start, elapsed;
	Random num = new Random();
	/*
	l.add("hello");
	l.add("world");
	for (int i=0;i<5;i++){
	    l.add(""+i);
	}
	System.out.println(l);
	//System.out.println(l.find(5));
	l.add(l.length(), "hi");
	//l.remove(5);
	System.out.println(l);
	*/
	for (int i = 0; i < 100000; i++) {
	    int number = num.nextInt();
	    l.add(number);
	    ll.add(number);
	}
	int sum = 0;
	//System.out.println(l.remove(2));
	start = System.currentTimeMillis();
	for (int i = 0; i < ll.size(); i++) {
	    sum += ll.get(i);
	}
	elapsed = System.currentTimeMillis() - start;
	System.out.println(elapsed);
	sum = 0;
	start = System.currentTimeMillis();
	for (int i = 0; i < l.length(); i++) {
	    sum += l.get(i);
	}
	elapsed = System.currentTimeMillis() - start;
	System.out.println(elapsed);
    }
}
