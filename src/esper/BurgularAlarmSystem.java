/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import esper.config;
import events.VoiceSynthesiserEvent;
import events.alarmEvent;
import events.intruderState;
import events.lightState;
import events.voltageDrop;
import java.util.TimerTask;
import javax.sound.sampled.LineUnavailableException;
import model.VoiceSynthesiser;
import model.alarm;
import model.battery;
import model.batteryBackup;
import model.circuitMonitor;
import model.clearButton;
import model.gps;
import model.lightSwitcher;
import model.mainPower;
import model.panicButton;
import model.sensor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author hatem
 */
public class BurgularAlarmSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, LineUnavailableException {
        
             // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);
        config.registerEvent();
        
       alarm Alarm= new alarm("ID-1");
      Thread alarmThread= new Thread(Alarm);
     
      
      gps location = new gps("gps-1","room1","house2");
      sensor roomSensor = new sensor("s-1","movement sensor",location);
      Thread sensorThread= new Thread(roomSensor);
   
        VoiceSynthesiser voice= VoiceSynthesiser.getInstance("vc-1");
      Thread VoiceSynthesiserThread = new Thread (voice);
      
      
      lightSwitcher lightroom1= new lightSwitcher("LightForRoom1",location);
        
      Thread lightSwitcherThread= new  Thread(lightroom1);
      
      circuitMonitor monitor = new circuitMonitor(location);
      Thread ThreadCiruitMonitor= new Thread(monitor);
      
      mainPower mainPower= new mainPower("MP-1");
        Thread mainPowerThread= new Thread(mainPower);
        
       batteryBackup backupBattery= new batteryBackup("BCK-1");
          Thread backupBatteryThread= new Thread(backupBattery);
          
          clearButton clear= new clearButton("BTN-1");
          Thread clearThread = new Thread (clear);
          
          panicButton panic= new panicButton("BTN-2");
          Thread panicThread= new Thread(panic);
          
       
       
     
       
      
      

      
  
      
      
       config.createStements("select alarmState from alarmEvent")
                .setSubscriber(new Object() {
                    public void update(Boolean state) throws InterruptedException {
                        Alarm.setAlarmState(state);
                    }
                });
       
        config.createStements("select lightState from lightState")
                .setSubscriber(new Object() {
                    public void update(Boolean state) throws InterruptedException {
                         lightroom1.setLightState(state);
                    }
                });
        
              config.createStements("select isIntruderDetected from intruderState")
                .setSubscriber(new Object() {
                    public void update(Boolean state) throws InterruptedException {
                        roomSensor.setSensorState(state);
                       
                    }
                });
              
              config.createStements("select voiceSynthesiserState from VoiceSynthesiserEvent")
                .setSubscriber(new Object() {
                    public void update(Boolean state) throws InterruptedException {
                        voice.setVoiceSynthesiserState(state);
//                        System.out.println("calling police "+state);
                       
                    }
                });
              config.createStements("select voltageState from voltageDrop")
                .setSubscriber(new Object() {
                    public void update(Boolean state) throws InterruptedException {
                         monitor.setVoltageDrop(state);
                         backupBattery.setVoltageState(state);
                         mainPower.setVoltageState(state);
                      
                    }
                });
              
              config.createStements("select state from clearState")
                .setSubscriber(new Object() {
                    public void update(Boolean state) throws InterruptedException {
                     
                          clear.setClearState(state);
                    }
                });
              
              config.createStements("select panicState from panicState")
                .setSubscriber(new Object() {
                    public void update(Boolean state) throws InterruptedException {
                     
                        panic.setPanicState(state);
                    }
                });
               
                 

//config.sendEvent(new voltageDrop(true));


       alarmThread.start();
      sensorThread.start();
      lightSwitcherThread.start();
      VoiceSynthesiserThread.start();
      ThreadCiruitMonitor.start();
//      ThreadCiruitMonitor.join();
      backupBatteryThread.start();
      mainPowerThread.start();
      clearThread.start();
      panicThread.start();
      
      
//      config.sendEvent(new VoiceSynthesiserEvent(true)); 
//        config.sendEvent(new alarmEvent(true));
        int delay =5000; 
     Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delay);
                        config.sendEvent(new intruderState(true));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
            thread.start();
    

       
    }
        
    
    
}
