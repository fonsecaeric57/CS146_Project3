package sjsu.fonseca.cs146.project3;


import org.junit.Test;

public class MazeTester {

	@Test
	public void MazeSize4() {
		Graph maze = new Graph(4);
        maze.graphGenerator();
        System.out.println("Maze of size " + 4);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.dfs();
        maze.printPath(maze.boxHelp[0][0], maze.boxHelp[4-1][4-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Graph maze1 = new Graph(4);
        maze1.graphGenerator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.bfs();
        maze1.printPath(maze1.boxHelp[0][0], maze1.boxHelp[4-1][4-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
		
	}
	@Test
	public void MazeSize5() {
		Graph maze = new Graph(5);
        maze.graphGenerator();
        System.out.println("Maze of size " + 5);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.dfs();
        maze.printPath(maze.boxHelp[0][0], maze.boxHelp[5-1][5-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Graph maze1 = new Graph(5);
        maze1.graphGenerator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.bfs();
        maze1.printPath(maze1.boxHelp[0][0], maze1.boxHelp[5-1][5-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
	}
	@Test
	public void MazeSize6() {
		Graph maze = new Graph(6);
        maze.graphGenerator();
        System.out.println("Maze of size " + 6);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.dfs();
        maze.printPath(maze.boxHelp[0][0], maze.boxHelp[6-1][6-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Graph maze1 = new Graph(6);
        maze1.graphGenerator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.bfs();
        maze1.printPath(maze1.boxHelp[0][0], maze1.boxHelp[6-1][6-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
	}
	@Test
	public void MazeSize7() {
		Graph maze = new Graph(7);
        maze.graphGenerator();
        System.out.println("Maze of size " + 7);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.dfs();
        maze.printPath(maze.boxHelp[0][0], maze.boxHelp[7-1][7-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Graph maze1 = new Graph(7);
        maze1.graphGenerator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.bfs();
        maze1.printPath(maze1.boxHelp[0][0], maze1.boxHelp[7-1][7-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
	}
	@Test
	public void MazeSize8() {
		Graph maze = new Graph(8);
        maze.graphGenerator();
        System.out.println("Maze of size " + 8);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.dfs();
        maze.printPath(maze.boxHelp[0][0], maze.boxHelp[8-1][8-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Graph maze1 = new Graph(8);
        maze1.graphGenerator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.bfs();
        maze1.printPath(maze1.boxHelp[0][0], maze1.boxHelp[8-1][8-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
	}
	@Test
	public void MazeSize10() {
		Graph maze = new Graph(10);
        maze.graphGenerator();
        System.out.println("Maze of size " + 10);
        System.out.println("Maze for DFS");
        maze.displayMaze("");
        
        long start = System.currentTimeMillis();
        maze.dfs();
        maze.printPath(maze.boxHelp[0][0], maze.boxHelp[10-1][10-1]);
        System.out.println("Single Path :");
        maze.displayMaze("");
        System.out.println(System.currentTimeMillis() - start); //calculate run time for DFS
        
        System.out.println("\nDFS: ");
        maze.displayMaze("DFS");
        
        Graph maze1 = new Graph(10);
        maze1.graphGenerator();
        System.out.println("\n\nMaze for BFS");
        maze1.displayMaze("");
        
        long start2 = System.currentTimeMillis();
        maze1.bfs();
        maze1.printPath(maze1.boxHelp[0][0], maze1.boxHelp[10-1][10-1]);
        System.out.println("Single Path: ");
        maze1.displayMaze("");
        System.out.println(System.currentTimeMillis() - start2); //calculate run time for BFS
        
        System.out.println("BFS: ");
        maze1.displayMaze("BFS");
	}
}
