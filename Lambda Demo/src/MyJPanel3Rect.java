import java.awt.Graphics;

import javax.swing.JPanel;

public class MyJPanel3Rect extends JPanel
{
	public MyJPanel3Rect()
	{
		super();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawRect(0, 0, 20, 20);
		g.drawRect(0, 30, 20, 20);
		g.drawRect(0, 60, 20 , 20);
	}
}
