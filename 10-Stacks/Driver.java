public class Driver {
    public static void main(String[] args) {
	myStack<Integer> ms = new myStack<Integer>();
	int i = 0;
	while (i < 10) {
	    ms.push(i);
	}
	System.out.println(ms);
	Iterator msi = ms.iterator();
	while (msi.hasNext()) {
	    System.out.println(msi.next());
	    msi.remove();
	}
	System.out.println(ms);
    }
}
