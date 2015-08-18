/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jleaflet;

/**
 *
 * @author tom
 */
public class Jleaflet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //http://www.thomas-zastrow.de/js/leaflet/leaflet.css
        //http://www.thomas-zastrow.de/js/leaflet/leaflet.js
        //http://www.thomas-zastrow.de/js/leaflet/KML.js
        //thomaszastrow.0561f39d
        //pk.eyJ1IjoidGhvbWFzemFzdHJvdyIsImEiOiJjYzdiYzNiOGY4NTIwNjUxMDhmYzZkMDg0ZTYyYzlhOCJ9.uI9t241xeKYukX3EPOgKLw
        
        Map m = new Map();
        m.setTitle("MEIN TITEL");
        m.setLeafletString("http://www.thomas-zastrow.de/js/leaflet/leaflet.js");
        m.setLeafletStylesheet("http://www.thomas-zastrow.de/js/leaflet/leaflet.css");
        m.setKmlScript("http://www.thomas-zastrow.de/js/leaflet/KML.js");
        
        m.setMapId("thomaszastrow.0561f39d");
        m.setAccessToken("pk.eyJ1IjoidGhvbWFzemFzdHJvdyIsImEiOiJjYzdiYzNiOGY4NTIwNjUxMDhmYzZkMDg0ZTYyYzlhOCJ9.uI9t241xeKYukX3EPOgKLw");
        
        Coordinates center = new Coordinates(51.505, -0.09);
        m.setMapCenter(center);
        
        KMLLayer kml = new KMLLayer("garching.kml");        
        m.addObject(kml);                        
        System.out.println(m.toString());
    }
    
}
