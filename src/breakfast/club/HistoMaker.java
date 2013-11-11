package breakfast.club;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
//import java.util.ArrayList;
/**
 * David DeMeritt       dbdemeritt@valdosta.edu
 * Aug 2, 2011
 * Version: 1.0.0
 * Description:  Responsible for rendering tile sprites and the game in its entirety.
 */
public class HistoMaker extends JPanel implements Runnable, MouseListener  {
    public static final int TYPE_USHORT_555_RGB = 9;
    Thread T;
    Color c;
    MathClass M;
    int X,Y;
    boolean started;
    int clicks;
    
    //begin constructor.  May remove boolean arg for future
    public HistoMaker(boolean go, ArrayList<Double> data, int userSpec){
        double [] temp;
        T = new Thread(this);
        M = new MathClass(data,userSpec);
        c = new Color(255,255,255);//white
        started = go;
        if(go)
            this.start();
        
    }//end constructor

    public void start(){
        T.start();
    }//end start

    public void isReady() {
        this.started = true;
    }

    public boolean getState(){
    return started;
    }

    
    /**
     * This will be doing all of the painting to the monitor.  Basics include drawing the actual histogram,
     * but will hopefully be expanded to having tooltips and the like when the user hovers over columns.
     */
    @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G);
        if(started){
            //grabbing screen size...
            X = this.getWidth();
            Y = this.getY();
            
            //Adding random color mode eventually for extra eye strain?
            G.setColor(c);//using grey
            G.drawRect(0, 0, 340, 34);//proof of concept
            
            
            //System.out.println("hello");
            //this.repaint();  //uncomment if broken
        }//end if(started)
    }//end paintComponent

    public void run(){
        while(true){
                repaint();
             try{
        T.sleep(45);
        }catch(InterruptedException googles){
            System.out.println("Blarg!");
            }//end catch
        }//end while
    }//end run
    
    
    //start mouse methods
    public void mouseClicked(MouseEvent e) {
            
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        
    }//end mouseReleased

    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}//end GameRenderer
