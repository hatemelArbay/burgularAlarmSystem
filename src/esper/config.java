/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import events.VoiceSynthesiserEvent;
import events.alarmEvent;
import events.clearState;
import events.intruderState;
import events.lightState;
import events.panicState;
import events.voltageDrop;

/**
 *
 * @author hatem
 */
public class config {
       private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();
    
       public static void registerEvent(){
              engine.getEPAdministrator().getConfiguration().addEventType(alarmEvent.class);
              engine.getEPAdministrator().getConfiguration().addEventType(lightState.class);
              engine.getEPAdministrator().getConfiguration().addEventType(intruderState.class);
              engine.getEPAdministrator().getConfiguration().addEventType(VoiceSynthesiserEvent.class);
              engine.getEPAdministrator().getConfiguration().addEventType(voltageDrop.class);
              engine.getEPAdministrator().getConfiguration().addEventType(clearState.class);
              engine.getEPAdministrator().getConfiguration().addEventType(panicState.class);
       }
       
       public static EPStatement createStements(String statement ){
       EPStatement result = engine.getEPAdministrator().createEPL(statement);
          
           System.out.println("statemetns created succesfully ! ");
       return result;
       }
       
       public static void sendEvent(Object o ){
       engine.getEPRuntime().sendEvent(o);
       }
       
}
