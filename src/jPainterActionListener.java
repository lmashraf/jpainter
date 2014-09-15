import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;

class jPainterActionListener extends JFrame implements ActionListener { 
	BufferedImage img ;
	
	public static int num = 0;
	

	public void actionPerformed(ActionEvent e)
	{		
		/* Barre d'Outils */
		if(e.getSource() == jPainter.pencil)
		{
			jPainter.pa.currentChoice = 1;
		}
		
		if(e.getSource() ==jPainter.filled_oval)
		{
			jPainter.pa.currentChoice = 2;
		}
		
		if(e.getSource() ==jPainter.filled_rect)
		{
			jPainter.pa.currentChoice = 3;
		}
		
		if(e.getSource() == jPainter.eraser)
		{
			jPainter.pa.currentChoice = 8;
		}
		
		if(e.getSource()== jPainter.rect)
		{
			jPainter.pa.currentChoice = 5;
		}
		
		if(e.getSource()== jPainter.oval)
		{
			jPainter.pa.currentChoice = 6;
		}
		
		if(e.getSource() == jPainter.line)
		{
			jPainter.pa.currentChoice = 7;
		}
		
		if(e.getSource() == jPainter.color) 
		{ 
			jPainter.statusLabel.setText("Information: Choisissez une couleur puis confirmez !");
			jPainter.pa.c = JColorChooser.showDialog(jPainter.frame, "Couleurs", Color.blue);
			jPainter.currentColor.setBackground(jPainter.pa.c);
			jPainter.statusLabel.setText("Démarré.");
		}
		
		/* Menus */
		
		//Fichier:
		if(e.getSource() == jPainter.mew)
		{
			jPainter.pa.currentChoice = 4;
		}
		
		if(e.getSource() ==  jPainter.open)
		{
			JFileChooser filechooser1 = new JFileChooser();
			int selected = filechooser1.showOpenDialog(this);
			if (selected == JFileChooser.APPROVE_OPTION){
				try{
				img =null;
				 img = ImageIO.read(filechooser1.getSelectedFile());
				jPainter.pa.setImage(img);
				jPainter.pa.setFrag();
				jPainter.pa.repaint1();
					
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		if(e.getSource() == jPainter.save)
		{
			JFileChooser filechooser2 = new JFileChooser();
			 int selected2 = filechooser2.showSaveDialog(this); 
			 
			    if (selected2 == JFileChooser.APPROVE_OPTION){
			    	
			      try {
			    	  
			    	  ImageIO.write(jPainter.pa.getsave(),"png",filechooser2.getSelectedFile());						
						
					} catch (Exception exception) {
						exception.printStackTrace();
					}
			    }
			
		}
		
		if(e.getSource() == jPainter.apropos)
		{
			JFrame frame=new JFrame ("A propos de jPainter ver. 1.0");
			frame.setSize(500,300);
			frame.setLocationRelativeTo(null);
		    frame.setIconImage(new ImageIcon("./icons/jPainter16.gif").getImage());
		    frame.setResizable(false);
			jPainterAboutUs apropos = new jPainterAboutUs(500,300);
			frame.add(apropos);
			frame.setVisible(true);
		}
		
		if(e.getSource() == jPainter.exchit)
		{
	        jPainter.frame.dispose();
		}
	}
}
