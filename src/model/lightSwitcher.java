/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hatem
 */
public class lightSwitcher implements Runnable{
    
    private String lightSwitcherId; 
    private boolean lightState; 
    private gps location;
    private screen output;

    public lightSwitcher(String lightSwitcherId, gps location) {
        this.lightSwitcherId = lightSwitcherId;
        this.location = location;
        output=screen.getInstance();
    }

    public void setLightState(boolean lightState){
    this.lightState=lightState;
    }
    
    
    @Override
    public void run() {
        try{
     while(true){
         if(lightState){
         System.out.println("WARNING : ");
//         System.out.println("lights is turned on in location : "+location.detectLocation());
         output.setLightsState("lights is turned on in location : "+location.detectLocation());
         Thread.sleep(2000);
         }else {
            output.setLightsState("lights is turned OFF");
         }
    }
    }catch(Exception err){System.out.println("error");}
        
    }
}
