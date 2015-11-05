/*
 * Copyright (C) 2015 Thomas Zastrow
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package jleaflet;

import LeafletObjects.Circle;
import LeafletObjects.Marker;
import LeafletObjects.Coordinates;
import LeafletObjects.Polygon;

/**
 *
 * @author Thomas Zastrow
 */
public class BasicTutorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JLMap m = new JLMap();
        m.setTitle("My title");
        m.setMapStyle("height:50%;");
        m.setLeafletString("http://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.3/leaflet.js");
        m.setLeafletStylesheet("http://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.3/leaflet.css");
        m.setKmlScript("http://www.thomas-zastrow.de/js/leaflet/KML.js");
        
        m.setMapId("thomaszastrow.0561f39d");
        m.setAccessToken("pk.eyJ1IjoidGhvbWFzemFzdHJvdyIsImEiOiJjYzdiYzNiOGY4NTIwNjUxMDhmYzZkMDg0ZTYyYzlhOCJ9.uI9t241xeKYukX3EPOgKLw");
        
        Coordinates center = new Coordinates(51.505, -0.09);
        m.setMapCenter(center);
        m.setZoomLevel(13);
        
        Coordinates markerCoo = new Coordinates(51.5, -0.09);
        Marker marker = new Marker(markerCoo);
        marker.setPopup("I'm the markers popup!");
        m.addObject(marker);
        
        Coordinates cirCoo = new Coordinates(51.508, -0.11);
        Circle ci = new Circle(cirCoo, 500, "red", "#f03", 0.5);
        ci.setPopup("Circles popup");
        m.addObject(ci);
        
        Polygon poly = new Polygon();
        poly.addPoint(new Coordinates(51.509, -0.08));
        poly.addPoint(new Coordinates(51.503, -0.06));
        poly.addPoint(new Coordinates(51.51, -0.047));
        poly.setPopup("Polygon! Polygon!");
        m.addObject(poly);   
                              
        System.out.println(m.toString());
    }
    
}
