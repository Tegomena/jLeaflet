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

import LeafletObjects.LeafletObject;
import LeafletObjects.Coordinates;
import util.Functions;
/**
 *
 * @author Thomas Zastrow
 */
public class Marker implements LeafletObject{
    private Coordinates co;
    private String popup;
    private String name;

    public Marker(Coordinates co) {
        this.co = co;
        this.popup = "";
        this.name = Functions.randomName();
    }

    public String getPopup() {
        return popup;
    }

    public void setPopup(String popup) {
        this.popup = popup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    @Override
    public String toString() {
        String result = "var " + name + " = L.marker([" + co.getLatitude() + ", " + co.getLongitude() + "]).addTo(map);\n";
        if(!popup.equals("")){
            result = result + name + ".bindPopup(\"" + popup + "\").openPopup();\n";            
        }
        return result;
    }
    
}
