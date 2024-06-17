/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YoussefNaeim
 */
public class mainPower implements battery,Runnable{
    private String batteryId;
    private boolean voltageState;
    private screen output;
 

    public mainPower(String batteryId) {
        this.batteryId = batteryId;
        output=screen.getInstance();
        
    }
    public void power(){
        System.out.println("this is main power");
    }

    public void setVoltageState(boolean voltageState){
        this.voltageState=voltageState;
    }
    @Override
    public void run() {
      while(true){
          if(!voltageState){
              output.displayPowerSource("main power");
              try {
                  Thread.sleep(5000);
              } catch (InterruptedException ex) {
                  Logger.getLogger(mainPower.class.getName()).log(Level.SEVERE, null, ex);
              }
          
          }
      }
    }
    
    

    
    
}
