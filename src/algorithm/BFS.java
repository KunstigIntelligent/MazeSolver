package algorithm;
import java.util.LinkedList;
import java.util.List;

import entity.Maze;
import entity.Node;

public class BFS {
	
	public boolean searchPath(Maze maze){
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		int steps = 1;
		Node goal = maze.goalNode;
		nextToVisit.add(maze.startNode);
		
		while(!nextToVisit.isEmpty()){
			Node node = nextToVisit.remove();
			
			//check if the target node was reached
			if (node.X == goal.X && node.Y == goal.Y){
				System.out.printf("\n\nFound a path!\nUsed %d steps.",steps);
				maze.getPath().add(node);
				addParrentToList(node, maze.getPath());
				return true;
			}
			// Checks either the node is visited or not
			if(maze.getMap()[node.Y][node.X] == 2)
				continue;
			
			System.out.printf("\n\nStep %d\nDequeue: (%d,%d)",steps,node.X,node.Y);
			
			if(maze.getMap()[node.Y][node.X] == 0){
				maze.getMap()[node.Y][node.X] = 2;
				
				if(maze.getMap()[node.Y-1][node.X] == 0) nextToVisit.add(new Node(node.X,node.Y-1,node, goal)); //add north node
				if(maze.getMap()[node.Y][node.X-1] == 0) nextToVisit.add(new Node(node.X-1,node.Y,node, goal)); //add west node
				if(maze.getMap()[node.Y+1][node.X] == 0) nextToVisit.add(new Node(node.X,node.Y+1,node, goal)); //add south node
				if(maze.getMap()[node.Y][node.X+1] == 0) nextToVisit.add(new Node(node.X+1,node.Y,node, goal)); //add east node
				
				//ArrayList<Node> children = new ArrayList<Node>();
				
//				Node n = new Node(node.X, node.Y-1, node, goal);
//				if(maze[n.Y][n.X] == 0) children.add(n); //add north node
//				n = new Node(node.X-1, node.Y, node, goal);
//				if(maze[n.Y][n.X] == 0) children.add(n); //add west node
//				n = new Node(node.X, node.Y+1, node, goal);
//				if(maze[n.Y][n.X] == 0) children.add(n); //add south node
//				n = new Node(node.X+1, node.Y, node, goal);
//				if(maze[n.Y][n.X] == 0) children.add(n); //add east node

				//Collections.sort(children);
//				System.out.printf("\nEnqueue: ");
//				for(Node child : children){
//					System.out.printf("(%d,%d) ",child.X,child.Y);
//					nextToVisit.add(child);
//				}
				
				System.out.print("\nQueue: ");
				for(Node next : nextToVisit)
					System.out.printf("(%d,%d) ",next.X,next.Y);
			}
			steps++;
		}
		return false;	
	}
	
	void addParrentToList(Node node, List<Node> list){
		if(node.parrent != null){
			list.add(node.parrent);
			addParrentToList(node.parrent, list);
		}
	}
	
}
