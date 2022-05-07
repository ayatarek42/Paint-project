/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaintProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;

/**
 *
 * @author Mai Ashraf
 */
public class Rect extends GeoShape {
    
   public Rect(int x1,int y1, int x2,int y2, char currentShape,boolean dotted,boolean filled,Color color){
	super(x1, y1, x2, y2, currentShape, dotted, filled,color);
    }
}