package PaintProject;

import java.awt.Color;
import java.applet.Applet;
import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.awt.Stroke; 
import java.awt.BasicStroke;
import java.awt.Checkbox;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.control.CheckBox;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;



public class PaintProject extends Applet {
    
	int x1, y1, x2, y2, x, y;
        Graphics g;
	Vector <GeoShape> vector = new Vector <GeoShape>();
	int j=0;
	boolean dotted = false;
	boolean filled = false;
	boolean undo = false;
        Color currentColor;
	char currentShape;
	int counter;
        
	Button Line = new Button("Line");
	Button Rectangle = new Button("Rectangle");
	Button Oval = new Button("Oval");
	Button Red = new Button("Red");
	Button Green = new Button("Green");
	Button Blue = new Button("blue");
        Button Yellow = new Button("Yellow");
        Button Orange = new Button("Orange");
        Button Black = new Button("Black");
	Button FreeHand = new Button("Free Hand");
	Button Eraser = new Button("Eraser");
	Button Clear = new Button("Clear All");
        Button Undo = new Button("Undo");
        //Button Save = new Button("Save");
	Checkbox Filled = new Checkbox("filled");
        Checkbox Dotted = new Checkbox("Dotted");
	
        @Override
	public void init(){
            
        //SHAPES buttons
                
            Line.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){	
			currentShape = 'l';
                    }
                }
            );
	
            Rectangle.addActionListener(new ActionListener(){
                @Override
		public void actionPerformed(ActionEvent e){
			currentShape = 'r';
                    }   
                }
            );
		
            Oval.addActionListener(new ActionListener(){
                @Override
		public void actionPerformed(ActionEvent e){
			currentShape = 'o';
                    }
                }
            );
//-------------------------------------------------------------------------------------------                
        //COLORS buttons 
                
            Black.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    currentColor = Color.black;
                    }
                }
            );

            Orange.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    currentColor = Color.orange;
                    }
                }
            );

            Yellow.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    currentColor = Color.yellow;
                    }
                }
            );

            Red.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    currentColor = Color.red;
                    }
                }
            );

            Blue.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    currentColor = Color.blue;
                    }
                }
            );

            Green.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    currentColor = Color.green;		
                    }
                }
            );

//-------------------------------------------------------------------------------------------
        //TOOLS buttons
         
            FreeHand.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    currentShape = 'f';		
                    }
                }
            );

            Eraser.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    currentShape = 'e';
                    }
                }
            );

            Clear.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    currentShape = 'c';
                    repaint();
                    }
                }
            );     

            Undo.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    currentShape = 'u';
                    repaint();
                    }
                }
            );
            
            /*Save.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    JFileChooser j = new JFileChooser("d:", FileSystemView.getFileSystemView());
                    j.showSaveDialog(null);
                    try{
                        BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                        //int returnVal = j.showSaveDialog(Save);
                        //File file = new File("PaintScreen.jpg");
                        if(returnVal == JFileChooser.APPROVE_OPTION)
                            {
                                File   file = j.getSelectedFile();
                            }
                       
                        ImageIO.write(screencapture, "jpg", file);

                        }catch(Exception ex) {} JOptionPane.showMessageDialog(Save,"Image saved successfully");
                    }
                }
            );*/
                 
//-------------------------------------------------------------------------------------------------                 
        // CHECKBOXES
        
            Filled.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange() == 1){
                        filled = true;
                        }
                    else{
                       filled = false;
                        }
                    }
                }
            );
        
            Dotted.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange() == 1){
                        dotted = true;
                    }
                    else{
                            dotted = false;
                        }
                    }
                }
            );      
       
        Black.setForeground(Color.WHITE);
        Black.setBackground(Color.BLACK);
        Red.setBackground(Color.RED);
        Blue.setBackground(Color.BLUE);
        Green.setBackground(Color.GREEN);
        Yellow.setBackground(Color.YELLOW);
        Orange.setBackground(Color.ORANGE);   
        
        add(Green);
        add(Blue);
        add(Red);
        add(Yellow);
        add(Orange);
        add(Black);
        add(Line);
        add(Rectangle);
        add(Oval);
        add(FreeHand);
        add(Eraser);
        add(Undo);
        //add(Save);
        add(Clear);
        add(Dotted);       
        add(Filled);
        
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseMotionListener());
    } //end of init
        
//_________________________________________________________________________________________________
//_________________________________________________________________________________________________
        
    //paint method        
        
    @Override
    public void paint(Graphics g){
    
        float[] dash = {10,10,10};
        Graphics2D g2d = (Graphics2D) g.create();
   
        //clear the vector when pressing clear all
        if(currentShape == 'c'){
            vector.clear(); 
        }
        
        //undo
        if(currentShape == 'u'){
            vector.removeElementAt(vector.size()-1); 
        }
			
			
        //draw existed shapes
        for (j=0; j< vector.size(); j++){
            
            g.setColor(vector.get(j).getColor());

            switch(vector.get(j).getShape()){
                
                case 'l':
                {
                    //to Draw dashed line if dotted checkbox is checked
                    g2d.setColor(vector.get(j).getColor());
                    if(vector.get(j).getDottedState())
                        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,10,dash,10 ));
                    else
                        g2d.setStroke(new BasicStroke(0));

                    g2d.drawLine(vector.get(j).getX1(), vector.get(j).getY1(),vector.get(j).getX2(), vector.get(j).getY2());   
                }  
                break;
                
                case 'r':
                {
                    //draw rectangle
                    g.drawRect(vector.get(j).getX1(), vector.get(j).getY1(),vector.get(j).getX2(), vector.get(j).getY2());
                    if(vector.get(j).isFilled())
                        g.fillRect(vector.get(j).getX1(), vector.get(j).getY1(),vector.get(j).getX2(), vector.get(j).getY2()); 
                }
                break;

                case 'o':
                {
                    //draw oval  
                    g.drawOval(vector.get(j).getX1(), vector.get(j).getY1(),vector.get(j).getX2(), vector.get(j).getY2());	
                    if(vector.get(j).isFilled())
                        g.fillOval(vector.get(j).getX1(), vector.get(j).getY1(),vector.get(j).getX2(), vector.get(j).getY2()); 
                }
                break;
                
                case 'e':
                {
                    //Eraser
                    g.setColor(Color.WHITE);
                    g.fillRect(vector.get(j).getX1(), vector.get(j).getY1(),15,15);
                }  
    
            }

        }//end of for loop that was drawing previous elements


        //drawing current drawing shape

        switch(currentShape){

            case 'e':
            {
                g.setColor(getBackground());
                g.fillRect(x2, y2, 15, 15);
            }
            break;

            case 'l':
            { 
                g2d.setColor(currentColor);
                if(dotted)
                    g2d.setStroke(new BasicStroke(0, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,10,dash,10));
                g2d.drawLine( x1, y1, x2, y2);               
            }
            break;

            case 'r':
            {
                if(filled){
                    g.setColor(currentColor);
                    g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1),Math.abs(y2-y1));
                }
                else
                    g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1),Math.abs(y2-y1));
            }
            break;
            
            case 'o':
            {    
                if(filled){
                    g.setColor(currentColor);
                    g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1),Math.abs(y2-y1));
                }
                else
                    g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1),Math.abs(y2-y1));    
            } 
            break;
            
            case 'f':
            {        
                g.setColor(currentColor);  
                g.drawLine( x1, y1,x2, y2);            
            }
            break;
        }
    }
    
    
//----------------------------------------------------------------------------------------------------------
    
    class MyMouseListener implements MouseListener{
        
            @Override
            public void mousePressed(MouseEvent e){
                x1 = x2 = e.getX();
                y1 = y2 = e.getY();
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {

            }
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e)  {

            }

            @Override
            public void mouseReleased(MouseEvent e)  {
                
                x2 = e.getX();
                y2 = e.getY();

                switch(currentShape){

                    case 'l':
                    {
                        vector.add(new Line(x1, y1, x2, y2, 'l',dotted, currentColor));
                    }
                    break;

                    case 'r':
                    {
                        vector.add(new Rect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1),Math.abs(y2-y1), 'r',dotted,filled,currentColor));
                    }
                    break;

                    case 'o':
                    {
                        vector.add(new Oval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1),Math.abs(y2-y1), 'o',dotted,filled,currentColor));
                    }
                    break;

                }
            
        repaint();
        }
    }

	
    class MyMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseMoved(MouseEvent e) {
            }

        @Override
        public void mouseDragged(MouseEvent e) {
            
            x2 = e.getX();
            y2 = e.getY();
            
            switch(currentShape){

                case 'e':
                {
                    vector.add(new Rect( x2, y2,7, 7, 'e',dotted, filled,currentColor));
                }
                break;
                
                case 'f':
                {
                    vector.add(new Line(x1, y1, x2, y2, 'l',  dotted,currentColor));
                    x1 = x2;
                    y1 = y2;
                }
                break;

            }
            repaint();
        }
    }
}