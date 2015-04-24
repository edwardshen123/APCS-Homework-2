public class Node implements Comparable{
    private int data;
    private Node left, right;

    public Node() {
	this(0);
    }

    public Node(int data) {
	this.data = data;
	left = null;
	right = null;
    }

    public int compareTo(int i) {
    }

    public int getData() {
	return data;
    }
    public void setData(int data) {
	this.data = data;
    }

    public void setLeft(Node n) {
	left = n;
    }
    public void setRight(Node n) {
	right = n;
    }
    public Node getLeft() {
	return left;
    }
    public Node getRight() {
	return right;
    }
}
