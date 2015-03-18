import java.util.Random;
import java.util.LinkedList;

public class Driver{
    public static void main(String[] args) {
	LList l = new LList();
	LinkedList<int> ll = new LinkedList<int>();
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
	    //l.add(num.nextInt());
	    ll.add(num.nextInt());
	}
	int sum = 0;
	//System.out.println(l.remove(2));
	start = System.currentTimeMillis();
	for (int i = 0; i < ll.length(); i++) {
	    sum += ll.get(i);
	}
	elapsed = System.currentTimeMillis() - start;
	System.out.println(elapsed);
    }
}
