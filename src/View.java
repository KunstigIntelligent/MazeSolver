import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class View extends JFrame{
	private static final long serialVersionUID = 1L;
 
//	final Node start = new Node(1,3);
//  	int[][] map = 
//		{ {1,1,1,1,1,1,1,1,1,1,1,1,1},
//		  {1,0,1,0,1,0,1,0,0,0,0,0,1},
//		  {1,0,1,0,0,0,1,0,1,1,1,0,1},
//		  {1,0,0,0,1,1,1,0,0,0,0,0,1},
//		  {1,0,1,0,0,0,0,0,1,1,1,0,1},
//		  {1,0,1,0,1,1,1,0,1,0,0,0,1},
//		  {1,0,1,0,1,0,0,0,1,1,1,0,1},
//		  {1,0,1,0,1,1,1,0,1,0,1,0,1},
//		  {1,0,0,0,0,0,0,0,0,0,1,0,1}, //Goal (11,8)
//		  {1,1,1,1,1,1,1,1,1,1,1,1,1}
//		};

	final Node start = new Node(6,8);
	int[][] map = 
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

	
	final Node goal = new Node(map[0].length-2, map.length-2);
	private final List<Node> path = new ArrayList<Node>();
	
	Graphics g;
	
	public View(){

		// Initialize the view 
		setTitle("Maze Solver - Mohammad");
		setSize(map[0].length*35+20,map.length*35+50);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// run the algorithm
		if(!BFS.searchPath(map, start, goal, path)){
			System.out.println("No path found!");
			return;
		}
		else{
			System.out.printf("\nDistance: %d\nPath: ",path.size());
			for(int n = path.size()-1; n >= 0; n--){
				Node p = path.get(n);
				if(p.X==start.X && p.Y == start.Y)
					System.out.printf("Start -> ");
				else if(p.X==goal.X && p.Y == goal.Y)
					System.out.printf("<- GOAL ");
				else{
					System.out.printf("(%d,%d) ",p.X,p.Y);
					if(n % 5 == 0)
						System.out.println("");
				}
				
			}
		}
	}
	
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		this.g= g;
		g.translate(50,50);
		
		for (int row = 0; row < map.length; row++){
			for(int col = 0; col < map[0].length; col ++){
				Color color;
				switch (map[row][col]){
					case 1 : color = Color.BLACK; break;
					default : color = Color.WHITE; break;
				}
				g.setColor(color);
				g.fillRect(30*col, 30 * row, 30, 30);
				g.setColor(Color.BLACK);
				g.drawRect(30 * col, 30*row, 30, 30);
			}
		}		

		drawPath(g);
	}
	
	public void drawPath(Graphics g){
		// Draw the path to goal
		for (int n = 1; n < path.size()-1; n++){
			int pathX = path.get(n).X;
			int pathY = path.get(n).Y;
			g.setColor(Color.green);
			g.fillRect(pathX*30, pathY *30, 30, 30);
			g.setColor(Color.BLACK);
			g.drawRect(pathX*30, pathY *30, 30, 30);
		}
				
		// Draw start position
		g.setColor(Color.BLUE);
		g.fillOval(start.X*30, start.Y*30, 30, 30);
		g.setColor(Color.RED);
		g.fillRect(goal.X*30, goal.Y*30, 30, 30);
		g.setColor(Color.BLACK);
		g.drawRect(goal.X*30, goal.Y*30, 30, 30);
		
	}
	
	public static void main(String[] arg){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				View view = new View();
				view.setVisible(true);
			}
		});
	}
	
	
}
