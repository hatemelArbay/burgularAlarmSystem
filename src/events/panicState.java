/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author YoussefNaeim
 */
public class panicState {
    public boolean panicState;

    public panicState(boolean panicState) {
        this.panicState = panicState;
    }
    public panicState(){
    this.panicState=false;
    }

    public boolean isPanicState() {
        return panicState;
    }


}
