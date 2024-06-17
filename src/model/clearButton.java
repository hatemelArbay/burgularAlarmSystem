/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.alarmEvent;
import events.intruderState;
import events.lightState;
import events.panicState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YoussefNaeim
 */
public class clearButton implements Runnable{
    public String buttonID;
    public lightSwitcher lightswitch;
    alarm alarm;
    public boolean clearState;

    public clearButton(String buttonID) {
        this.buttonID = buttonID;
        
    }

   

    public clearButton(String buttonID, lightSwitcher lightswitch, alarm alarm, boolean clearState) {
        this.buttonID = buttonID;
        this.lightswitch = lightswitch;
        this.alarm = alarm;
        this.clearState = clearState;
    }

    public boolean getClearState() {
        return clearState;
    }

    public void setClearState(boolean clearState) {
        this.clearState = clearState;
    }
    
   

    
    
    public void run() {
    
        try{
        while (true){
            Thread.sleep(3000);
          
            if(clearState){
             
               config.sendEvent(new alarmEvent(false));
               config.sendEvent(new lightState(false));
                config.sendEvent(new intruderState(false));
                config.sendEvent(new panicState(false));
                System.out.println("clear mode on");
             
            }
       
        }
    
}       catch (InterruptedException ex) {
            Logger.getLogger(clearButton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
