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
public class Circle implements LeafletObject {

    private String name;
    private String popup;
    private Coordinates center;
    private int radius;
    private String color;
    private String fillColor;
    private double fillOpacity;

    public Circle(Coordinates center, int radius, String color, String fillColor, double fillOpacity) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.fillColor = fillColor;
        this.fillOpacity = fillOpacity;
        this.name = util.Functions.randomName();
        this.popup = "";
    }

    public String getName() {
        return name;
    }

    public Coordinates getCenter() {
        return center;
    }

    public void setCenter(Coordinates center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public double getFillOpacity() {
        return fillOpacity;
    }

    public void setFillOpacity(double fillOpacity) {
        this.fillOpacity = fillOpacity;
    }

    public String getPopup() {
        return popup;
    }

    public void setPopup(String popup) {
        this.popup = popup;
    }
    
    

    @Override
    public String toString() {
        String result = "var " + name + " = L.circle([" + this.center.getLatitude() + ", " + this.center.getLongitude() + "], ";
        result = result + Integer.toString(radius) + ", {\n";
        result = result + "color: '" + color + "',\n";
        result = result + "fillColor: '" + fillColor + "',\n";
        result = result + "fillOpacity: '" + fillOpacity + "'\n";
        result = result + "}).addTo(map);\n";
        
         if(!popup.equals("")){
            result = result + name + ".bindPopup(\"" + popup + "\");\n";            
        }
        return result;
    }
}
