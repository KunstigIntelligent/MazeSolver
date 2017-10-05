import java.util.List;

public class DFS {

	
	static int steps;
	public static boolean searchPath(int[][] maze, Node start, Node goal, List<Node> path){
		return searchPath(maze, start.X, start.Y, goal, path);
	}
	
	
	
	public static boolean searchPath(int[][] maze, int x, int y , Node goal, List<Node> path){
		
		if(maze[y][x] == 2)
			return false;
		
		// check if the target node was reached
		if (x == goal.X && y == goal.Y){
			System.out.print("Found a path!\nUsed "+steps+" steps.\nPath:");
			path.add(new Node(x,y));
			return true;
		}
		
		System.out.printf("Position: (%d,%d)\n",x,y);
		
		
		// when the current position (x and y) is 
		// a not-visited node (0), then let's mark it as visited 
		if(maze[y][x] == 0){
			maze[y][x] = 2;
			steps++;
			
			// search down
			int dx = 0, dy = 1;
			if (maze[y+dy][x+dx]!=1)
				if(searchPath(maze, x+dx, y+dy, goal, path)){
					path.add(new Node(x,y));
					return true;
				}
			
			// Searh right
			dx = 1; dy = 0;
			if (maze[y+dy][x+dx]!=1)
				if(searchPath(maze, x+dx,y+dy, goal, path)){
					path.add(new Node(x,y));
					return true;
				}
			
			// search up
			dx = 0; dy = -1;
			if (maze[y+dy][x+dx]!=1)
				if(searchPath(maze, x+dx, y+dy, goal, path)){
					path.add(new Node(x,y));
					return true;
				}
			
			// search laft
			dx = -1; dy = 0;
			if (maze[y+dy][x+dx]!=1)
				if(searchPath(maze, x+dx, y+dy, goal, path)){
					path.add(new Node(x,y));
					return true;
				}
		}
		return false;
	}
}
