/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jleaflet;

import java.util.ArrayList;

/**
 *
 * @author tom
 */
public class Map {

    private String title;
    private String leafletStylesheet;
    private String leafletString;
    private String kmlScript;

    private String mapDivStyle;
    private Coordinates mapCenter;
    private int zoomLevel;

    private String mapId;
    private String accessToken;

    private ArrayList<LeafletObject> objects;

    private String template = "<html>\n"
            + "<head>\n"
            + "<title>$title$</title>\n"
            + "<link rel=\"stylesheet\" href=\"$leafletstylesheet$\" />\n"
            + "<script src=\"$leafletString$\"></script>     \n"
            + "<script src=\"$kmlscript$\"></script>\n"
            + "</head>\n"
            + "<body>\n"
            + "<div id=\"map\" style=\"height:100%;\"></div>\n"
            + "<script>\n"
            + "var map = L.map('map').setView([$latitude$, $longitude$], $zoomlevel$);\n"
            + "  \n"
            + "L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {\n"
            + "    attribution: 'Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, <a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',\n"
            + "    maxZoom: 18,\n"
            + "    id: '$mapid$',\n"
            + "    accessToken: '$accesstoken$'\n"
            + "}).addTo(map);\n"
            + "var marker = L.marker([48.25371, 11.64688]).addTo(map);\n"
            + "$objects$\n"
            + "</script>\n"
            + "</body>\n"
            + "</html>";

    public Map() {
        this.objects = new ArrayList<LeafletObject>();
        this.title = "";
    }

    public void addObject(LeafletObject lo) {
        this.objects.add(lo);
    }

    public void setTitle(String title) {
        this.title = title;
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
        return leafletString;
    }

    public void setLeafletString(String leafletString) {
        this.leafletString = leafletString;
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
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for (LeafletObject lo : this.objects) {
            sb.append(lo.toString());
            sb.append("\n");
        }

        this.template = this.template.replace("$objects$", sb.toString());
        this.template = this.template.replace("$title$", this.title);
        this.template = this.template.replace("$leafletstylesheet$", this.leafletStylesheet);
        this.template = this.template.replace("$leafletString$", this.leafletString);
        this.template = this.template.replace("$kmlscript$", this.kmlScript);
        this.template = this.template.replace("$latitude$", this.mapCenter.getLatitude().toString());
        this.template = this.template.replace("$longitude$", this.mapCenter.getLongitude().toString());
        this.template = this.template.replace("$zoomlevel$", Integer.toString(this.zoomLevel));

        this.template = this.template.replace("$mapid$", this.mapId);
        this.template = this.template.replace("$accesstoken$", this.accessToken);
        return template;

    }
}
