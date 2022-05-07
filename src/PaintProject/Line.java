/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaintProject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Stroke;

/**
 *
 * @author Mai Ashraf
 */
public class Line extends GeoShape {
    

    public Line(int x1,int y1, int x2,int y2, char currentShape,  boolean dotted,Color color){
	super(x1, y1, x2, y2, currentShape, dotted,color);
    }
}
