package interia.event.other;

import interia.lib.event.Event;

public class EventKeyPress extends Event
{
	private final int keyCode;

    public EventKeyPress(int keyCode)
    {
        this.keyCode = keyCode;
    }

    public int getKeyCode() 
    {
        return this.keyCode;
    }
}
