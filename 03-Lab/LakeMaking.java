public class LakeMaking {

    private Random randInt = new Random();
    
    private int[][] pasture;
    private int pastureX;
    private int pastureY;
    
    public LakeMaking() {
	LakeMaking(6, 4);
    }

    public LakeMaking(int pastureX, int pastureY) {
	this.pastureX = pastureX;
	this.pastureY = pastureY;

	pasture = new int[pastureY][pastureX];
	for (int r = 0; r < pastureY; r++) {
	    for (int c = 0; c < pastureX; c++) {
		pasture[r][c] = randInt.nextInt(27) + 10;
	    }
	}
    }
    
    public void stomp(int y, int x, int stomps) {
	if (y >= pastureY - 3 || y < 0 ||
	    x >= pastureX - 3 || x < 0) {
	    return;
	}
	if (stomps = 0) {
	    return;
	}
	
	stomp(y, x, stomps - 1);
    }

    public int depth() {
    }

    public int volume() {
    }
    
}
