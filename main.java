public class main {
    public static void main(String[] args) {
    boolean[][] test = {{true,false,false,true},{false,true,true,true},{true,false,false,false},{false,false,false}};
    System.out.println(countAlive(test, 1, 1));  
    }   
    private static int countAlive(boolean[][] ar, int x, int y){
        int retval = 0;
        for (int i = -1; i < 2 ; i++){
            for (int j = -1; j < 2 ; j++ ){
                if (!(i == 0 && j == 0)){
                    if (ar[x+i][y+j]) retval++;
                }
            }
        }
        return retval;
    }
    public static void printScreen(boolean[][] ar){
        for (int i = ar.length; i > 0; ) {}
    }
}