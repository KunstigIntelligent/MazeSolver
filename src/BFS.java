import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {
	
	public static boolean searchPath(int[][] maze, Node start , Node goal, List<Node> path){
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		int steps = 1;
		nextToVisit.add(start);
		
		while(!nextToVisit.isEmpty()){
			Node node = nextToVisit.remove();
			
			//check if the target node was reached
			if (node.X == goal.X && node.Y == goal.Y){
				System.out.printf("\n\nFound a path!\nUsed %d steps.",steps);
				path.add(node);
				addParrentToList(node, path);
				return true;
			}
			// Checks either the node is visited or not
			if(maze[node.Y][node.X] == 2)
				continue;
			
			System.out.printf("\n\nStep %d\nDequeue: (%d,%d)",steps,node.X,node.Y);
			
			if(maze[node.Y][node.X] == 0){
				maze[node.Y][node.X] = 2;
				ArrayList<Node> children = new ArrayList<Node>();
				
				Node n = new Node(node.X, node.Y+1, node, goal);
				if(maze[node.Y+1][node.X] == 0) children.add(n); //add south node
				n = new Node(node.X+1, node.Y, node, goal);
				if(maze[node.Y][node.X+1] == 0) children.add(n); //add east node
				n = new Node(node.X, node.Y-1, node, goal);
				if(maze[node.Y-1][node.X] == 0) children.add(n); //add north node
				n = new Node(node.X-1, node.Y, node, goal);
				if(maze[node.Y][node.X-1] == 0) children.add(n); //add west node
				System.out.printf("\nEnqueue: ");
				for(Node child : children){
					System.out.printf("(%d,%d) ",child.X,child.Y);
					nextToVisit.add(child);
				}
				System.out.print("\nQueue: ");
				for(Node next :nextToVisit)
					System.out.printf("(%d,%d) ",next.X,next.Y);
					
			}
			steps++;
		}
		return false;	
	}
	
	static void sort(Node[] list, int i){
		if(i == list.length-1)
			return;
		
		if(i < list.length-1){
			if(list[i].cost > list[i+1].cost){
				Node temp = list[i] ;
				list[i] = list[i+1];
				list[i+1] = temp;
		}
			sort(list,i+1);
		}
	}
	
	static void addParrentToList(Node node, List<Node> list){
		if(node.parrent != null){
			list.add(node.parrent);
			addParrentToList(node.parrent, list);
		}
	}
	
}
