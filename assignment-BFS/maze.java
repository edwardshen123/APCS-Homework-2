import java.io.*;
import java.util.*;
public class maze {
    private char[][] board;
    private int maxX;
    private int maxY;
    
    private static final char path='#';
    private static final char wall=' ';
    private static final char me='z';
    private static final char exit='$';
    private static final char visited = '.';
    private boolean solved = false;

    private myQueue frontier = new myQueue();
		
    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {
	}
    }
		
    public maze() {
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];
				
	try {					
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j=0;
	    while (sc.hasNext())
		{
		    String line = sc.nextLine();
		    for (int i=0;i<maxX;i++)
			{
			    board[i][j] = line.charAt(i);
			}
		    j++;
		}
	}
	catch (Exception e) {
	}			
    }

    /*
      solved - instance variable to indicate we're done
			
    */
    public void solve(Node start){
	if (isExit(start)) solved = true;
	if (isPath(start)) {
	    frontier.enqueue(start.getX(), start.getY());
	}
	while (solved == false && !frontier.empty()) {
	    System.out.println(this);
	    System.out.println(frontier);
	    Node current = frontier.dequeue();
	    int x = current.getX();
	    int y = current.getY();
	    if (isExit(current)) {
		solved = true;
		board[x][y] = me;
	    } else {
		board[x][y] = me;
		delay(100);
		Node top = new Node(x, y - 1);
		Node right = new Node(x + 1, y);
		Node bottom = new Node(x, y + 1);
		Node left = new Node(x - 1, y);
		toEnqueue(top);
		toEnqueue(right);
		toEnqueue(bottom);
		toEnqueue(left);
	    }
	}
    }

    public void toEnqueue(Node queued) {
	if (isPath(queued) || isExit(queued)) {
	    frontier.enqueue(queued);
	}
    }

    public boolean isPath(Node n) {
	return (n.getX() < maxX && n.getX() > 0 &&
		n.getY() < maxY && n.getY() > 0 &&
		board[n.getX()][n.getY()] == path);
    }

    public boolean isExit(Node n) {
	return board[n.getX()][n.getY()] == exit;
    }

    public String toString() {
	//String s = "[2J\n";
	String s = "";
	
	for (int y=0;y<maxY;y++) {
	    for (int x=0;x<maxX;x++)
		s = s +board[x][y];
	    s=s+"\n";
	}
	//s = s + "\n" + frontier;
	return s;
    }
		
    public static void main(String[] args){
	maze m = new maze();
	System.out.println(m);
	m.solve(new Node(1, 1));
	System.out.println(m);
		
    }
}
