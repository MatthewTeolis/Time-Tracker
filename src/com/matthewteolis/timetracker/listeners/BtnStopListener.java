package com.matthewteolis.timetracker.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.matthewteolis.timetracker.drivers.ClockDriver;

public class BtnStopListener implements ActionListener
{
	// ClockDriver reference.
	private ClockDriver clockDriver;
	
	public BtnStopListener(ClockDriver clockDriver)
	{
		// Reference to the clock driver is needed for the stop button.
		this.clockDriver = clockDriver;
	}
	
	/**
	 * Stops the ClockDriver's timer.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(this.clockDriver.isRunning())
		{
			this.clockDriver.stop();
		}
	}	
}