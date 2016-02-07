/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eby.helper;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.scene.paint.Paint;

/**
 *
 * @author eby
 */
public class MaterialButtonIcon {
    public static MaterialDesignIconView icon(MaterialDesignIconView icon, String size){
        icon.setSize(size);
        icon.setSmooth(true);
        icon.setLineSpacing(20);
        return icon;
    }
}
