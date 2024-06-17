/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import esper.config;
import events.alarmEvent;
import events.intruderState;
import events.voltageDrop;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author YoussefNaeim
 */
public class circuitMonitor implements Runnable {
    private boolean voltageState; 
    private battery battery;
    private int voltage;
    private alarm alarm;
    private gps location;
    private screen output;

    
    

    public circuitMonitor(gps location) throws LineUnavailableException {
        output= screen.getInstance();
        this.location=location;
        alarm = new alarm("alarm-1");
    }

    public circuitMonitor() {
        output= screen.getInstance();
    }

    public void setVoltageDrop(boolean voltageDrop) {
        this.voltageState = voltageDrop;
        System.out.println("Voltage dropped value :"+this.voltageState);
    }
    @Override
public void run() {
  
        while (true) {
          
            

               voltage=110;
            output.displayVoltage(voltage+"");
              if (voltage == 0) {
//                  output.displayPowerSource("batter backup");
                 config.sendEvent(new voltageDrop(true));
                  config.sendEvent(new alarmEvent(true));
                  config.sendEvent(new intruderState(true));
//                  break;
                   
                  }
            if (voltage < 50 && voltage!=0) {
                   alarm.getVoice().callTechnical(location);

                config.sendEvent(new voltageDrop(true));
                config.sendEvent(new alarmEvent(false));
                
                
             
              

                    }}
}
}


    

