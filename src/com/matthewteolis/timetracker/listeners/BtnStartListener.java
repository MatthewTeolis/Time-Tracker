package com.matthewteolis.timetracker.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.matthewteolis.timetracker.drivers.ClockDriver;

public class BtnStartListener implements ActionListener
{
	// ClockDriver reference.
	private ClockDriver clockDriver;
	
	public BtnStartListener(ClockDriver clockDriver)
	{
		// Reference to the clock driver is needed for the start button.
		this.clockDriver = clockDriver;
	}
	
	/**
	 * Starts the ClockDriver's timer.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(!this.clockDriver.isRunning())
		{
			this.clockDriver.start();
		}
	}	
}