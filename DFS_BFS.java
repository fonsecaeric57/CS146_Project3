
import java.util.LinkedList;
import java.util.Random;

public class MazeAssignment {

    int Rooms = 4;
    int Walls = 4;
    String[][] maze = new String[Rooms][Walls];
    int TotalCells = Rooms * Walls;
    int currentWall = 1;
    int visitWalls = 1;
    int neigbors[] = new int[visitWalls];

    public MazeAssignment() {
        visitWalls = getVisitedWalls();

        neigbors = new int[visitWalls];
        neigbors = getNeigbors();
        System.out.println("-------Genrate Maze---------");

        GenrateMaze();
        //DFS
        //Rooms(true, maze);
        // BFS
        Rooms(false, maze);
    }

    public int[] getNeigbors() {
        int[] a = new int[neigbors.length];
        for (int visit = 0; visit < visitWalls; visit++) {
            Random rn = new Random();
            int range = neigbors.length - 0 + 1;
            int randomNum = rn.nextInt(range) + 0;
            a[visit] = randomNum;
        }
        return a;
    }

    public int getVisitedWalls() {
        Random rn = new Random();
        int range = TotalCells - 0 + 1;
        int randomNum = rn.nextInt(range) + 0;
        return randomNum;
    }

    public void GenrateMaze() {
        int RoomsCount = 0;
        System.out.println("Genrate With Numbers");
        for (int rowIndex = 0; rowIndex < maze.length; rowIndex++) {
            for (int colIndex = 0; colIndex < maze[0].length; colIndex++) {

                int wall = getWallsNumber(RoomsCount);
                if (wall != -1) {
                    maze[rowIndex][colIndex] = "" + wall;
                } else {
                    maze[rowIndex][colIndex] = "X";
                }
                RoomsCount++;
                System.out.print(" " + maze[rowIndex][colIndex]);
            }
            System.out.println("");
        }
       
    }

    public int getWallsNumber(int RoomsCount) {
        for (int i = 0; i < neigbors.length; i++) {
            if (RoomsCount == neigbors[i]) {
                return neigbors[i];
            }
        }
        return -1;
    }

    public static void main(String arsg[]) {
        new MazeAssignment();
    }

    public int Rooms(boolean isDFS, String[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isDFS) {
                    dfsFill(grid, i, j);
                    count++;
                } else {
                    if (grid[i][j].equalsIgnoreCase("1") || grid[i][j].equalsIgnoreCase("2") || grid[i][j].equalsIgnoreCase("3")  || grid[i][j].equalsIgnoreCase("4")) {
                        bfsFill(grid, i, j);
                        count++;
                    }
                }

            }
        }
        if (isDFS) {
            System.out.println("Depth-first search(DFS)");
            for (int r = 0; r < grid.length; r++) {
                for (int w = 0; w < grid[r].length; w++) {
                    System.out.print(grid[r][w] + " ");
                }
                System.out.println("");
            }

            System.out.println("-----------------End DFS--------------");
        }
        return count;
    }

    private void dfsFill(String[][] grid, int i, int j) {

        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && !grid[i][j].equalsIgnoreCase("X")) {
            grid[i][j] = "A";

        }

    }

    private void bfsFill(String[][] grid, int x, int y) {
        grid[x][y] = "0";
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int code = x * m + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / m;
            int j = code % m;
            if (i > 0 && grid[i - 1][j].equalsIgnoreCase("1")) //search upward and mark adjacent '1's as '0'.
            {
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = "0";
            }
            if (i < n - 1 && grid[i + 1][j].equalsIgnoreCase("2")) //down
            {
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = "+";
            }
            if (j > 0 && grid[i][j - 1].equalsIgnoreCase("3")) //left
            {
                queue.offer(i * m + j - 1);
                grid[i][j - 1] = "<";
            }
            if (j < m - 1 && grid[i][j + 1].equalsIgnoreCase("4")) //right
            {
                queue.offer(i * m + j + 1);
                grid[i][j + 1] = ">";
            }
        }
        System.out.println("Breadth-first search(BFS)");
        for (int r = 0; r < grid.length; r++) {
            for (int w = 0; w < grid[r].length; w++) {
                System.out.print(grid[r][w] + " ");
            }
            System.out.println("");
        }
    }
}
