
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
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 *
 *boolean that changes when time switches over
 *
 */
public class ClockDisplay12Hr
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;
    private String dayTime;
    private int count = 0;
    private boolean swap; //simulates the actual display

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at 00:00.
     */
    public ClockDisplay12Hr()
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
    public ClockDisplay12Hr(int hour, int minute)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            count = count + 1;
            
            if((count % 12) == 1){
                swap = !swap;
                count = 0;
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
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
    
    
        if(swap == true){
        dayTime = "pm";
    }else{
        dayTime = "am";    
    }
    
    
        if(hours.getValue() == 0){
            displayString = 12 + ":" +
                        minutes.getDisplayValue() + " " + dayTime;            
        }else{
            displayString = hours.getDisplayValue() + ":" +
                        minutes.getDisplayValue() + " " + dayTime;
                    }
    }
}
