/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaintProject;

import java.awt.Color;

/**
 *
 * @author Mai Ashraf
 */
public class GeoShape {
    
    int x1, y1, x2, y2;
    char currentShape;
    boolean dotted;
    boolean filled;
    Color color;
    
    public GeoShape(int x1, int y1, int x2, int y2, char currentShape, boolean dotted, boolean filled, Color color){
		
        this.x1 = x1;
	this.y1 = y1;
	this.x2 = x2;
	this.y2 = y2;
	this.currentShape = currentShape;
	this.dotted = dotted;
	this.filled = filled;

	if(currentShape == 'e')
            this.color = Color.WHITE;
	else
            this.color= color;
    }
    
    public GeoShape(int x1, int y1, int x2, int y2, char currentShape, boolean dotted, Color color){
		
	this.x1 = x1;
	this.y1 = y1;
	this.x2 = x2;
	this.y2 = y2;
	this.currentShape = currentShape;
	this.dotted = dotted;
	this.color = color;
                        
        if(currentShape == 'e')
            this.color = Color.WHITE;
	else
            this.color = color;
}
    
    public void setX1(int x1){
	this.x1 = x1;
    }
    
    public void setY1(int y1){
	this.y1 = y1;
    }
    
    public void setX2(int x2){
	this.x2 = x2;
    }
    
    public void setY2(int y2){
	this.y2 = y2;
    }
    
    public void setShape(char c){
	currentShape = c;
    }
    
    boolean isFilled(){
	return filled;
    }
    
    boolean getDottedState(){
	return this.dotted;
    }
    
    char getShape(){
	return currentShape;
    }

    int getX1(){
	return x1;
    }
    
    int getY1(){
	return y1;
    }
    
    int getX2(){
	return x2;
    }
    
    int getY2(){
	return y2;
    }
    
    public Color getColor(){
	return color;
    }	

    private Color getBackground() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
}
