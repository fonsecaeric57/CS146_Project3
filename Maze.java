package sjsu.fonseca.cs146.project3;

import java.util.*;
public class Maze
{
	
   
   static final int WHITE = 1; //White = undiscovered 
   static final int GRAY = 2;
   static final int BLACK = 3; //Black = discovered 
   
   private Random myRandom;
   private final int SIZE; 
   public int traversalDFS;
   public int timerDFS; //Timer for Depth First Search 
   public int timerBFS;
   private Queue<Vertex> myQueue;
   public Vertex[][] myVertex;
   private Node[] adjList; //Adjacency List LinkedList implementation
   public String printedGraph;

   /**
    * 
    * Constructor 
    * @param size the size of the matrix, takes a n x n matrix
    */
   public Maze(int size) 
   {
      SIZE = size;
      myQueue = new LinkedList<Vertex>();
      myVertex = new Vertex[SIZE][SIZE];

      adjList = new Node[SIZE*SIZE];
      for (int i = 0; i < SIZE*SIZE; i++)
      {
         adjList[i] = null;
      }
      myRandom = new Random(); 
   } 


   /**
    * Vertex class 
    * Helper class to implement graph
    * From Chapter 13 of data structures and algorithms in java 
    */
   public class Vertex
   {
      int visited;
      public Vertex parent;
      ArrayList<Vertex> adjacent;

      public boolean alreadyVisited;

      public int color;
      public int label;
      public int dist; //distance
      public int timeOfDiscovery;
      public int timeFinished;
      public int positionHorizontal;
      public int positionVertical;

      boolean isInPath;
      public boolean leftCol;
      public boolean rightCol;
      public boolean topRow;
      public boolean bottomRow;

      public boolean leftWallOccur;
      public boolean rightWallOccur;
      public boolean topWallOccur;
      public boolean bottomWallOccur;

      /**
       * Constructor for the vertexChange class
       * @param horizontal the horizontal position
       * @param vertexChangeical the vertexChangeical position
       * @param myLabel the label
       */
      public Vertex(int horizontal, int vertexChangeical, int myLabel)
      {
         label = myLabel;
         alreadyVisited = false;
         positionHorizontal = horizontal;
         positionVertical = vertexChangeical;
         isInPath = false;
         color = WHITE;
         adjacent = new ArrayList<>();
         visited = 0;       

         leftCol = false;
         rightCol = false;
         topRow = false;
         bottomRow = false;

         leftWallOccur = true;
         rightWallOccur = true;
         topWallOccur = true;
         bottomWallOccur = true;

         if (horizontal == 0)
         {
            leftCol = true;
         }

         if (horizontal == SIZE -1)
         {
            rightCol = true;
         }
         if (vertexChangeical == 0)
         {
            topRow = true;
         }
         if (vertexChangeical == SIZE -1)
         {
            bottomRow = true;
         }
      }
   }


   /**
    * Node inner class 
    * Helps to traverse the linked list 
    */
   class Node
   {
      Node next = null;   
      Vertex vertexChange;
   }

   /**
    * This method performs a Breadth First Search on a graph, 
    *  referencing from Introduction to Algorithms CLRS
    */
   public void breadthFirstSearch()
   {
      int breadthFirstSearchVisit = 0;
      Vertex starter = myVertex[0][0]; //Starts at top left 
      starter.color = GRAY; //Gray for discovery 
      starter.dist = 0; //distance initialize to zero
      starter.parent = null; //Parent is set to null
      myQueue.add(starter); //Add the starting vertexChange to the Queue 

      while (!myQueue.isEmpty()) //while queue is not empty 
      {
         Vertex frontQueue = myQueue.remove();
         Node node = adjList[frontQueue.label - 1];

         
         while(node != null) //traverse each vertexChange 
         {
            if(node.vertexChange.color == WHITE) 
            {
               node.vertexChange.color = GRAY; //Change the color to gray 
               breadthFirstSearchVisit++; //Change the traversal order
               node.vertexChange.visited = breadthFirstSearchVisit; 
               node.vertexChange.dist = frontQueue.dist + 1;
               node.vertexChange.parent = frontQueue; //Change the parent 
               myQueue.add(node.vertexChange); //Insert the node to the queue 
            }
            node = node.next;
         }
      }
      timerBFS = breadthFirstSearchVisit;
   }

   /**
    * Performs a Depth First Search, referenced
    *  from Introduction to Algorithms CLRS 
    */
   public void depthFirstSearch()
   {
      for(int i = 0; i < SIZE; i++)
      {
         for(int j = 0; j < SIZE; j++) 
         {
            Vertex vertexChangeTemp = myVertex[i][j];
            vertexChangeTemp.color = WHITE;
            vertexChangeTemp.parent = null;
         }
      }
      timerDFS = 0;               
      for(int i = 0; i < SIZE; i++)
      {
         for(int j = 0; j < SIZE; j++) 
         {
            Vertex vertexChangeTemp = myVertex[i][j];
            if(vertexChangeTemp.color == WHITE)
            	traversalDFS(vertexChangeTemp);
         }
      }
   }

   /**
    *Method to help with DFS Traversal
    * referenced from Introduction to Algorithms CLRS 
    * @param vertexChange a vertexChange from the graph
    */
   private void traversalDFS(Vertex vertexChange)
   {

	  timerDFS++;
      vertexChange.visited = traversalDFS;
      traversalDFS++;
      vertexChange.color = GRAY;
      vertexChange.timeOfDiscovery = timerDFS;

      Node node = adjList[vertexChange.label - 1];
      while(node != null) 
      {
         if(node.vertexChange.color == WHITE)
         {
            node.vertexChange.parent = vertexChange;
            traversalDFS(node.vertexChange); //Recursively traverse through 
         }
         node = node.next; 
      }

      timerDFS++;
      vertexChange.timeFinished = timerDFS;
      vertexChange.color = BLACK; //Discovered 
   }


   /**
    * Method for displaying a blank maze 
    * @param i index i of myVertex
    * @param j index j of myVertex
    */
   private void displayEmpty(int i, int j)
   {
      if(myVertex[i][j].leftWallOccur)
      {
         String temp = myVertex[i][j].isInPath ? "|#" : "| ";
         System.out.print(temp);
         printedGraph = printedGraph + temp;
      }
      else
      {
         String temp = myVertex[i][j].isInPath ? " #" : "  ";
         System.out.print(temp);
         printedGraph = printedGraph + temp;
      }
   }

   /**
    * This helper method displays the path of a breadth first search on a maze
    * @param i the index in myVertex graph
    * @param j the index in myVertex graph
    */
   private void displayBreadthFirstSearch(int i, int j)
   {
      if(myVertex[i][j].leftWallOccur)
      {
         String temp = (myVertex[i][j].visited <= myVertex[SIZE-1][SIZE-1].visited) 
               ?  "|" + String.format("%1s", myVertex[i][j].visited%10) : "| ";
               System.out.print(temp);
               printedGraph = printedGraph + temp;
      }
      else
      {
         String temp = (myVertex[i][j].visited <= myVertex[SIZE-1][SIZE-1].visited) 
               ?  "" + String.format("%2s", myVertex[i][j].visited%10) : "  ";
               System.out.print(temp);
               printedGraph = printedGraph + temp;
      }
   }

   /**
    * This helper method displays the path of a depth first search on a maze
    * @param a the index in myVertex graph
    * @param b the index in myVertex graph
    */
   private void displayDepthFirstSearch(int a, int b)
   {
      if(myVertex[a][b].leftWallOccur)
      {
         String temp = myVertex[a][b].timeOfDiscovery <= myVertex[SIZE-1][SIZE-1].timeOfDiscovery ? 
               "|" + String.format("%1s", myVertex[a][b].visited%10) : "| ";
               System.out.print(temp);
               printedGraph = printedGraph + temp;
      }
      else
      {
         String temp = myVertex[a][b].timeOfDiscovery <= myVertex[SIZE-1][SIZE-1].timeOfDiscovery ?
               "" +  String.format("%2s", myVertex[a][b].visited%10) : "  ";
               System.out.print(temp);
               printedGraph = printedGraph + temp;
      }
   }

   /**
    * Method to display maze
    * @param temp used to search a string 
    */
   public void displayMaze(String temp)
   {
      System.out.println("");
      for(int i = 0; i < SIZE; i++)
      {
         for(int j = 0; j < SIZE; j++)
         {
            if(myVertex[i][j].topWallOccur)
            {
               String temp1 = (myVertex[i][j] == myVertex[0][0]) ? "+ " : "+-";
               System.out.print(temp1);
               printedGraph = printedGraph + temp1;
            }
            else
            {
               System.out.print("+ ");
            }
         }
         System.out.println("+ ");
         for(int j = 0; j < SIZE; j++)
         {
            switch(temp)
            {
            default:
            {
               displayEmpty(i, j);
               break;
            }
            case "BFS":
            {
               displayBreadthFirstSearch(i, j);
               break;
            }
            case "DFS":
            {
               displayDepthFirstSearch(i, j);
               break;
            }
            }
         }
         System.out.println("|");
      }

      for(int j = 0; j < SIZE; j++)
      {
         String temp1 = j == SIZE-1 ? "+ " : "+-";
         System.out.print(temp1);
         printedGraph = printedGraph + temp1;
      }
      System.out.println("+ ");
      
   }

   /**
    * Method that gets adjacent neighbors of Vertex v
    * @param v the input vertexChange 
    * @return how many neighbors
    */
   public int getAdjacent(Vertex v)
   {
      for(int x = 0; x < v.adjacent.size(); x++)
      {
         if(v.adjacent.get(x).alreadyVisited)
         {
            v.adjacent.remove(v.adjacent.get(x));
         }
      }
      int adjacent = 0;
      for(int x = 0; x < v.adjacent.size(); x++)
      {
         if(!v.adjacent.get(x).alreadyVisited)
         {
            adjacent++;
         }
      }
      return adjacent;
   }


   /**
    * Method that prints a path of a maze
    * referenced from CLRS Chapter 22
    * @param a vertexChange one
    * @param b vertexChange two
    */
   public void printPath(Vertex a, Vertex b)
   {
      if (a.label == b.label) 
      {
         
      }
      else if (b.parent == null)
      {
         
         System.out.println("Nonexistent path from A to B"); 
      }
      else
      {
         printPath(a, b.parent);
      }
      b.isInPath = true;
   }

   /**
    * Repairs the neighboring vertices
    * @param vertexChange the vertex to be changed
    */
   public void repairAdj(Vertex vertexChange)
   {
      if (vertexChange.leftCol == false) 
      {
         Vertex leftAdjacent = myVertex[vertexChange.positionHorizontal - 1][vertexChange.positionVertical];
         vertexChange.adjacent.add(leftAdjacent);
      }

      if (vertexChange.rightCol == false) 
      {
         Vertex rightAdjacent = myVertex[vertexChange.positionHorizontal + 1][vertexChange.positionVertical];
         vertexChange.adjacent.add(rightAdjacent);
      }

      if (vertexChange.topRow == false) 
      {
         Vertex topAdjacent = myVertex[vertexChange.positionHorizontal][vertexChange.positionVertical -1];
         vertexChange.adjacent.add(topAdjacent);
      }

      if (vertexChange.bottomRow == false) 
      {
         Vertex bottomAdjacent = myVertex[vertexChange.positionHorizontal][vertexChange.positionVertical +1];
         vertexChange.adjacent.add(bottomAdjacent);
      }
   }

   /**
    * Method to delete a wall in the maze
    * @param wall the wall to be deleted 
    * @return
    */
   private boolean deleteWall(boolean wall)
   {
      if (wall)
      {
         return false;
      }
      return true;
   }

   /**
    * Method to remove a wall
    * @param recent the recent vertex to be changed
    * @param following the adjacent vertex to be changed
    */
   private void removeWall(Vertex recent, Vertex following)
   {
      if(recent.label + SIZE == following.label)
      {
    	 following.topWallOccur = deleteWall(following.topWallOccur);
         recent.bottomWallOccur = deleteWall(recent.bottomWallOccur);
         recent.adjacent.remove(following);
         following.adjacent.remove(recent);
      }
      else if(recent.label + 1 ==following.label)
      {
    	 following.leftWallOccur =  deleteWall(following.leftWallOccur);
         recent.rightWallOccur = deleteWall(recent.rightWallOccur);
         recent.adjacent.remove(following);
         following.adjacent.remove(recent);
      }
      else if(recent.label -1 == following.label)
      {
    	  following.rightWallOccur = deleteWall(following.rightWallOccur);
         recent.leftWallOccur = deleteWall(recent.leftWallOccur);
         recent.adjacent.remove(following);
         following.adjacent.remove(recent);
      }
      else if(recent.label - SIZE == following.label)
      {
    	 following.bottomWallOccur = deleteWall(following.bottomWallOccur);
         recent.topWallOccur = deleteWall(recent.topWallOccur);
         recent.adjacent.remove(following);
         following.adjacent.remove(recent);
      }
   }

   /**
    * Method to create a graph
    */
   public void graphCreator()
   {
      int temp = 1;
      for (int i = 0; i < SIZE; i++)
      {
         for (int j = 0; j < SIZE; j++)
         {
            Vertex vertexChange = new Vertex(i, j, temp);
            myVertex[i][j] = vertexChange;
            temp++;
         }
      }

      for (int i = 0; i < SIZE; i++)
      {
         for (int j = 0; j < SIZE; j++)
         {
            Vertex recent = myVertex[i][j];
            repairAdj(recent);
         }
      }
      mazeCreator();
   }

   /**
    * Method to see if the vertex is visited
    * @param peek is a boolean value
    * @return true if peek is false
    */
   public boolean peek(boolean peek)
   {
      if (peek == false)
      {
         return true;
      }
      return false;
   }

   /**
    * Method to traverse through nodes
    * @param myNode is a node
    */
   private Node goToLast(Node myNode)
   {
      while(myNode.next != null)
      {
    	  myNode = myNode.next;
      }
      return myNode;
   }
   
   /**
    * Method to scan the last node in a LinkedList
    * @param myNode is a node
    * @return true if it is the last node in LinkedList otherwise false
    */
   private boolean isLast(Node myNode)
   {
      return (myNode != null && myNode.next == null);
   }
   
   /**
    * Method to create a maze
    */
   private void mazeCreator()
   {
      Stack<Vertex> myStack = new Stack<Vertex>(); 
      Vertex tempVertex = myVertex[0][0]; 
      tempVertex.alreadyVisited = peek(tempVertex.alreadyVisited);
      int visitedVertex = 1; 

      int sum = SIZE*SIZE;
      while(visitedVertex < sum)
      {
         if(getAdjacent(tempVertex) >= 1) //find neighbors with walls intact(unvisited neighbors)
         {
            int myRandom1 = myRandom.nextInt(getAdjacent(tempVertex)); //if one or more found choose at random
            Vertex randomTemp = tempVertex.adjacent.get(myRandom1);
            removeWall(randomTemp, tempVertex); //knock down wall between it and tempVertex

            Node myNode = new Node();
            myNode.vertexChange = randomTemp;
            Node currentNode = adjList[tempVertex.label-1];

            if (!isNull(currentNode)) 
            {
               currentNode = goToLast(currentNode);
               if (isLast(currentNode)) { currentNode.next = myNode; }
            }

            else if (isNull(currentNode))
            {
               currentNode = myNode;
               generateHelper(tempVertex, currentNode);
            }

            Node tempVertexNode = new Node();
            tempVertexNode.vertexChange = tempVertex;
            currentNode = adjList[randomTemp.label-1];
            if (!isNull(currentNode)) 
            {
               currentNode = goToLast(currentNode);
               if (isLast(currentNode)) { currentNode.next = tempVertexNode; }
            }
            else if (isNull(currentNode))
            {
               currentNode = tempVertexNode;
               generateHelper(randomTemp, tempVertexNode);
            }

            visitedVertex = visitedVertex +1;
            myStack.push(tempVertex);
            tempVertex = randomTemp;
            tempVertex.alreadyVisited = true;
         }
         else tempVertex = myStack.pop();
      }     
   }
   
   /**
    * Change previous node to current node
    * @param v1 vertex to be changed
    * @param v2 is a Node
    */
   private void generateHelper(Vertex v1, Node v2)
   {
      adjList[v1.label - 1] = v2;
   }
   
   /**
    * Check if node is null 
    * @param temp is a Node
    * @return a boolean
    */
   private boolean isNull (Node temp)
   {
      return temp == null;
   }
}
