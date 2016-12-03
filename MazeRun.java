package sjsu.fonseca.cs146.project3;


public class MazeRun {

    public static void main(String[] arg){
        
        int SIZE = 4; //size= 4, 5, 6, 7, 8, or 10
        
        
        

        Maze maze = new Maze(SIZE);
        maze.graphCreator();
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.depthFirstSearch();
        maze.printPath(maze.myVertex[0][0], maze.myVertex[SIZE-1][SIZE-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        
        System.out.print("Time Output in Miliseconds: ");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");

        Maze maze1 = new Maze(SIZE);
        maze1.graphCreator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.breadthFirstSearch();
        maze1.printPath(maze1.myVertex[0][0], maze1.myVertex[SIZE-1][SIZE-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
    }
}
