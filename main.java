public class main {
    public static void main(String[] args) {
    boolean[][] test = new boolean[5][5];
    for (int i = 0; i < test.length ; i++ ){
        for (int j = 0; j < test[i].length; j++){
            test[i][j] = (Math.random() <= 0.25);
        }
    }
    printScreen(test);
    drawScreen(test);
    }


    private static boolean[][] oneRound(boolean[][] ar){
        boolean[][] next = new boolean[ar.length][ar[0].length];
        for (int x = 0; x < ar.length ; x++){
            for (int y = 0; y < ar[0].length ; y++){
                if(countAlive(ar, x, y) < 2){
                    next[x][y] = false;
                }else if(countAlive(ar, x, y) > 3) {
                    next[x][y] = false;
                } else if(countAlive(ar, x, y) == 3){
                    next[x][y] = true;
                } else {
                    next[x][y] = ar[x][y];
                }
            }
        }

        return next;
    }



    private static int countAlive(boolean[][] ar, int x, int y){
        int retval = 0;
        int check1 = 0;
        int check2 = 0;
        int check3 = 0;
        int check4 = 0;
        if (x+1 == ar.length) check1 -= 1;
        if (x-1 == -1) check2 += 1;
        if (y+1 == ar[x].length) check3 -= 1;
        if (y-1 == -1) check4 += 1;
        for (int i = -1 + check2; i < 2 + check1 ; i++){
            for (int j = -1 + check4; j < 2 + check3 ; j++ ){
                if (!(i == 0 && j == 0)){
                    if (ar[x+i][y+j]) retval++;
                }
            }
        }
        return retval;
    }
    public static void printScreen(boolean[][] ar){
        String line = "";
        for (int y = ar.length; y > 0 ;  y--) {
            for (int x = 0 ; x < ar[y-1].length; x++){
                if (ar[x][y-1]) {
                    line += "X ";
                } else {
                    line += "O ";
                }
            }
            System.err.println(line);
            line = "";
        }
    }

    public static void drawScreen(boolean[][] ar){
        StdDraw.setCanvasSize(750, 750);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledRectangle(0.5, 0.5, 0.25, 0.25);
        double xChange;
        double yChange;
        for (int x = 0 ; x < ar.length ; x++){
            for (int y = 0 ; y < ar[x].length ; y++){
                if(ar[x][y]){
                    xChange = (x-2.0)/10.0;
                    yChange = (y-2.0)/10.0;
                    System.out.println(x);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledRectangle(0.5+xChange, 0.5+yChange, 0.05, 0.05);
                } else {
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.filledRectangle(0.5+((x-2)/5), (0.5+((y-2)/5)), 0.05, 0.05);
                }
            }
        }
    }
}