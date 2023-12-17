public class main {
    public static void main(String[] args) throws InterruptedException {
    boolean[][] test = new boolean[5][5];
    for (int i = 0; i < test.length ; i++ ){
        for (int j = 0; j < test[i].length; j++){
            test[i][j] = false;
        }
    }
    printScreen(test);
    drawScreen(test);
    System.out.println("What spaces (1-25) would you like to start alive? Leave blank to continue.");
    for(boolean i = false ; !i ; ){
        String input = System.console().readLine();
        int selection;
        int y;
        int x;
        if (input.equals("")){
            i = true;
            System.out.println("Done");
        } else {
            selection = Integer.parseInt(input);
            y = (selection-1)/5;
            x = (selection - 1) % 5;
            test[x][y] = true;
            drawScreen(test);
        }
    }
    for(int i = 0; i < 5; i++){
        StdDraw.pause(1000);
        test = oneRound(test);
        drawScreen(test);
    }
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
    private static void printScreen(boolean[][] ar){
        String[] line = new String[ar[0].length];
        for (int i = 0; i < line.length ; i++){
            line[i]= "";
        }
        for (int x = 0; x < ar.length ; x++){
            for (int y = 0; y < ar[x].length ; y++){
                if (ar[x][y]){
                    line[y] += " X ";
                } else {
                    line[y] += " O ";
                }
            }
        }
        for (int i = line.length-1 ; i > -1; i--){
            System.out.println(line[i]);
        }
    }

    private static void drawScreen(boolean[][] ar){
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
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledRectangle(0.5+xChange, 0.5+yChange, 0.05, 0.05);
                } else {
                    xChange = (x-2.0)/10.0;
                    yChange = (y-2.0)/10.0;
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.filledRectangle(0.5+xChange, 0.5+yChange, 0.05, 0.05);
                } 
            }
        }
    }

    private static void setBoard(){
        StdDraw.setCanvasSize(750, 750);
        for (int i = 0 ; i < 1000; i += 1){
            if (StdDraw.isMousePressed()){
                System.out.println("Ayyy");
                StdDraw.pause(1000);
            }
        }
    }
}