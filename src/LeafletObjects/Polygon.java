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

import java.util.ArrayList;

/**
 *
 * @author Thomas Zastrow
 */
public class Polygon implements LeafletObject {

    private ArrayList<Coordinates> points;
    private String name;
    private String popup;

    public Polygon() {
        this.points = new ArrayList<Coordinates>();
        this.name = util.Functions.randomName();

    }

    public String getName() {
        return name;
    }

    public void addPoint(Coordinates coo) {
        points.add(coo);
    }

    public String getPopup() {
        return popup;
    }

    public void setPopup(String popup) {
        this.popup = popup;
    }

    @Override
    public String toString() {
        String result = "var " + name + " = L.polygon([\n";
        for (Coordinates coo : points) {
            result = result + "[" + coo.getLatitude() + ", " + coo.getLongitude() + "], \n";
        }
        result = result + "]).addTo(map);\n";

        if (!popup.equals("")) {
            result = result + name + ".bindPopup(\"" + popup + "\");\n";
        }

        return result;
    }

}
