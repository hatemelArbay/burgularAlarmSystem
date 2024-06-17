package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import view.screengui;
import esper.config;
import events.clearState;
import events.panicState;

public class screen{
    private static screen instance;
    private screengui gui;
    private String anomaly;
    
    private screen() {
        gui = new screengui();
        gui.setVisible(true);
         gui.getClearButton().addActionListener(e->sendClearEvent());
         gui.getPanicButton().addActionListener(e->sendPanicEvent());
    }
    
    public static screen getInstance() {
        if (instance == null) {
           
                if (instance == null) {
                    instance = new screen();
                }
            
        }
        return instance;
    }
    
    public void displayAnomalies(String anomaly) {
        gui.getjTextArea1().setText(anomaly);
    }
    
    public void setAnomaly(String anomaly) {
        this.anomaly = anomaly;
    }
    
    public void setalarmState(String alarm){
    
    gui.getAlarmTextField().setText(alarm);
    }
    
    public void setLightsState(String lightState){
    gui.getLightField().setText(lightState);
    }
    
    public void setVoiceSynthesizerStatus(String status) {
//        gui.getSynthenizerField.setText("");
        gui.getSynthenizerField().setText(status);
    }
    public void displayVoltage(String volt){
    gui.getVoltageTextField().setText(volt);
    }
    
    public void displayPowerSource(String powersrc){
    gui.getPowerSource().setText(powersrc);
    
    
    }

    private void sendClearEvent(){
        config.sendEvent(new clearState(true));
    
    }
    private void sendPanicEvent(){
       config.sendEvent(new panicState(true));
    }
  
    
    
    
}
