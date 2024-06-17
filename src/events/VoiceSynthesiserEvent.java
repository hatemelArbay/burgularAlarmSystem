/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author hatem
 */
public class VoiceSynthesiserEvent {
    
    public boolean voiceSynthesiserState;

    public VoiceSynthesiserEvent(boolean VoiceSynthesiserState) {
        this.voiceSynthesiserState = VoiceSynthesiserState;
    }

    public boolean isVoiceSynthesiserState() {
        return voiceSynthesiserState;
    }



    
}
