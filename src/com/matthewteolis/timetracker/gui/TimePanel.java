package com.matthewteolis.timetracker.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.matthewteolis.timetracker.drivers.ClockDriver;
import com.matthewteolis.timetracker.lib.Constants;
import com.matthewteolis.timetracker.listeners.BtnResetListener;
import com.matthewteolis.timetracker.listeners.BtnStartListener;
import com.matthewteolis.timetracker.listeners.BtnStopListener;

public class TimePanel extends JPanel implements Constants, Runnable
{	
	private JTextField txtTime;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnReset;
	private ClockDriver clockDriver;
	private Thread threadUpdate;
	
	public TimePanel()
	{
		this.clockDriver = new ClockDriver();
		
		// This thread will run and update the clock.
		this.threadUpdate = new Thread(this, "Thread-TimePanelUpdate");
		
		// Customize the panel
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		
		// Add the components to the panel
		this.addTextField();
		this.addStartButton();
		this.addStopButton();
		this.addResetButton();
		
		this.threadUpdate.start();
	}
	
	// Create and add the text field (where the numbers are).
	private void addTextField()
	{
		// Customize the text field.
		this.txtTime = new JTextField();
		this.txtTime.setFont(new Font("Monospaced", Font.PLAIN, 86));
		this.txtTime.setEditable(false);
		this.txtTime.setBackground(Color.LIGHT_GRAY);
		this.txtTime.setBounds(10, 10, 424, 127);
		this.add(this.txtTime);
		
		// Bug fix:
		// When the timer is stopped and you click on the text
		// the application breaks.
		this.txtTime.removeMouseListener(this.txtTime.getMouseListeners()[2]);
		
		// Bug Fix:
		// When timer is running and you "select" the text
		// the application breaks.
		this.txtTime.removeMouseMotionListener(this.txtTime.getMouseMotionListeners()[1]);
	}
	
	// Create and add the start button.
	private void addStartButton()
	{
		this.btnStart = new JButton("Start");
		this.btnStart.setToolTipText(Constants.TOOLTIP_START);
		this.btnStart.setBackground(Color.LIGHT_GRAY);
		this.btnStart.setBounds(10, 149, 89, 23);
		this.btnStart.addActionListener(new BtnStartListener(this.clockDriver));
		this.add(this.btnStart);
	}
	
	// Create and add the stop button.
	private void addStopButton()
	{
		this.btnStop = new JButton("Stop");
		this.btnStop.setToolTipText(Constants.TOOLTIP_STOP);
		this.btnStop.setBackground(Color.LIGHT_GRAY);
		this.btnStop.setBounds(180, 149, 89, 23);
		this.btnStop.addActionListener(new BtnStopListener(this.clockDriver));
		this.add(this.btnStop);
	}
	
	// Create and add the reset button.
	private void addResetButton()
	{
		this.btnReset = new JButton("Reset");
		this.btnReset.setToolTipText(Constants.TOOLTIP_RESET);
		this.btnReset.setBackground(Color.LIGHT_GRAY);
		this.btnReset.setBounds(345, 149, 89, 23);
		this.btnReset.addActionListener(new BtnResetListener(this.clockDriver));
		this.add(this.btnReset);
	}
	
	/**
	 * Get the text time field component.
	 * @return Time text field as a JTextField.
	 */
	public JTextField getTimeField()
	{
		return this.txtTime;
	}
	
	/**
	 * Get the start button component.
	 * @return The start button as a JButton.
	 */
	public JButton getBtnStart()
	{
		return this.btnStart;
	}

	/**
	 * Get the stop button component.
	 * @return The stop button as a JButton.
	 */
	public JButton getBtnStop()
	{
		return this.btnStop;
	}

	/**
	 * Get the reset button component.
	 * @return The reset button as a JButton.
	 */
	public JButton getBtnReset()
	{
		return this.btnReset;
	}

	/**
	 * Run the clock.
	 */
	@Override
	public void run()
	{
		while(this.clockDriver.isAlive())
		{
			// Runs every second and if flag is on.
			if(this.clockDriver.isRunning() && System.currentTimeMillis() >= this.clockDriver.getMillis() + 1000)
			{
				this.clockDriver.getClock().tickSecond();
				this.clockDriver.setMillis(System.currentTimeMillis());
			}
			
			// Update the time text field.
			this.update();
		}
	}
	
	/**
	 * Graphically updates the text value for the time.
	 */
	private void update()
	{
		this.txtTime.setText(this.clockDriver.getClock().toString());
	}
}
