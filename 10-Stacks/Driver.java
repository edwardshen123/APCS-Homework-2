public class Driver {
    public static void main(String[] args) {
	myStack<Integer> ms = new myStack<Integer>();
	int i = 0;
	while (i < 10) {
	    ms.push(i);
	    i++;
	}
	System.out.println(ms);
	while (!ms.empty()) {
	    System.out.println(ms.pop());
	}
	System.out.println(ms);
    }
}
