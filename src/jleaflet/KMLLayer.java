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
public class KMLLayer implements LeafletObject {

    private String filename;

    public KMLLayer(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        String toReturn = "var kmlLayer = new L.KML(\"" + this.filename + "\", {async: true});                                                              \n"
                + "kmlLayer.on(\"loaded\", function(e) { \n"
                + "map.fitBounds(e.target.getBounds());\n"
                + "});\n"
                + "map.addLayer(kmlLayer);";
        return toReturn;
    }

}
