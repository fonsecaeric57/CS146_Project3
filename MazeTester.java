

import org.junit.Test;

public class MazeTester {

	@Test
	public void MazeSize4() {
		Maze maze = new Maze(4);
		maze.graphCreator();
        System.out.println("Maze of size " + 4);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.depthFirstSearch();
        maze.printPath(maze.myVertex[0][0], maze.myVertex[4-1][4-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Maze maze1 = new Maze(4);
		maze1.graphCreator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.breadthFirstSearch();
        maze1.printPath(maze1.myVertex[0][0], maze1.myVertex[4-1][4-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
		
	}
	@Test
	public void MazeSize5() {
		Maze maze = new Maze(5);
        maze.graphCreator();
        System.out.println("Maze of size " + 5);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.depthFirstSearch();
        maze.printPath(maze.myVertex[0][0], maze.myVertex[5-1][5-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Maze maze1 = new Maze(5);
        maze1.graphCreator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.breadthFirstSearch();
        maze1.printPath(maze1.myVertex[0][0], maze1.myVertex[5-1][5-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
	}
	@Test
	public void MazeSize6() {
		Maze maze = new Maze(6);
        maze.graphCreator();
        System.out.println("Maze of size " + 6);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.depthFirstSearch();
        maze.printPath(maze.myVertex[0][0], maze.myVertex[6-1][6-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Maze maze1 = new Maze(6);
        maze1.graphCreator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.breadthFirstSearch();
        maze1.printPath(maze1.myVertex[0][0], maze1.myVertex[6-1][6-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
	}
	@Test
	public void MazeSize7() {
		Maze maze = new Maze(7);
        maze.graphCreator();
        System.out.println("Maze of size " + 7);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.depthFirstSearch();
        maze.printPath(maze.myVertex[0][0], maze.myVertex[7-1][7-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Maze maze1 = new Maze(7);
        maze1.graphCreator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.breadthFirstSearch();
        maze1.printPath(maze1.myVertex[0][0], maze1.myVertex[7-1][7-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
	}
	@Test
	public void MazeSize8() {
		Maze maze = new Maze(8);
        maze.graphCreator();
        System.out.println("Maze of size " + 8);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.depthFirstSearch();
        maze.printPath(maze.myVertex[0][0], maze.myVertex[8-1][8-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Maze maze1 = new Maze(8);
        maze1.graphCreator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.breadthFirstSearch();
        maze1.printPath(maze1.myVertex[0][0], maze1.myVertex[8-1][8-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
	}
	@Test
	public void MazeSize10() {
		Maze maze = new Maze(10);
        maze.graphCreator();
        System.out.println("Maze of size " + 10);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.depthFirstSearch();
        maze.printPath(maze.myVertex[0][0], maze.myVertex[10-1][10-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Maze maze1 = new Maze(10);
        maze1.graphCreator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.breadthFirstSearch();
        maze1.printPath(maze1.myVertex[0][0], maze1.myVertex[10-1][10-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
	}
}
