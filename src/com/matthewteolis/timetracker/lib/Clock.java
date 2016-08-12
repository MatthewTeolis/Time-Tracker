package com.matthewteolis.timetracker.lib;

public class Clock
{	
	private int hour;
	private int minute;
	private int second;
	
	/**
	 * Creates a new clock object initialized at 00:00:00.
	 */
	public Clock()
	{
		this(0, 0, 0);
	}
	
	/**
	 * Creates a new clock object with the given hour, minute, and second.
	 * @param hour - integer
	 * @param minute - integer
	 * @param second - integer
	 */
	public Clock(int hour, int minute, int second)
	{
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}

	/**
	 * Gets the hour of the clock.
	 * @return The hour as an integer.
	 */
	public int getHour()
	{
		return hour;
	}

	/**
	 * Sets the hour of the clock.
	 * Range 0-99.
	 * @param hour - integer
	 */
	public void setHour(int hour)
	{
		if(hour < 0 || hour > 99)
		{
			this.hour = 0;
		}
		else
		{
			this.hour = hour;
		}
	}

	/**
	 * Gets the minute of the clock.
	 * @return The minute as an integer. 
	 */
	public int getMinute()
	{
		return minute;
	}

	/**
	 * Sets the minute of the clock.
	 * Range 0-59.
	 * @param minute - integer
	 */
	public void setMinute(int minute)
	{
		if(minute < 0 || minute > 59)
		{
			this.minute = 0;
		}
		else
		{
			this.minute = minute;
		}
	}

	/**
	 * Gets the second of the clock.
	 * @return The second as an integer. 
	 */
	public int getSecond()
	{
		return second;
	}

	/**
	 * Sets the second of the clock.
	 * Range 0-59.
	 * @param second - integer
	 */
	public void setSecond(int second)
	{
		if(second < 0 || second > 59)
		{
			this.second = 0;
		}
		else
		{
			this.second = second;
		}
	}
	
	/**
	 * Increments the second by 1.
	 * Increments the minute by one if the second reaches 60
	 */
	public void tickSecond()
	{
		++this.second;
		if(this.second >= 60)
		{
			this.second = 0;
			this.tickMinute();
		}
	}
	
	/**
	 * Increments the minute by 1.
	 * Increments the hour by one if the minute reaches 60
	 */
	public void tickMinute()
	{
		++this.minute;
		if(this.minute >= 60)
		{
			this.minute = 0;
			this.tickHour();
		}
	}
	
	/**
	 * Increments the hour by 1.
	 */
	public void tickHour()
	{
		++this.hour;
		if(this.hour >= 100)
		{
			this.hour = 0;
		}
	}
	
	/**
	 * Returns a formatted string representation of the clock time.
	 * Format: hh:mm:ss
	 */
	@Override
	public String toString()
	{
		return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
	}
}
