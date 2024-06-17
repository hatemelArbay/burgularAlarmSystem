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

/**
 *
 * @author YoussefNaeim
 */
public class panicButton implements Runnable {
    private String buttonID;
    private lightSwitcher lightswitch;
    private alarm alarm;
    private boolean panicState;
    panicButton(){
        this.buttonID="";
    }

    public panicButton(String buttonID) {
        this.buttonID = buttonID;
       
    }

    public boolean getPanicState() {
        return panicState;
    }

    public void setPanicState(boolean panicState) {
        this.panicState = panicState;
    }
    
     public void run() {
    
        try{
        while (true){
            Thread.sleep(3000);

            if(panicState){
             
               config.sendEvent(new alarmEvent(true));
               config.sendEvent(new lightState(true));
               config.sendEvent(new intruderState(true));
                System.out.println("panic mode on");
//                if (getPanicState()==false){
//                    System.out.println("turning off panic mode...");
//                    config.sendEvent(new alarmEvent(false));
//               config.sendEvent(new lightState(false));
//                }
            }
       
        }
        }catch(Exception err){
            System.out.println("error ");
        }
    }
}
