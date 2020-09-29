
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Zach Theis
 * @version 2029.09.28
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private boolean isMorning;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00 AM.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, boolean morning)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute, morning);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) 
        {  // it just rolled over!
            hours.increment();
            if(hours.getValue() == 0)
            {
                if(isMorning)
                {
                    isMorning = false;
                }
                else
                {
                    isMorning = true;
                }
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, boolean morning)
    {
        hours.setValue(hour);
        //hours.setIsMorning(morning);
        minutes.setValue(minute);
        //minutes.setIsMorning(morning);
        isMorning = morning;
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        
        if(hours.getValue() == 0)
        {
            if(isMorning)
            {
                displayString = "12:" + minutes.getDisplayValue() + " AM";
            }
            else
            {
                displayString = "12:" + minutes.getDisplayValue() + " PM";
            }
        }
        else
        {
            if(isMorning)
            {
                displayString = hours.getDisplayValue() + ":" + 
                                minutes.getDisplayValue() + " AM";
            }
            else
            {
                displayString = hours.getDisplayValue() + ":" + 
                                minutes.getDisplayValue() + " PM";
            }
        }
    }
}
