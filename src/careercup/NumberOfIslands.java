package careercup;

/**
 * Created by sunny on 3/20/16.
 */
public class NumberOfIslands {

    int[][] world =  new int[][]{{1,0,0,0,0,0},
                                 {0,0,1,0,1,0},
                                 {0,0,0,0,1,0},
                                 {0,0,0,0,0,0}
                                };

    void visitIslandParts(int[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= world.length || j >= world[0].length) {
            return;
        }

        if (world[i][j] == 0) {
            return;
        }

        if (world[i][j] == 1 && visited[i][j] == 0) {
            visited[i][j] = 1;
        }

        visitIslandParts(visited, i+1, j);
        visitIslandParts(visited, i, j+1);
        visitIslandParts(visited, i-1, j-1);
        visitIslandParts(visited, i, j-1);
        visitIslandParts(visited, i-1, j);
        visitIslandParts(visited, i, j-1);
        visitIslandParts(visited, i, j-1);
        visitIslandParts(visited, i+1, j-1);
        visitIslandParts(visited, i-1, j+1);

    }


    int findIslands(int[][] visited) {

        int numOfIslands = 0;

        for (int i = 0; i < world.length; i++) {

            for (int j = 0; j< world[0].length; j++) {

                if ( world[i][j] == 1 && visited[i][j] == 0) {
                    numOfIslands++;
                    visitIslandParts(visited, i,j);
                }
            }
        }

        return numOfIslands;
    }



    public static void main(String[] args) {

        NumberOfIslands finder = new NumberOfIslands();

        int[][] visited = new int[finder.world.length][finder.world[0].length];

        System.out.println(finder.findIslands(visited));


    }
}
