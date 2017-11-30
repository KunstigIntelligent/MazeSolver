package entity;

import java.util.ArrayList;
import java.util.List;

public class Maze {
	public Node startNode = new Node(6,8);
	public Node goalNode;
	List<Node> path = new ArrayList<Node>();
	int[][] map;
	
	public Maze(int mapNumber){
		switch(mapNumber){
			case 2: {
				map = map2();
				System.out.println("Map 2 er valgt!"); break;
			}
			default : {
				map = map1();
				System.out.println("Map 1 bliver valgt");
				break;
			}
		}
		goalNode = new Node(map[0].length-2, map.length-2);
	}
	
	public int[][] getMap(){
		return map;
	}
	
	public List<Node> getPath(){
		return path;
	}
	
	private int[][] map1(){
	  	int[][] map1 = { {1,1,1,1,1,1,1,1,1,1,1,1,1},
			  {1,0,1,0,1,0,1,0,0,0,0,0,1},
			  {1,0,1,0,0,0,1,0,1,1,1,0,1},
			  {1,0,0,0,1,1,1,0,0,0,0,0,1},
			  {1,0,1,0,0,0,0,0,1,1,1,0,1},
			  {1,0,1,0,1,1,1,0,1,0,0,0,1},
			  {1,0,1,0,1,0,0,0,1,1,1,0,1},
			  {1,0,1,0,1,1,1,0,1,0,1,0,1},
			  {1,0,0,0,0,0,0,0,0,0,1,0,1},
			  {1,1,1,1,1,1,1,1,1,1,1,1,1}
			};
	  	return map1;
	}
	
	private int[][] map2(){
		int[][] map2 = 
			{ {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			  {1,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1},
			  {1,0,1,0,0,0,1,0,1,1,1,0,1,0,0,0,1,0,1,0,0,0,1},
			  {1,0,0,0,1,1,1,0,0,0,0,0,1,1,0,1,1,0,1,0,1,0,1},
			  {1,0,1,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,1,0,1,0,1},
			  {1,0,1,0,1,1,1,0,1,0,0,0,1,1,0,1,1,1,1,1,1,0,1},
			  {1,0,1,0,1,0,0,0,1,0,1,1,0,0,0,1,0,0,0,0,1,1,1},
			  {1,0,0,0,1,1,1,0,1,0,1,0,0,1,0,1,0,1,1,0,0,0,1},
			  {1,1,1,0,0,1,0,0,1,0,1,0,1,1,0,1,0,1,0,0,1,0,1},
			  {1,0,1,0,1,1,0,1,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1},
			  {1,0,0,0,1,0,1,1,0,0,1,1,0,1,1,1,0,1,1,0,1,0,1},
			  {1,0,1,1,1,0,0,0,0,1,1,0,0,1,0,0,0,1,0,0,1,0,1},
			  {1,0,0,1,0,0,1,1,0,0,0,0,1,1,0,1,0,0,1,0,1,0,1},
			  {1,0,1,1,1,1,1,0,1,0,1,0,1,0,0,1,1,0,1,0,1,0,1},
			  {1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,1,0,0,1,0,1,0,1},
			  {1,0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,0,1,1,0,1,0,1},
			  {1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,0,1,0,1},
			  {1,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,0,1,1,0,1,0,1},
			  {1,0,1,0,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,1},
			  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
			};
		return map2;
	}
	
}
