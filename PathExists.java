
import java.util.Arrays;

public class PathExists {

    public static void main(String args[]){
        int a[][] = new int[3][3];
        a[0][0] = 0;
        a[0][1] = 0;
        a[0][2] = 0;

        a[1][0] = 0;
        a[1][1] = 0;
        a[1][2] = 1;
        a[2][0] = 0;
        a[2][1] = 0;
        a[2][2] = 0;




        System.out.println(findPathExists(a));
    }


    public static boolean findPathExists(int a[][]){
        if(a==null || a.length == 0) return false;
        State [][] memo = new State[a.length][a[0].length];
        for(State[] state : memo) {
            Arrays.fill(state, State.UNVISITED);
        }
        return pathExists(a,0,0,memo);
    }

    public static boolean pathExists(int a[][], int i, int j, State[][] memo){
        if(oob(a,i,j) || a[i][j] == 1){
            return false;
        }
        if( i == a.length-1 && j==a[0].length-1) {
            System.out.println("Returning True i: " + i + " j: " + j + " a[i][j]: " + a[i][j]);
            return true;
        }

        if(memo[i][j] == State.NOT_FOUND || memo[i][j] == State.VISITING){
            return false;
        }
        memo[i][j] = State.VISITING;
        Pair [] pairs = {new Pair(i + 1, j), new Pair(i - 1, j), new Pair(i, j + 1), new Pair(i, j - 1)};

        for(Pair pair : pairs){
          /*     System.out.println("i: " + pair.getFirst() + " j: " + pair.getSecond());
               System.out.println("memo: " + memo[pair.getFirst()][pair.getSecond()]);
               System.out.println("a: " + a[pair.getFirst()][pair.getSecond()]);

           */
                if(pathExists(a,pair.getFirst(),pair.getSecond(),memo)){
                    return true;
                }
        }

        memo[i][j] = State.NOT_FOUND;
        return false;

    }

    public static boolean oob(int a[][], int i, int j){
        if(i <0 || j < 0 || i > a.length -1 || j > a[0].length -1 ){
            return true;
        }
        return false;
    }

    enum State {
        VISITING, NOT_FOUND, UNVISITED
    }

    static class Pair{

        public Pair(int i, int j){
            first = i;
            second = j;
        }
        int first;
        int second;

        public int getSecond() {
            return second;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }
}
