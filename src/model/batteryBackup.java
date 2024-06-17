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
public class batteryBackup implements battery,Runnable {
    public String batteryId;
    public double voltage;
    private boolean voltageState;
       private screen output;

    public batteryBackup(String batteryId) {
        this.batteryId = batteryId;
        output=screen.getInstance();

    }
    
       public void setVoltageState(boolean voltageState){
        this.voltageState=voltageState;
          
           if(voltageState==true)
                System.out.println("backup batter state : "+voltageState);
           else 
                 System.out.println("backup batter fase : "+voltageState);
               
               
    }
       
    public void power(){
        System.out.println("this is battery backup");
    }
      @Override
    public void run() {

          System.out.println("voltage state " +voltageState);
      while(true){
          if(voltageState){
              output.displayPowerSource("battery backup");
              System.out.println("battery backup");
//              try {
//                  Thread.sleep(500);
//              } catch (InterruptedException ex) {
//                  Logger.getLogger(mainPower.class.getName()).log(Level.SEVERE, null, ex);
//              }
          
          }
      }
    }


    
}
