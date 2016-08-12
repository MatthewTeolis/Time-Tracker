package com.matthewteolis.timetracker.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.matthewteolis.timetracker.drivers.ClockDriver;

public class BtnResetListener implements ActionListener
{	
	// ClockDriver reference.
	private ClockDriver clockDriver;
	
	public BtnResetListener(ClockDriver clockDriver)
	{
		// Reference to the clock driver is needed for the reset button.
		this.clockDriver = clockDriver;
	}
	
	/**
	 * Resets the ClockDriver's timer.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.clockDriver.reset();
	}
}
