package sjsu.fonseca.cs146.project3;

import java.util.*;
class Graph
{
   private static final int WHITE = 1;
   private static final int GRAY = 2;
   private static final int BLACK = 3;
   private Random myRandGen;
   private final int SIZE; //size of the graph, SIZE x SIZE
   public int dfsVisit;
   public int dfsTime; //dfs timer
   public int bfsTime;
   private Queue<Vertex> cellQueue;
   public Vertex[][] boxHelp;
   private Node[] linkedList; //adjacency list
   public String printedGraph;

   /**
    * Constructor for graph
    * @param size the size of the matrix, size x size parameters
    */
   public Graph(int size) // constructor
   {
      SIZE = size;
      cellQueue = new LinkedList<Vertex>();
      boxHelp = new Vertex[SIZE][SIZE];

      linkedList = new Node[SIZE*SIZE];
      for (int i = 0; i < SIZE*SIZE; i++)
      {
         linkedList[i] = null;
      }
      myRandGen = new Random(); 
   } 


   /**
    * Inner class vertex to help implement the graph data structure
    * From page 620 of data structures and algorithms in java pdf
    */
   public class Vertex
   {
      int visitedOrder;
      public Vertex parent;
      ArrayList<Vertex> adjacent;

      public boolean wasVisited;

      public int color;
      public int label;
      public int distance;
      public int discoveryTime;
      public int finishingTime;
      public int horizontalPos;
      public int verticalPos;

      boolean isInPath;
      public boolean isLeftColumn;
      public boolean isRightColumn;
      public boolean isTopRow;
      public boolean isBottomRow;

      public boolean leftWallPresent;
      public boolean rightWallPresent;
      public boolean topWallPresent;
      public boolean bottomWallPresent;

      /**
       * Constructor for the vertex inner class
       * @param horizontal the horizontal position
       * @param vertical the vertical position
       * @param lab the label
       */
      public Vertex(int horizontal, int vertical, int lab)
      {
         label = lab;
         wasVisited = false;
         horizontalPos = horizontal;
         verticalPos = vertical;
         isInPath = false;
         color = WHITE;
         adjacent = new ArrayList<>();
         visitedOrder = 0;       

         isLeftColumn = false;
         isRightColumn = false;
         isTopRow = false;
         isBottomRow = false;

         leftWallPresent = true;
         rightWallPresent = true;
         topWallPresent = true;
         bottomWallPresent = true;

         if (horizontal == 0)
         {
            isLeftColumn = true;
         }

         if (horizontal == SIZE -1)
         {
            isRightColumn = true;
         }
         if (vertical == 0)
         {
            isTopRow = true;
         }
         if (vertical == SIZE -1)
         {
            isBottomRow = true;
         }
      }
   }


   /**
    * This inner class implements the node class to implement 
    * the graph data structure and helps with iterating linked lists
    */
   class Node
   {
      Node next = null;   
      Vertex vertex;
   }

   /**
    * This method performs a Breadth First Search on a graph, using the pseudo
    * code from Introduction to Algorithms, Third Edition by Cormen et all.
    */
   public void bfs()
   {
      int bfsVisit = 0;
      Vertex starter = boxHelp[0][0]; //set starting point to the left top corner
      starter.color = GRAY; //it gets discovered
      starter.distance = 0; //distance starts at 0
      starter.parent = null; //it has no parent since it is the first one
      cellQueue.add(starter); //add the first vertex to the queue

      while (!cellQueue.isEmpty()) //while there are still things in the queue
      {
         Vertex frontQ = cellQueue.remove();
         Node node = linkedList[frontQ.label - 1];

         
         while(node != null) //scroll through each vertex's edges
         {
            if(node.vertex.color == WHITE) //if it was undiscovered
            {
               node.vertex.color = GRAY; //turn gray
               bfsVisit++; //update the order it was visited in
               node.vertex.visitedOrder = bfsVisit; 
               node.vertex.distance = frontQ.distance + 1;
               node.vertex.parent = frontQ; //update the parent of the vertex
               cellQueue.add(node.vertex); //add the node to the queue to discover adjacent later
            }
            node = node.next;
         }
      }
      bfsTime = bfsVisit;
   }

   /**
    * This method performs a Depth First Search on a graph, using the pseudo
    * code from Introduction to Algorithms, Third Edition by Cormen et all.
    */
   public void dfs()
   {
      for(int i = 0; i < SIZE; i++)
      {
         for(int j = 0; j < SIZE; j++) //for each vertex u 
         {
            Vertex u = boxHelp[i][j];
            u.color = WHITE;
            u.parent = null;
         }
      }
      dfsTime = 0;               
      for(int i = 0; i < SIZE; i++)
      {
         for(int j = 0; j < SIZE; j++) //for each vertex u 
         {
            Vertex u = boxHelp[i][j];
            if(u.color == WHITE)
               dfsVisit(u);
         }
      }
   }

   /**
    * This helper method is used to perform a depth first search on a graph,
    * using the pseudo code from Introduction to Algorithms, Third Edition
    * by Cormen et all.
    * @param vertex a vertex
    */
   private void dfsVisit(Vertex vertex)
   {

      dfsTime++;
      vertex.visitedOrder = dfsVisit;
      dfsVisit++;
      vertex.color = GRAY;
      vertex.discoveryTime = dfsTime;

      Node node = linkedList[vertex.label - 1];
      while(node != null) //for each vertex
      {
         if(node.vertex.color == WHITE)
         {
            node.vertex.parent = vertex;
            dfsVisit(node.vertex); //visit recursively
         }
         node = node.next; //go to the next node
      }

      dfsTime++;
      vertex.finishingTime = dfsTime;
      vertex.color = BLACK; //it is finished
   }


   /**
    * This helper method displays an empty maze
    * @param i the ith index in boxHelp graph
    * @param j the jth index in boxHelp graph
    */
   private void displayEmpty(int i, int j)
   {
      if(boxHelp[i][j].leftWallPresent)
      {
         String t = boxHelp[i][j].isInPath ? "|#" : "| ";
         System.out.print(t);
         printedGraph += t;
      }
      else
      {
         String t = boxHelp[i][j].isInPath ? " #" : "  ";
         System.out.print(t);
         printedGraph += t;
      }
   }

   /**
    * This helper method displays the path of a breadth first search on a maze
    * @param i the ith index in boxHelp graph
    * @param j the jth index in boxHelp graph
    */
   private void displayBfs(int i, int j)
   {
      if(boxHelp[i][j].leftWallPresent)
      {
         String t = (boxHelp[i][j].visitedOrder <= boxHelp[SIZE-1][SIZE-1].visitedOrder) 
               ?  "|" + String.format("%1s", boxHelp[i][j].visitedOrder%10) : "| ";
               System.out.print(t);
               printedGraph += t;
      }
      else
      {
         String t = (boxHelp[i][j].visitedOrder <= boxHelp[SIZE-1][SIZE-1].visitedOrder) 
               ?  "" + String.format("%2s", boxHelp[i][j].visitedOrder%10) : "  ";
               System.out.print(t);
               printedGraph += t;
      }
   }

   /**
    * This helper method displays the path of a depth first search on a maze
    * @param i the ith index in boxHelp graph
    * @param j the jth index in boxHelp graph
    */
   private void displayDfs(int i, int j)
   {
      if(boxHelp[i][j].leftWallPresent)
      {
         String t = boxHelp[i][j].discoveryTime <= boxHelp[SIZE-1][SIZE-1].discoveryTime ? 
               "|" + String.format("%1s", boxHelp[i][j].visitedOrder%10) : "| ";
               System.out.print(t);
               printedGraph += t;
      }
      else
      {
         String t = boxHelp[i][j].discoveryTime <= boxHelp[SIZE-1][SIZE-1].discoveryTime ?
               "" +  String.format("%2s", boxHelp[i][j].visitedOrder%10) : "  ";
               System.out.print(t);
               printedGraph += t;
      }
   }

   /**
    * This method displays a maze
    * @param search the type of search to be displayed, either and empty string,
    * BFS for breadth first search, or DFS for depth first search.
    */
   public void displayMaze(String search)
   {
      System.out.println("");
      for(int i = 0; i < SIZE; i++)
      {
         for(int j = 0; j < SIZE; j++)
         {
            if(boxHelp[i][j].topWallPresent)
            {
               String t = (boxHelp[i][j] == boxHelp[0][0]) ? "+ " : "+-";
               System.out.print(t);
               printedGraph += t;
            }
            else
            {
               System.out.print("+ ");
            }
         }
         System.out.println("+ ");
         for(int j = 0; j < SIZE; j++)
         {
            switch(search)
            {
            default:
            {
               displayEmpty(i, j);
               break;
            }
            case "BFS":
            {
               displayBfs(i, j);
               break;
            }
            case "DFS":
            {
               displayDfs(i, j);
               break;
            }
            }
         }
         System.out.println("|");
      }

      for(int j = 0; j < SIZE; j++)
      {
         String t = j == SIZE-1 ? "+ " : "+-";
         System.out.print(t);
         printedGraph += t;
      }
      System.out.println("+ ");
      
   }

   /**
    * This getter method gets the neighbors of a vertex
    * @param v the vertex to be searched
    * @return the number of neighbors
    */
   public int getNeighbors(Vertex v)
   {
      for(int x = 0; x < v.adjacent.size(); x++)
      {
         if(v.adjacent.get(x).wasVisited)
         {
            v.adjacent.remove(v.adjacent.get(x));
         }
      }
      int adjacent = 0;
      for(int x = 0; x < v.adjacent.size(); x++)
      {
         if(!v.adjacent.get(x).wasVisited)
         {
            adjacent++;
         }
      }
      return adjacent;
   }


   /**
    * This method prints a path of a maze, using pseudocode from Introduction
    * to Algorithms, Third Edition by Cormen et all, Page 601.
    * @param v1 the first vertex
    * @param v2 the second vertex
    */
   public void printPath(Vertex v1, Vertex v2)
   {
      if (v1.label == v2.label) 
      {
         //print s
      }
      else if (v2.parent == null)
      {
         //no path from v1 to v2 exist
         System.out.println("no path from vertex A to vertex B exists"); 
      }
      else
      {
         printPath(v1, v2.parent);
      }
      v2.isInPath = true;
   }

   /**
    * This method fixes the adjacent vertices of a graph
    * @param vert the vertex to be fixed
    */
   public void adjacentFix(Vertex vert)
   {
      if (vert.isLeftColumn == false) //set left Adjacent if it exist
      {
         Vertex leftAdjacent = boxHelp[vert.horizontalPos - 1][vert.verticalPos];
         vert.adjacent.add(leftAdjacent);
      }

      if (vert.isRightColumn == false) //set right Adjacent if it exist
      {
         Vertex rightAdjacent = boxHelp[vert.horizontalPos + 1][vert.verticalPos];
         vert.adjacent.add(rightAdjacent);
      }

      if (vert.isTopRow == false) //set top Adjacent if it exist
      {
         Vertex topAdjacent = boxHelp[vert.horizontalPos][vert.verticalPos -1];
         vert.adjacent.add(topAdjacent);
      }

      if (vert.isBottomRow == false) //set bottom Adjacent if it exist
      {
         Vertex bottomAdjacent = boxHelp[vert.horizontalPos][vert.verticalPos +1];
         vert.adjacent.add(bottomAdjacent);
      }
   }

   /**
    * This helper method deletes a wall between to cells of a maze
    * @param bool the wall to knock down
    * @return
    */
   private boolean deleteWall(boolean bool)
   {
      if (bool)
      {
         return false;
      }
      return true;
   }

   /**
    * This helper method removes a wall between two vertices
    * @param current the current vertex
    * @param next the neighboring vertex
    */
   private void removeWall(Vertex current, Vertex next)
   {
      if(current.label + SIZE == next.label)
      {
         next.topWallPresent = deleteWall(next.topWallPresent);
         current.bottomWallPresent = deleteWall(current.bottomWallPresent);
         current.adjacent.remove(next);
         next.adjacent.remove(current);
      }
      else if(current.label + 1 ==next.label)
      {
         next.leftWallPresent =  deleteWall(next.leftWallPresent);
         current.rightWallPresent = deleteWall(current.rightWallPresent);
         current.adjacent.remove(next);
         next.adjacent.remove(current);
      }
      else if(current.label -1 == next.label)
      {
         next.rightWallPresent = deleteWall(next.rightWallPresent);
         current.leftWallPresent = deleteWall(current.leftWallPresent);
         current.adjacent.remove(next);
         next.adjacent.remove(current);
      }
      else if(current.label - SIZE == next.label)
      {
         next.bottomWallPresent = deleteWall(next.bottomWallPresent);
         current.topWallPresent = deleteWall(current.topWallPresent);
         current.adjacent.remove(next);
         next.adjacent.remove(current);
      }
   }

   /**
    * This method generates a maze.
    */
   public void graphGenerator()
   {
      int label = 1;
      for (int i = 0; i < SIZE; i++)
      {
         for (int j = 0; j < SIZE; j++)
         {
            Vertex vert = new Vertex(i, j, label);
            boxHelp[i][j] = vert;
            label++;
         }
      }

      for (int i = 0; i < SIZE; i++)
      {
         for (int j = 0; j < SIZE; j++)
         {
            Vertex current = boxHelp[i][j];
            adjacentFix(current);
         }
      }
      mazeGenerator();
   }

   /**
    * helper method to check if it is visited
    * @param visit a boolean
    * @return true if visit is false, other wise false;
    */
   public boolean setVisit (boolean visit)
   {
      if (visit == false)
      {
         return true;
      }
      return false;
   }

   /**
    * helper method to iterate all the nodes til it is the last node
    * @param n a node
    */
   private Node goToLast(Node n)
   {
      while(n.next != null)
      {
         n = n.next;
      }
      return n;
   }
   
   /**
    * helper method to check if node is the last in a linkedlist
    * @param n a node
    * @return true if it is the last node in linkedlist otherwise false
    */
   private boolean isLast(Node n)
   {
      return (n != null && n.next == null);
   }
   
   /**
    * This helper method aids the graphGenerator method in creating a maze
    * to be searched. Code follows the structure of the sample maze generation
    *  algorithm provided in project3.pdf
    */
   private void mazeGenerator()
   {
      Stack<Vertex> cellStack = new Stack<Vertex>(); //create a cellStack LIFO
      Vertex currentCell = boxHelp[0][0]; //choose the starting cell and call it current cell
      currentCell.wasVisited = setVisit(currentCell.wasVisited);
      int visitedCells = 1; //set visitedcells to 1

      int totalCells = SIZE*SIZE;
      while(visitedCells < totalCells)
      {
         if(getNeighbors(currentCell) >= 1) //find neighbors with walls intact(unvisited neighbors)
         {
            int random = myRandGen.nextInt(getNeighbors(currentCell)); //if one or more found choose at random
            Vertex randomNeighbor = currentCell.adjacent.get(random);
            removeWall(randomNeighbor, currentCell); //knock down wall between it and currentCell

            Node neighborNode = new Node();
            neighborNode.vertex = randomNeighbor;
            Node currentNode = linkedList[currentCell.label-1];

            if (!isNull(currentNode)) 
            {
               currentNode = goToLast(currentNode);
               if (isLast(currentNode)) { currentNode.next = neighborNode; }
            }

            else if (isNull(currentNode))
            {
               currentNode = neighborNode;
               generateHelper(currentCell, currentNode);
            }

            Node currentCellNode = new Node();
            currentCellNode.vertex = currentCell;
            currentNode = linkedList[randomNeighbor.label-1];
            if (!isNull(currentNode)) 
            {
               currentNode = goToLast(currentNode);
               if (isLast(currentNode)) { currentNode.next = currentCellNode; }
            }
            else if (isNull(currentNode))
            {
               currentNode = currentCellNode;
               generateHelper(randomNeighbor, currentCellNode);
            }

            visitedCells = visitedCells +1;
            cellStack.push(currentCell);
            currentCell = randomNeighbor;
            currentCell.wasVisited = true;
         }
         else currentCell = cellStack.pop();
      }     
   }
   
   /**
    * Helper method to set previous to current node
    * @param a A vertex
    * @param b a Node
    */
   private void generateHelper(Vertex a, Node b)
   {
      linkedList[a.label - 1] = b;
   }
   
   /**
    * Helper method to check if a node is null
    * @param n a Node
    * @return a boolean
    */
   private boolean isNull (Node n)
   {
      return n == null;
   }
}
