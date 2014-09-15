import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class jPainter extends JFrame
{  
	
	public static JMenuItem mew;
	public static JMenuItem save; 
	public static JMenuItem open;
	public static JMenuItem exchit;
	public static JMenuItem apropos;
	
	public static JButton rect;
	public static JButton oval;
	public static JButton line;
	public static JButton pencil;
	public static JButton filled_rect;
	public static JButton filled_oval;
	public static JButton eraser;
	public static JButton color;
	public static JButton currentColor;
	public static JLabel whatColor;
	public static JLabel statusLabel;	
	public static JFrame frame;
	public static PaintPanel pa;
	
    public static void main(String[] args) throws Exception
    {
    	createGUI();
    }
    
    
    public static void createGUI() throws IOException 
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        frame = new JFrame("jPainter ver. 1.0"); 
        
        JPanel p = new JPanel(new BorderLayout());
        p.setPreferredSize(new Dimension(800, 600));
        JPanel statusPanel = new JPanel(new BorderLayout());
        
        JMenuBar menu = new JMenuBar();
        JMenu opmenu = new JMenu("Fichier");
        JMenu helpmenu = new JMenu("?");
        
        mew = new JMenuItem("Nouveau");
        save = new JMenuItem("Enregistrer");
        open = new JMenuItem("Ouvrir");
        exchit = new JMenuItem("Quitter");
        
        apropos = new JMenuItem("Apropos de ..");
        
        JToolBar outils = new JToolBar();
        pencil = new JButton(new ImageIcon("./icons/brush16.gif"));
        line = new JButton(new ImageIcon("./icons/line16.gif"));
        rect = new JButton(new ImageIcon("./icons/rect16.gif"));
        oval = new JButton(new ImageIcon("./icons/oval16.gif"));
        filled_rect = new JButton(new ImageIcon("./icons/filled_rect16.gif"));
        filled_oval = new JButton(new ImageIcon("./icons/filled_oval16.gif"));
        color = new JButton(new ImageIcon("./icons/color16.gif"));
        eraser = new JButton(new ImageIcon("./icons/gomme16.gif"));

               
        p.setPreferredSize(new Dimension(800, 600));
        p.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        pa = new PaintPanel();
        p.add(pa);
        p.add(statusPanel, BorderLayout.SOUTH);
       
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(p, BorderLayout.CENTER);
        frame.add(outils, BorderLayout.NORTH);
        frame.getRootPane().setJMenuBar(menu);
        frame.setIconImage(new ImageIcon("./icons/jPainter16.gif").getImage());
        
        menu.add(opmenu); 
        opmenu.add(mew);
        opmenu.add(open); 
        opmenu.add(save);
        opmenu.addSeparator();
        opmenu.add(exchit);
        menu.add(helpmenu);
        helpmenu.add(apropos);
        
        outils.add(pencil);
        outils.addSeparator();        
        outils.add(line);
        outils.add(rect);
        outils.add(oval);
        outils.addSeparator();
        outils.add(filled_rect);
        outils.add(filled_oval);
        outils.addSeparator();
        outils.add(eraser);
        outils.add(color);   
        
        statusLabel = new JLabel("Démarré.");
        currentColor = new JButton();
        currentColor.setBackground(PaintPanel.c);
        currentColor.setSize(24, 24);
        
        statusPanel.add(statusLabel, BorderLayout.WEST);
        statusPanel.add(currentColor, BorderLayout.EAST);
        

        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(Color.WHITE);
        
        save.addActionListener(new jPainterActionListener());
        open.addActionListener(new jPainterActionListener());
        mew.addActionListener(new jPainterActionListener());
        exchit.addActionListener(new jPainterActionListener());
        apropos.addActionListener(new jPainterActionListener());
        
        pencil.addActionListener(new jPainterActionListener());
        line.addActionListener(new jPainterActionListener());
        rect.addActionListener(new jPainterActionListener());
        oval.addActionListener(new jPainterActionListener());
        filled_rect.addActionListener(new jPainterActionListener());
        filled_oval.addActionListener(new jPainterActionListener());
        eraser.addActionListener(new jPainterActionListener());
        color.addActionListener(new jPainterActionListener());
        }
}
