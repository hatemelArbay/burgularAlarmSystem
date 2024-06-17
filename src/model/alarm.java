package model;

import esper.config;
import events.VoiceSynthesiserEvent;
import events.alarmEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class alarm implements Runnable {
    private String alarmId;
    private boolean alarmState;
    private screen output;
    private VoiceSynthesiser voice;
    private Clip clip;

    public alarm(String alarmId) throws LineUnavailableException {
        this.alarmId = alarmId;
        alarmState = false;
        output= screen.getInstance();
        voice= VoiceSynthesiser.getInstance("VS-1");
        clip=AudioSystem.getClip();
        
    }

    public void setAlarmState(boolean alarmState) {
        this.alarmState = alarmState;
        System.out.println("Alarm is set to " + this.alarmState);
    }

    @Override
    public void run() {
//             try {
            while (true) {
//                   Thread.sleep(500);
                    if (alarmState) {
                   output.setalarmState("BEEP");
                   playSound();
                       config.sendEvent(new VoiceSynthesiserEvent(true));//testing 
                   
//                                                   voice.callLocalPolice(location);

                    }
                    else {
                      output.setalarmState("sleeping...");
//                        config.sendEvent(new VoiceSynthesiserEvent(false));
                        pauseSound();

                    }
                    
                
            }
//              } catch (InterruptedException ex) {
//                            Logger.getLogger(alarm.class.getName()).log(Level.SEVERE, null, ex);
//                        }
       
           
    }

    public VoiceSynthesiser getVoice() {
        return voice;
    }
    
     public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("mixkit-classic-alarm-995.wav"));

            
            
           
            clip.open(audioInputStream);
            
            
            clip.start();
            
            
            while (!clip.isRunning())
                Thread.sleep(10);
            while (clip.isRunning())
                Thread.sleep(10);
            
           
            clip.close();
            audioInputStream.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

     }
     private void pauseSound() {
        if ( clip!= null && clip.isRunning()) {
            clip.stop(); 
        }
    }
    
    
}
