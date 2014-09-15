import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

/**
* Panel contenant le dessin du A Propos
*/
public class jPainterAboutUs extends JPanel implements Runnable 
{

    
    int largeur, hauteur;
    Font policeSVG, policeNom;
    int Xsvg, Ysvg, Xnom, Ynom, Xmait, Ymait, Xres, Yres;
    int X1, Y1, X2, Y2, X3, Y3;
    float transparence;
    Thread thread;
    
    /**
     * Constructeur
     */
    jPainterAboutUs( int i, int j) 
    {
    	setBounds(10,10,i,j);
    	largeur = i;
    	hauteur = j;
	
    	setVisible(true);

    	action();
	
    	// Paramètres affichages
    	transparence = (float) 0.0;
    	
    	Xsvg = 1250;
    	Ysvg = 50;
    	policeSVG = new Font("Dialog", Font.BOLD, 40);
    	
    	Xnom = 20;
    	Ynom = 160;
    	policeNom = new Font("Dialog", Font.BOLD, 15);
    	
    	Xmait = 280;
    	Ymait = Ynom;
    	
    	Xres = Xmait;
    	Yres = Ymait+100;
    	
    	// 	Animation
    	X1 = -50;
    	Y1 = -50;
    	X2 = 450;
    	Y2 = 100;
    	X3 = 370;
    	Y3 = -50;
    	
    	}
    
    // 	ACCESSEURS
    	public void setX1Y1(int i, int j) {X1 = i; Y1 = j;}
    	public int getX1() {return X1;}
    	public int getY1() {return Y1;}    

    	public void setX2Y2(int i, int j) {X2 = i; Y2 = j;}
    	public int getX2() {return X2;}
    	public int getY2() {return Y2;}
    	
    	public void setX3Y3(int i, int j) {X3 = i; Y3 = j;}
    	public int getX3() {return X3;}
    	public int getY3() {return Y3;} 
    	
    	public void setTransparence(float f) 
    	{
    		transparence = f;
    	}
    
    	public float getTransparence() 
    	{
    		return transparence;	
    	}

    	// FONCTIONS

    	// Gestion du Thread
    	public void run() 
    	{
    		try 
    		{
    			thread.sleep(500);
    			int i1, i2, i3;
    			i1 = i2 = i3 = 0; 
    			int index = 0;
    			while(true) 
    			{	
    				if (index == 5) 
    				{
    					index = 0;
    					if (getTransparence() < (float) 0.976) 
    					{
    						float f = getTransparence();
    						setTransparence(f + (float) 0.024);
    					} 			
    				}		
    				if ((getX1() > (largeur+50)) || (getY1() > (hauteur+50))) 
    				{
    					i1 = 0;
    					setX1Y1(-50,-50);
    				}
    				if ((getX2() < -150) || (getY2() < -150)) 
    				{
    					i2 = 0;
    					setX2Y2(450,100);
    				}
    				if ((getX3() < 0) || (getY3() > hauteur + 50)) 
    				{
    					i3 = 0;
    					setX3Y3(320,-50);
    				}
    				setX1Y1(getX1() + i1, getY1() + i1);
    				setX2Y2(getX2() - i2, getY2() - i2/3);
    				setX3Y3(getX3() - i3, getY3() + i3);
    				i1++;
    				i2++;
    				i3++;
    				index++;
    				repaint();
    				thread.sleep(100);
    			}
    		} 
    		catch (Exception e) 
    		{
    			System.out.println(e);
    		} 
    	}
    		public void action() {
    			try 
    			{
    				thread = new Thread(this);
    				thread.start();
    			} 
    			catch (Exception e) 
    			{
    				System.out.println(e);	
    			}
    		}

    		// Gestion de l'affichage du dessin
    		public void paint(Graphics g) 
    		{
    			Graphics2D biff,g2d = (Graphics2D)g;
    			BufferedImage buff = (BufferedImage)createImage(largeur, hauteur);
    			biff = buff.createGraphics();
    			
    			biff.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    			
    			biff.setColor(Color.white);			
    			biff.fillRect(0, 0, largeur, hauteur);
    			
    			biff.setPaint(new GradientPaint((float)Xsvg - 100,
    					(float)Ysvg,
    					new Color(226,32,0),
    					(float)Xsvg + 100,
    					(float)Ysvg + 170,
    					new Color(8,128,8)
				     	));
    			biff.setStroke(new BasicStroke(0));
    			biff.setFont(policeSVG);
    			biff.drawString("jPainter", Xsvg, Ysvg);
    			
    			
    			biff.setColor(Color.BLACK);
    			biff.setFont(policeNom);
    			biff.drawString("Développée par : ", Xnom, Ynom-10);
    			
    			biff.setColor(Color.GREEN);
    			biff.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) getTransparence()));
    			biff.drawString("LEBRAZI Mohammed Achraf", Xnom + 20, Ynom + 40);
    			
    			
    			biff.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1));	
    			biff.setColor(Color.blue);
    			biff.setFont(policeNom);
    			
    			biff.setColor(Color.blue);
    			biff.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) getTransparence()));
    			biff.drawString("ENSA, OUJDA.", Xmait + 20, Ymait + 60);
    			
    			biff.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1));	
    			biff.setColor(Color.black);
    			biff.setFont(policeNom);
    			
    			
    			biff.setPaint(new GradientPaint((float)0,(float)0,Color.yellow,(float)largeur,(float)hauteur,Color.red));
    			biff.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.5));
    			biff.fillRect(getX1(), getY1(), 200, 100);
    			
    			biff.setPaint(new GradientPaint((float)0,(float)0,Color.green,(float)largeur,(float)hauteur,Color.blue));
    			biff.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.2));
    			biff.fillRect(getX2(), getY2(), 200, 200);
    			
    			biff.setPaint(new GradientPaint((float)0,(float)hauteur,Color.blue,(float)400,(float)0,Color.red));
    			biff.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.3));
    			biff.fillRect(getX3(), getY3(), 50, 100);
    			
    			
    			g2d.drawImage(buff, 0, 0, this);
    			
    		}
    		
	}