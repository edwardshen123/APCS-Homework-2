import java.io.*;
import java.util.*;

public class maze {
    private char[][] board;
    private int maxX;
    private int maxY;

    private int exitX;
    private int exitY;
    
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
	    while (sc.hasNext()) {
		String line = sc.nextLine();
		for (int i=0;i<maxX;i++) {
		    board[i][j] = line.charAt(i);
		}
		j++;
	    }
	    findExit();
	}
	catch (Exception e) {
	}			
    }

    /*
      solved - instance variable to indicate we're done
			
    */
    public void BFS(Node start){
	if (isExit(start)) solved = true;
	if (isPath(start)) {
	    frontier.enqueue(start);
	}
	Node current = start;
	//finds a path
	while (solved == false && !frontier.empty()) {
	    System.out.println(this);
	    current = frontier.dequeue();
	    int x = current.getX();
	    int y = current.getY();
	    if (isExit(current)) {
		solved = true;
		board[x][y] = visited;
	    } else {
		board[x][y] = visited;
		delay(100);
		Node top = new Node(x, y - 1, mandist(x, y - 1));
		Node right = new Node(x + 1, y, mandist(x + 1, y));
		Node bottom = new Node(x, y + 1, mandist(x, y + 1));
		Node left = new Node(x - 1, y, mandist(x - 1, y));
		toEnqueue(top, current);
		toEnqueue(right, current);
		toEnqueue(bottom, current);
		toEnqueue(left, current);
	    }
	}
	if (solved) {
	    Node tmp = current;
	    //draws in correct path
	    while (tmp != null) {
		int x = tmp.getX();
		int y = tmp.getY();
		board[x][y] = me;
		tmp = tmp.getBack();
	    }
	}
    }

    public void aStar(Node start) {
	if (isExit(start)) solved = true;
	if (isPath(start)) {
	    frontier.enqueue(start);
	}
	Node current = start;
	//finds a path
	while (solved == false && !frontier.empty()) {
	    System.out.println(this);
	    current = frontier.dequeue();
	    int x = current.getX();
	    int y = current.getY();
	    if (isExit(current)) {
		solved = true;
		board[x][y] = visited;
	    } else {
		board[x][y] = visited;
		delay(100);
		Node top = new Node(x, y - 1, current.getcsn() + 1, mandist(x, y - 1));
		Node right = new Node(x + 1, y, current.getcsn() + 1, mandist(x + 1, y));
		Node bottom = new Node(x, y + 1, current.getcsn() + 1, mandist(x, y + 1));
		Node left = new Node(x - 1, y, current.getcsn() + 1, mandist(x - 1, y));
		toEnqueue(top, current);
		toEnqueue(right, current);
		toEnqueue(bottom, current);
		toEnqueue(left, current);
	    }
	}
	if (solved) {
	    Node tmp = current;
	    //draws in correct path
	    while (tmp != null) {
		int x = tmp.getX();
		int y = tmp.getY();
		board[x][y] = me;
		tmp = tmp.getBack();
	    }
	}
    }
    
    public void findExit() {
	for (int i = 0; i < maxX; i++) {
	    for (int j = 0; j < maxY; j++) {
		if (board[i][j] == exit) {
		    exitX = i;
		    exitY = j;
		}
	    }
	}
    }

    public int mandist(int x, int y) {
	return (exitX - x) + (exitY - y);
    }

    public double pydist(int x, int y) {
	return Math.sqrt(Math.pow(exitX - x, 2) + Math.pow(exitY - y, 2));
    }
    
    //checks if node should be queued and queues it
    public void toEnqueue(Node queued, Node traceback) {
	if (isPath(queued) || isExit(queued)) {
	    frontier.enqueue(queued);
	    queued.setBack(traceback);
	}
    }

    //checks if node is a path
    public boolean isPath(Node n) {
	return (n.getX() < maxX && n.getX() > 0 &&
		n.getY() < maxY && n.getY() > 0 &&
		board[n.getX()][n.getY()] == path);
    }

    //checks if node is exit
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
	//m.BFS(new Node(1, 1, m.mandist(1, 1)));
	m.aStar(new Node(1, 1, m.mandist(1, 1)));
	System.out.println(m);
		
    }
}
