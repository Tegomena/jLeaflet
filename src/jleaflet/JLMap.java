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

import LeafletObjects.LeafletObject;
import LeafletObjects.Coordinates;
import java.util.ArrayList;

/**
 *
 * @author Thomas Zastrow
 */
public class JLMap {

    private String title;
    private String leafletStylesheet;
    private String leafletScript;
    private String kmlScript;

    private String mapDivStyle;
    private Coordinates mapCenter;
    private int zoomLevel;

    private String mapId;
    private String accessToken;
    private String mapStyle;
    
    private String tileLayer;

    private ArrayList<LeafletObject> objects;

    private String template = "<html>\n"
            + "<head>\n"
            + "<title>$title$</title>\n"
            + "<link rel=\"stylesheet\" href=\"$leafletstylesheet$\" />\n"
            + "<script src=\"$leafletString$\"></script>     \n"
            + "<script src=\"$kmlscript$\"></script>\n"
            + "</head>\n"
            + "<body>\n"
            + "<div id=\"map\" style=\"$mapstyle$\"></div>\n"
            + "<script>\n"
            + "var map = L.map('map').setView([$latitude$, $longitude$], $zoomlevel$);\n"
            + "  \n"
            + "L.tileLayer('$tilelayer$', {\n"
            + "    attribution: 'Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, <a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',\n"
            + "    maxZoom: 18,\n"
            + "    id: '$mapid$',\n"
            + "    accessToken: '$accesstoken$'\n"
            + "}).addTo(map);\n"
           
            + "$objects$\n"
            + "</script>\n"
            + "</body>\n"
            + "</html>";

    public JLMap() {
        this.objects = new ArrayList<LeafletObject>();
        this.title = "";
        this.mapStyle = "";
        this.tileLayer = "https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}";
    }

    public void addObject(LeafletObject lo) {
        this.objects.add(lo);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTileLayer() {
        return tileLayer;
    }

    public void setTileLayer(String tileLayer) {
        this.tileLayer = tileLayer;
    }
    
    

    public Coordinates getMapCenter() {
        return mapCenter;
    }

    public void setMapCenter(Coordinates mapCenter) {
        this.mapCenter = mapCenter;
    }

    public int getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(int zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public String getLeafletStylesheet() {
        return leafletStylesheet;
    }

    public void setLeafletStylesheet(String leafletStylesheet) {
        this.leafletStylesheet = leafletStylesheet;
    }

    public String getLeafletString() {
        return leafletScript;
    }

    public void setLeafletString(String leafletString) {
        this.leafletScript = leafletString;
    }

    public String getKmlScript() {
        return kmlScript;
    }

    public void setKmlScript(String kmlScript) {
        this.kmlScript = kmlScript;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getMapStyle() {
        return mapStyle;
    }

    public void setMapStyle(String mapStyle) {
        this.mapStyle = mapStyle;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for (LeafletObject lo : this.objects) {
            sb.append(lo.toString());
            sb.append("\n");
        }
        
        this.template = this.template.replace("$objects$", sb.toString());
        this.template = this.template.replace("$title$", this.title);
        this.template = this.template.replace("$tilelayer$", this.tileLayer);
        this.template = this.template.replace("$mapstyle$", this.mapStyle);
        this.template = this.template.replace("$leafletstylesheet$", this.leafletStylesheet);
        this.template = this.template.replace("$leafletString$", this.leafletScript);
        this.template = this.template.replace("$kmlscript$", this.kmlScript);
        if(this.mapCenter != null){
        this.template = this.template.replace("$latitude$", this.mapCenter.getLatitude().toString());
        this.template = this.template.replace("$longitude$", this.mapCenter.getLongitude().toString());
        } else {
              this.template = this.template.replace("$latitude$", "0");
        this.template = this.template.replace("$longitude$", "0"); 
        }
        this.template = this.template.replace("$zoomlevel$", Integer.toString(this.zoomLevel));

        this.template = this.template.replace("$mapid$", this.mapId);
        this.template = this.template.replace("$accesstoken$", this.accessToken);
        return template;

    }
}
