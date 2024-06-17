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
public class voltageDrop {
    public boolean voltageState;

    public voltageDrop(boolean VoltageState) {
        this.voltageState = VoltageState;
    }

    public boolean isVoltageState() {
        return voltageState;
    }
    
}
