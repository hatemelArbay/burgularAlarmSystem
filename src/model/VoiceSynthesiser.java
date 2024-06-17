/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.VoiceSynthesiserEvent;
import events.alarmEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hatem
 */
public class VoiceSynthesiser implements Runnable {
    private String VoiceSynthesiserId ;
    private boolean state;
     private static VoiceSynthesiser instance;
     private  screen output; 
 
    
    private VoiceSynthesiser(String VoiceSynthesiserId) {
        this.VoiceSynthesiserId = VoiceSynthesiserId;
        output = screen.getInstance();
        
    }
    
    public static VoiceSynthesiser getInstance(String voiceSynthesiserId) {
        if (instance == null) {
        
            instance = new VoiceSynthesiser(voiceSynthesiserId);
        }
        return instance;
    }

    
  
    
    public void setVoiceSynthesiserState(boolean state){
        System.out.println("voice sensthesiser state : "+state);
    this.state=state;

  
    }
    
    @Override
    public void run() {
        while (true) {
            if (state==false) {
                try {
                       
                        output.setVoiceSynthesizerStatus("sleeping");
                          Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VoiceSynthesiser.class.getName()).log(Level.SEVERE, null, ex);
                }
        
            }
            }
            }
        
    

    
    

    
    public void callLocalPolice(gps location){
    
         if(state){
            output.setVoiceSynthesizerStatus("calling local police to location : "+location.detectLocation());
              config.sendEvent(new alarmEvent(true));
              
//              config.sendEvent(new VoiceSynthesiserEvent(false));
            }
         else{
                 output.setVoiceSynthesizerStatus("sleepinggggg");
         }
        }
    
    
    
    public void callTechnical(gps location ){
//        if(state){
            System.out.println("calling technition");
            output.setVoiceSynthesizerStatus("calling technical to location : "+location.detectLocation()); 
        
    }
//         else{
//                 output.setVoiceSynthesizerStatus("sleepingtttt");
//         }
        }
    
    


      
//    public void callLocalPolice(gps location){
//         if(state){
//            output.setVoiceSynthesizerStatus("calling local police to location : "+location.detectLocation());
//              config.sendEvent(new alarmEvent(true));
//              
////              config.sendEvent(new VoiceSynthesiserEvent(false));
//            }
//         else{
//                 output.setVoiceSynthesizerStatus("sleeping");
//         }
//        }
    

    
    

    
    
