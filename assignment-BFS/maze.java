import java.io.*;
import java.util.*;
public class maze {
    private char[][] board;
    private int maxX;
    private int maxY;
    
    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;

    private myQueue<boolean> frontier;
		
    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }
		
    public Maze() {
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
	while (solved == false) {
	    if (isPath(start)) {
		frontier.enqueue(start);
	    }
	}
    }

    public boolean isPath(Node n) {
	return (n.getX() < maxX && n.getX() > 0 &&
		n.getY() < maxY && n.getY() > 0 &&
		board[n.getX()][n.getY()].equals(path));
    }

    public boolean isExit(Node n) {
	return board[n.getX()][n.getY()].equals(exit);
    }

    public String toString() {
	String s = "[2J\n";
	
	for (int y=0;y<maxY;y++) {
	    for (int x=0;x<maxX;x++)
		s = s +board[x][y];
	    s=s+"\n";
	}
	return s;
    }
		
    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.solve(new Node());
	System.out.println(m);
		
    }
}
