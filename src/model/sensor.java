/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.VoiceSynthesiserEvent;
import events.lightState;

/**
 *
 * @author hatem
 */
public class sensor implements Runnable {
    private String sensorId ; 
    private String sensorType ;
    private gps location  ;
    private boolean intruderState;
    private  VoiceSynthesiser voice;
    private screen output;

    public sensor(String sensorId, String sensorType, gps location) {
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.location = location;
        voice = VoiceSynthesiser.getInstance("vc1");
        output= screen.getInstance();
        
    }
    
    public void setSensorState(boolean intruderState){
    this.intruderState=intruderState;
    }
    
    
    @Override
    public void run() {
    
        try{
        while (true){
            Thread.sleep(3000);
//            
            if(intruderState){
                  config.sendEvent(new lightState(true));
                  config.sendEvent(new VoiceSynthesiserEvent(true));
                  voice.callLocalPolice(location);
                  output.displayAnomalies("intruder detected !!!");
            }else{
                System.out.println("seeting voice to false in sensor");
                  config.sendEvent(new VoiceSynthesiserEvent(false));
             output.displayAnomalies("The house is safe ...");
             output.setVoiceSynthesizerStatus("sleeping...");
            }
        }
        }catch(Exception err){
            System.out.println("error ");
        }
    }
    
    
    
     
    
    
    
    
    
    
    
    
    
}
