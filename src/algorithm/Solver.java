package algorithm;

import entity.Maze;
import entity.Node;

public class Solver {
	
	BFS bfs = new BFS();
	DFS dfs = new DFS();
	
	public void solve(Maze maze, String algorithm){
		
		boolean solved;
		switch(algorithm){
			case "dfs": solved = dfs.searchPath(maze); break;
			default: solved = bfs.searchPath(maze); break;
		}
		
		if(!solved){
			System.out.println("No path found!");
			return;
		}
		else{
			System.out.printf("\nDistance: %d\nPath: ",maze.getPath().size());
			for(int n = maze.getPath().size()-1; n >= 0; n--){
				Node p = maze.getPath().get(n);
				if(p.X==maze.startNode.X && p.Y == maze.startNode.Y)
					System.out.printf("Start -> ");
				else if(p.X==maze.goalNode.X && p.Y == maze.goalNode.Y)
					System.out.printf("<- GOAL ");
				else{
					System.out.printf("(%d,%d) ",p.X,p.Y);
					if(n % 5 == 0)
						System.out.println("");
				}
			}
		}
	}
	
}
