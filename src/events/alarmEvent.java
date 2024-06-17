/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author hatem
 */
public class alarmEvent {
    public final boolean alarmState; 
    
    public alarmEvent(boolean alarmState){
    this.alarmState=alarmState;
    }

    public boolean isAlarmState() {
        return alarmState;
    }
 
    
    
    
}
