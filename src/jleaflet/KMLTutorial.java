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

import LeafletObjects.KMLLayer;

/**
 *
 * @author Thomas Zastrow
 */
public class KMLTutorial {
    public static void main (String[] args){
        JLMap m = new JLMap();
        m.setTitle("My title");
        m.setMapStyle("height:50%;");
        m.setLeafletString("http://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.3/leaflet.js");
        m.setLeafletStylesheet("http://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.3/leaflet.css");
        m.setKmlScript("http://www.thomas-zastrow.de/js/leaflet/KML.js");
        
        m.setMapId("thomaszastrow.0561f39d");
        m.setAccessToken("pk.eyJ1IjoidGhvbWFzemFzdHJvdyIsImEiOiJjYzdiYzNiOGY4NTIwNjUxMDhmYzZkMDg0ZTYyYzlhOCJ9.uI9t241xeKYukX3EPOgKLw");
        
        m.setZoomLevel(13);
         
        KMLLayer kml = new KMLLayer("/media/windows/a-daten/kreativ/kreativ/HandySicherung/MyTracks/kml/23_12_2013 13_58.kml");  
        kml.setPopup("KML Popup");
        m.addObject(kml);                        
        System.out.println(m.toString());
    }
    
}
