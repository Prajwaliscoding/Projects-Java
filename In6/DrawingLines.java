import javax.swing.*;//Used to make the Window
import java.awt.*; //Needed for drawing
import java.util.*;
public class DrawingLines extends JPanel{//When it extends JPanel and it creates the drawable image (panel) that is added to the frame


	/*
	 * Main method sets up the Frame and an instance of DrawingLines
	 * 
	 */
	public static void main(String[] args)
	{
		//Create a new Window Frame
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		//Creates a new instance of this class
		DrawingLines lineDrawer = new DrawingLines();
		//Adds the drawing Panel to the frame
		frame.add(lineDrawer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	/*
	 * This is called by
	 * the JFrame as it is an overridden method to draw the lines. 
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		//This draws the lines
		drawLines(g);
	}
	/*
	 * This Draws line!
	 */
	public void drawLines(Graphics g)
	{
		Color[] colors = {Color.black,Color.blue,Color.red,Color.green,Color.darkGray};
		Line[] lines = new Line[5];
		lines[0] = new SlopedLine(1);
		lines[1] = new SineLine(100,0.25);
		lines[2] = new ExponentialLine(1.25);
		lines[3] = new StaircaseLine(20,20);
		lines[4] = new SawLine(50);
		
		final int X_POINTS = 1000;
		
		for(int i=0;i<X_POINTS;i++)
		{
			for(int j=0;j<lines.length;j++)
			{
				if(lines[j]==null)
					continue;
				g.setColor(colors[j]);
				g.drawLine(i, getSize().height - (int)lines[j].getYPoint(i), i+1, getSize().height - (int)lines[j].getYPoint(i+1));
			}
		}
	}

}