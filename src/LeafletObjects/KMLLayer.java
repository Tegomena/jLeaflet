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
package LeafletObjects;

/**
 *
 * @author Thomas Zastrow
 */
public class KMLLayer implements LeafletObject {

    private String name;
    private String filename;
    private String popup;

    public KMLLayer(String filename) {
        this.filename = filename;
        this.name = util.Functions.randomName();
        this.popup = "";
    }

    public String getName() {
        return name;
    }

    public String getPopup() {
        return popup;
    }

    public void setPopup(String popup) {
        this.popup = popup;
    }
    
    @Override
    public String toString() {
        String toReturn = "var kmlLayer = new L.KML(\"" + this.filename + "\", {async: true});                                                              \n"
                + "kmlLayer.on(\"loaded\", function(e) { \n"
                + "map.fitBounds(e.target.getBounds());\n"
                + "});\n"
                + "map.addLayer(kmlLayer);\n";
        
        if(!popup.equals("")){
            toReturn = toReturn + name + ".bindPopup(\"" + popup + "\").openPopup();\n";            
        }
        return toReturn;
    }

}
