import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
	public static void main(String[] args)
	{
		Main myMain = new Main();
	}
	
	public static int curColorIndex = -1;
	public static Color[] colors = {Color.BLUE, Color.BLACK, Color.yellow, Color.red, Color.green};
	private JFrame frame;
	
	public static Color nextColor()
	{
		curColorIndex++;
		if(curColorIndex == colors.length)
		{
			curColorIndex = 0;
		}
		return colors[curColorIndex];
	}
	
	public Main()
	{
		initFrame();
		JPanel myPanel = new JPanel();
		JPanel myOtherPanel = new JPanel()
				{
					@Override
					public void paint(Graphics g)
					{
						super.paint(g);
						g.fillRect(0, 0, 30, 30);
					}
				};
		addButtonsToPanel(myPanel);
		myOtherPanel.setBackground(Color.blue);
		myOtherPanel.setPreferredSize(new Dimension(300, 0));
		myPanel.setBackground(new Color(255, 0, 0));
		frame.add(myPanel, BorderLayout.CENTER);
		frame.add(myOtherPanel, BorderLayout.EAST);
		frame.pack();
		frame.repaint();
	}
	
	private void addButtonsToPanel(JPanel panel)
	{
		JButton colorButton = new JButton();
		colorButton.setEnabled(true);
		colorButton.setVisible(true);
		colorButton.setText("Click me and i will change!");
		colorButton.addActionListener(
				(ActionEvent e) ->
				{
					Object source = e.getSource();
					if(source instanceof JButton)
					{
						JButton buttonSource = (JButton)source;
						buttonSource.setBackground(Main.nextColor());
						buttonSource.repaint();
					}
				});
		
		panel.add(colorButton);
	}
	
	private void initFrame()
	{
		frame = new JFrame("MyFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		frame.setPreferredSize(new Dimension(dm.getWidth(), dm.getHeight()));
		frame.setVisible(true);
		frame.pack();
		frame.repaint();
	}
	/*
	 * public void actionPerformed(ActionEvent e)
	 * {
	 * 		Object source = e.getSource();
			if(source instanceof JButton)
			{
				JButton buttonSource = (JButton)source;
				buttonSource.setBackground(Main.nextColor());
				buttonSource.repaint();
			}
	 * }
	 */
}
