
public class Node{

	public int X;
	public int Y;
	public char name;
	public Node parrent;
	public int cost = 0;
	
	public Node(int x, int y){
		X = x ;
		Y = y;
	}
	public Node(int x, int y, Node parrent, Node goal){
		X = x ;
		Y = y;
		this.parrent = parrent;
		cost = Math.abs(goal.X-x)+Math.abs(goal.Y-y);
	}
}
