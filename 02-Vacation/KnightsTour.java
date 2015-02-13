public class KnightsTour {

    private int stepsCounter;

    private int boardX;
    private int boardY;
    private String[][] board;
    
    private String notVisited = "*";
    private String Knight = "Kn";

    public int KnX;
    public int KnY;
    
    private int delayTimer = 0;
    private String ANSI_ESC = "\033\143";

    public KnightsTour() {
	this(5, 5, 0, 0);
    }

    public KnightsTour(int boardX, int boardY, int KnX, int KnY) {
	stepsCounter = 0;
	
	this.boardX = boardX;
	this.boardY = boardY;
	
	if (KnX > boardX || KnX < 0) KnX = 0;
	if (KnY > boardY || KnY < 0) KnY = 0;
	this.KnX = KnX;
	this.KnY = KnY;
	
	board = new String[boardY][boardX];
	for (int y = 0; y < board.length; y++) {
	    for (int x = 0; x < board[y].length; x++) {
		board[y][x] = notVisited;
	    }
	}

	board[KnY][KnX] = Knight;
    }

    public void Move(int KnX, int KnY) {
    }

    public void delay() {
	try {
	    Thread.sleep(delayTimer);
	} catch(Exception e) {
	};
    }
    
    public String toString() {

	System.out.print(ANSI_ESC);
	
	for (int y = 0; y < board.length; y++) {
	    for (int x = 0; x < board[y].length; x++) {
		System.out.printf("%3s", board[y][x]);
	    }
	    System.out.print("\n");
	}

	return "";
    }

    public static void main(String[] args) {
	KnightsTour kt = new KnightsTour();
	kt.move(kt.KnX, kt.KnY);
	kt.toString();
    }
}
