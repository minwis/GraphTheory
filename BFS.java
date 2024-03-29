import java.util.*;

public class BFS {

    //public static List<node> Graph = new ArrayList<node>();
    private static int size = 9;
    private static int[][] graph = new int[size][size];
    private static boolean ProgramTerminate = false;
    private static boolean[] IsVisited = new boolean[size]; //check if the node whose number is index is visited

    public static void main(String[] args) {
        initialize();
        BFSAlgorithm(0, 6);
    }

    public static void BFSAlgorithm(int CurrentNode, int Target) {
        IsVisited[CurrentNode] = true;
        for ( int i = 0; i < size; i++ ) {
            if (graph[CurrentNode][i] != 0 && i == Target) {
                ProgramTerminate = true;
                System.out.println(Target);
                System.out.println(CurrentNode);
                return;
            }
        }

        for ( int i = 0; i < size; i++ ) {
            if ( !IsVisited[i] && graph[CurrentNode][i] != 0 ) {
                BFSAlgorithm(i, Target);
            }
            if ( ProgramTerminate ) {
                System.out.println(CurrentNode);
                break;
            }
        }
    }


    public static void initialize() {
        graph[0][1] = 1;
        graph[0][3] = 1;
        graph[0][8] = 1;

        graph[1][0] = 1;
        graph[1][7] = 1;

        graph[2][3] = 1;
        graph[2][5] = 1;
        graph[2][7] = 1;

        graph[3][0] = 1;
        graph[3][2] = 1;
        graph[3][4] = 1;

        graph[4][8] = 1;
        graph[4][4] = 1;

        graph[5][2] = 1;
        graph[5][6] = 1;

        graph[6][5] = 1;

        graph[7][1] = 1;
        graph[7][2] = 1;

        graph[8][0] = 1;
        graph[8][4] = 1;
    }
}
