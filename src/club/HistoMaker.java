package club;
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
    private  Thread T;
    private Color c;
    private MathClass M;
    private int X,Y,n;
    private boolean started;
    private int clicks;
    private int[] heights;
    //begin constructor.  May remove boolean arg for future
    public HistoMaker(){
        T = new Thread(this);
        started = false;
    }
    public HistoMaker(boolean go, ArrayList<Double> data){
        double [] temp;
        T = new Thread(this);
        M = new MathClass(data);
        heights = M.barHeight();
        n = M.getNumOfBars();
        c = new Color(255,255,255);//white
        started = go;
        if(go)
            this.start();
    }//end constructor
    
    /**
     * Starts the thread if it has not been started.  Does nothing otherwise.
     */
    public void start(){
        T.start();
        started  = true;
    }//end start

    public void isReady() {
        this.started = true;
    }
    /**Returns whether the thread on HistoMaker is started or not
     * @return False if not started.  True if started
     */
    public boolean getState(){
        return started;
    }
    
    /**
     * This method is to be called whenever the input data to draw the histogram is changed.  
     * Updates the Math class stored inside HistoMaker;
     * @param ArrayList<Double>
     */
    public void setData(ArrayList<Double> a){
        M = new MathClass(a);
        heights = M.barHeight();
        n = M.getNumOfBars();
    }//end setData
    
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
            G.fillRect(0, 0, 99, 99);//proof of concept
            //draw headers and lines here
            
            //for each bar, draw a corresponding rectangle
            
            for(int x = 0; x < heights.length; x++){
                G.fillRect((int)M.getClassWidth()*(x+1) + 100, this.getY() - 100, (int)M.getClassWidth(), heights[x]);
            }//end for
            //System.out.println("hello");
            //this.repaint();  //uncomment if broken
        }//end if(started)
    }//end paintComponent

    /**
     * What the thread does once started.  Runs until the program is killed.  
     * Waits every 45 ms to allow other threads access to system resources
     * only calls repaint method to update the panel
     */
    public void run(){
        System.out.println("x: "+this.getX()+", y: "+this.getY());
        while(true){
                this.repaint();
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
