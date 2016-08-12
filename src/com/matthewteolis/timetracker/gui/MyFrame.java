package com.matthewteolis.timetracker.gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame
{
	public MyFrame()
	{
		// Customize the frame
		super("Time Tracker");
		this.setResizable(false);
		this.setBackground(Color.DARK_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(MyFrame.class.getResource("../images/timer.png")).getImage());
		
		// Set the location, width, and height of the frame.
		// Timer should always appear at the top left of the screen,
		// 100px away from the top and from the left.
		this.setBounds(100, 100, 450, 213);
		
		// Initialize the contents in the frame
		this.init();
		
		// Make the frame appear
		this.setVisible(true);
	}
	
	private void init()
	{
		// Add the TimePanel to the main frame.
		TimePanel timePanel = new TimePanel();
		this.add(timePanel);
	}
}
