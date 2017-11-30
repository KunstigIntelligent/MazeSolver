package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import algorithm.Solver;
import entity.Maze;
import entity.Node;


public class Frame extends JFrame{
	private static final long serialVersionUID = 1L;

	Maze maze = new Maze(2);
	boolean mapSolved;
	boolean dfsShowed, bfsShowed;
	private Graphics g;
	
	public Frame(){
		// Initialize the view 
		setTitle("Maze Solver - Mohammad");
		setSize(maze.getMap()[0].length*35+20,maze.getMap().length*35+50);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Solution BFS");
		JButton button2 = new JButton("Solution DFS");
		Container c = getContentPane();
		c.add(button, BorderLayout.NORTH);
		c.add(button2,BorderLayout.SOUTH);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showSolution("bfs");
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showSolution("dfs");

			}
		});
		
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		this.g= g;
		g.translate(50,50);
		drawMap();
		//showSolution();
	}
	
	void drawMap(){
		for (int row = 0; row < maze.getMap().length; row++){
			for(int col = 0; col < maze.getMap()[0].length; col ++){
				Color color;
				switch (maze.getMap()[row][col]){
					case 1 : color = Color.BLACK; break;
					default : color = Color.WHITE; break;
				}
				g.setColor(color);
				g.fillRect(30*col, 30 * row, 30, 30);
				g.setColor(Color.BLACK);
				g.drawRect(30 * col, 30*row, 30, 30);
			}
		}
		// Draw start position and goal
		g.setColor(Color.BLUE);
		g.fillOval(maze.startNode.X*30, maze.startNode.Y*30, 30, 30);
		g.setColor(Color.RED);
		g.fillRect(maze.goalNode.X*30, maze.goalNode.Y*30, 30, 30);
		g.setColor(Color.BLACK);
		g.drawRect(maze.goalNode.X*30, maze.goalNode.Y*30, 30, 30);
		
	}
	
	
	List<Node> listBFS = new ArrayList<Node>();
	List<Node> listDFS = new ArrayList<Node>();
	
	public void showSolution(String algo){
		switch(algo){
			case "dfs": {
				if(listBFS.size()<1){ 
					new Solver().solve(maze, "bfs");
					listBFS = maze.getPath();
				}
			} break;
			default : {
				if(listDFS.size()<1){
					new Solver().solve(maze, "dfs");
					listDFS = maze.getPath();
				}
			}		
		}
		Graphics g = this.getGraphics();
		g.translate(50,50);
		for (int n = 1; n < maze.getPath().size()-1; n++){
			int pathX = maze.getPath().get(n).X;
			int pathY = maze.getPath().get(n).Y;
			g.setColor(Color.green);
			g.fillRect(pathX*30, pathY *30, 30, 30);
			g.setColor(Color.BLACK);
			g.drawRect(pathX*30, pathY *30, 30, 30);
		}
		
	}
	
	public static void main(String[] arg){
		Frame view = new Frame();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				view.setVisible(true);
			}
		});
	}
	
	
}
