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
public class gps {
    
    private String gpsId; 
    private String roomlocation ;
    private String homeLocation; 

    public gps() {
    
    
    }

    public gps(String gpsId, String roomlocation, String homeLocation) {
        this.gpsId = gpsId;
        this.roomlocation = roomlocation;
        this.homeLocation = homeLocation;
    }
    
      
    
    public String detectLocation(){
        return (homeLocation+" "+roomlocation);
    }
    
    
    
     public void setGpsId(String gpsId) {
        this.gpsId = gpsId;
    }

    public void setRoomlocation(String roomlocation) {
        this.roomlocation = roomlocation;
    }

    public void setHomeLocation(String homeLocation) {
        this.homeLocation = homeLocation;
    }
    
    


 
    
    
    
}
