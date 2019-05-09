import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main 
{
	public static void main(String[] args)
	{
		new Main();
	}
	
	private JFrame frame;
	
	public Main()
	{
		initFrame();
		MyJPanel3Rect rectPanel = new MyJPanel3Rect();
		rectPanel.setPreferredSize(new Dimension(50, 0));
		JPanel myPanel = new JPanel()
				{
					@Override
					public void paint(Graphics g)
					{
						super.paint(g);
						g.drawString("Hello There", 30, 30);
					}
				};
		JPanel myOtherPanel = new JPanel()
				{
					@Override
					public void paint(Graphics g)
					{
						super.paint(g);
						g.fillRect(0, 0, 30, 30);
					}
				};
		myOtherPanel.setBackground(Color.blue);
		myOtherPanel.setPreferredSize(new Dimension(300, 0));
		myPanel.setBackground(new Color(255, 0, 0));
		frame.add(myPanel, BorderLayout.CENTER);
		frame.add(myOtherPanel, BorderLayout.EAST);
		frame.add(rectPanel, BorderLayout.WEST);
		frame.pack();
		frame.repaint();
	}
	
	private void initFrame()
	{
		frame = new JFrame("MyFrame")
				{
					public void paint(Graphics g)
					{
						super.paint(g);
						System.out.println(getSize());
					}
				};
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		frame.setPreferredSize(new Dimension(dm.getWidth(), dm.getHeight()));
		frame.setVisible(true);
		frame.pack();
		frame.repaint();
	}
}
