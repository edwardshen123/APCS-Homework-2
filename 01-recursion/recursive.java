public class recursive {

    public char[] cArray;
    
    public static int factorial(int n) {
	if (n <= 1) return 1;
	return n * factorial(n - 1);
    }

    public static int fib(int n) {
	if (n == 0) {
	    return 0;
	}
	if (n == 1) {
	    return 1;
	}
	return fib(n - 2) + fib(n - 1);
    }

    //Method 1
    public static int len(String str) {
	if (str.equals("")) {
	    return 0;
	}
	return 1 + len(str.substring(1));
    }

    /*
    //Method 2
    public int len(String str) {
	cArray = str.toCharArray();
	if (cArray == []) {
	    return 0;
	}
	return 1 + len(new String(cArray[1
    }
    */
    
    public static int count(String str, String c) {
	if (str.equals("")) {
	    return 0;
	}
	if (str.substring(0,1).equals(c)) {
	    return 1 + count(str.substring(1), c);
	}
	return count(str.substring(1), c);
    }
    
    public static void main(String[] args) {
	System.out.println(factorial(5));
	System.out.println(fib(3));
	String str = "Hello World";
	System.out.println(len(str));
	System.out.println(count(str, "o"));
    }
}
