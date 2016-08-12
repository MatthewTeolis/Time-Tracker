
package com.matthewteolis.timetracker.drivers;

import com.matthewteolis.timetracker.lib.Clock;

public class ClockDriver //implements Runnable
{
	private Clock clock;
	
	private boolean alive;
	private boolean running;
	
	private long millis;
	private long timeStopped;
	
	public ClockDriver()
	{
		this.running = false;
		this.alive = true;
		this.millis = 0;
		this.timeStopped = 0;
		this.clock = new Clock();
	}
	
	/**
	 * Start the clock.
	 */
	public void start()
	{
		this.millis = System.currentTimeMillis() - this.timeStopped;
		this.running = true;
	}
	
	/**
	 * Stop the clock.
	 */
	public void stop()
	{
		this.timeStopped = System.currentTimeMillis() - this.millis;
		this.running = false;
	}
	
	/**
	 * Check if the clock is alive.
	 * @return
	 */
	public boolean isAlive()
	{
		return this.alive;
	}
	
	/**
	 * Destroy the clock.
	 */
	public void destroy()
	{
		this.alive = false;
	}
	
	/**
	 * Resets the clock time.
	 */
	public void reset()
	{
		this.stop();
		this.millis = System.currentTimeMillis();
		this.clock.setHour(0);
		this.clock.setMinute(0);
		this.clock.setSecond(0);
	}
	
	/**
	 * Checks if the clock is running.
	 * @return true if the clock is running, false otherwise.
	 */
	public boolean isRunning()
	{
		return this.running;
	}
	
	/**
	 * Set the milliseconds of the clock.
	 * @param millis - long integer.
	 */
	public void setMillis(long millis)
	{
		this.millis = millis;
	}
	
	/**
	 * Get the milliseconds of the clock.
	 * @return milliseconds - long integer.
	 */
	public long getMillis()
	{
		return this.millis;
	}
	
	/**
	 * Get the clock reference.
	 * @return Clock object being used.
	 */
	public Clock getClock()
	{
		return this.clock;
	}
	
	/*
	@Override
	public void run()
	{
		this.alive = true;
		while(this.alive)
		{
			if(this.running && System.currentTimeMillis() >= this.millis + 1000)
			{
				this.millis += 1000;
				this.clock.tickSecond();
			}
		}
	}*/
}