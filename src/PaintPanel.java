import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PaintPanel extends JPanel implements MouseMotionListener, MouseListener 
{
    private static BufferedImage img;
    private static BufferedImage canvas= null;
    private int mouseX = 0;
    private int mouseY = 0;
    private Point startPoint = new Point(-10,-10); 
    private Point endPoint = new Point(-10,-10); 
    
    public static int currentChoice ; 
    public static boolean frag = false;
    public static Color c = Color.black; 
    
    public PaintPanel() 
    {        
        addMouseMotionListener(this); 
        addMouseListener(this); 
    }
    
    public void paintComponent(Graphics g) 
    {
    	Graphics2D g2 = (Graphics2D)g;
        if(canvas == null)
        	canvas =(BufferedImage)super.createImage(getWidth(), getHeight()) ;
   	 	
        if(frag)
   	 	{
   	 		canvas = (BufferedImage)super.createImage(img.getWidth(), img.getHeight()) ;
   	 		frag = false ;
   	 	}	
    
   	 	
   	 	
   		Graphics2D g2d = canvas.createGraphics();
   		g2d.drawImage(canvas, 0, 0, null);
   		g2d.drawImage(img, 0,0,null);
   		
        g2d.setStroke(new BasicStroke(3.0F));
        g2d.setColor(c);
        
        
        if(currentChoice == 1)
        { 
        	g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        	jPainter.statusLabel.setText("Outil: Pinceau.");
        }
        if(currentChoice == 2 )
        {
        	g2d.fillOval(startPoint.x, startPoint.y, endPoint.x-startPoint.x, endPoint.y-startPoint.y);
        	jPainter.statusLabel.setText("Outil: Rectangle rempli.");
        }
        if(currentChoice == 3 )
        {
        	g2d.fillRect(startPoint.x, startPoint.y, endPoint.x-startPoint.x, endPoint.y-startPoint.y);
        	jPainter.statusLabel.setText("Outil: Ellipse rempli.");
        }
        
        if(currentChoice == 4)
        {            
        	g2d.setColor(Color.white);
            g2d.fillRect(0,0,jPainter.pa.getBounds().width,jPainter.pa.getBounds().height);
            JOptionPane d = new JOptionPane ();
            jPainter.statusLabel.setText("Démarré.");
        }
        
        if(currentChoice == 5)
        {
           g2d.setColor(c);
           g2d.setXORMode(Color.WHITE);
           g2d.drawRect(startPoint.x, startPoint.y, endPoint.x-startPoint.x, endPoint.y-startPoint.y);
           jPainter.statusLabel.setText("Outil: Rectangle.");
        }
        
        if(currentChoice == 6)
        {
        	g2d.setColor(c);
        	g2d.setXORMode(Color.WHITE);
        	g2d.drawOval(startPoint.x, startPoint.y, endPoint.x-startPoint.x, endPoint.y-startPoint.y);
        	jPainter.statusLabel.setText("Outil: Ellipse.");
        }
        
        if(currentChoice == 7)
        {
            g2d.setXORMode(Color.WHITE);
            g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
            jPainter.statusLabel.setText("Outil: Tracé d'une ligne.");
        }
        
        if(currentChoice == 8)
        {
        	g2d.setColor(Color.WHITE);
        	g2d.fillRect(startPoint.x, startPoint.y, 15, 15);
        	jPainter.statusLabel.setText("Outil: Gomme.");

        }
        
        img = null;
        g2.drawImage(canvas, 0, 0, null);
        g2d.dispose();
        
       
        startPoint=endPoint;
    }
    
    public void mouseDragged(MouseEvent e) 
    {
    	if(currentChoice == 1 )
    	{
    		endPoint = e.getPoint();
    		repaint();
    	}
    	if(currentChoice == 8)
    	{
    		endPoint = e.getPoint();
    		repaint();
    		
    		
    	}
    }
    
    public void mousePressed(MouseEvent e) 
    {
        startPoint = e.getPoint();
    }
    
    public void mouseMoved(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) 
    {
    	endPoint = e.getPoint();
    	repaint();	
    }
    
    public boolean mouseHasMoved(MouseEvent e)
    {
       return (mouseX != e.getX() || mouseY != e.getY());
    }

    
    public void mouseClicked(MouseEvent e) {
    	
    }
    public  void repaint1() {
    	repaint();
    }
    public static BufferedImage getsave() {
    	return canvas;
    }
    
    public static void setImage(BufferedImage image){
    img = image;	
    }
    
    public static void setFrag()
    {
    	frag = true;
    	
    }

}

