package com.std.controller.listener;


import com.std.controller.CalendarController;


/**
 * Supper Calendar Listener.
 * @author Huy Pham
 * 
 */
public abstract class ControllerListener{

    /*
     * Reference to the calendar controller
     */
    private CalendarController controller;

    /**
     * Constructor
     * @param cc Calendar controller
     */
    public ControllerListener(CalendarController cc){
        this.setController(cc);
        
    }

    /**
     * @return reference to the controller
     */
    public CalendarController getController() {
        return controller;
    }

    public void setController(CalendarController cc) {
        this.controller = cc;
    }
    
    
    

}
