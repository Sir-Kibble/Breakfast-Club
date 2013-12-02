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
    private Color c;//temp color
    private MathClass M;
    private int X,Y,n,ticks, max, min;
    private double yFactor;
    private boolean started;
    private int clicks;
    private int[] heights;
    //begin constructor.  May remove boolean arg for future
    public HistoMaker(){
        T = new Thread(this);
        Y = this.getHeight();
        X = this.getWidth();
        started = false;
        ticks = 5;
        min = 0;
    }
    public HistoMaker(boolean go, ArrayList<Double> data){
        double [] temp;
        T = new Thread(this);
        min = 0;
        M = new MathClass(data);
        Y = this.getHeight();
        X = this.getWidth();
        heights = M.barHeight();
        n = M.getNumOfBars();
        ticks = 5;
        yFactor = 1.0;
        c = new Color(255,255,255);//black
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
    /**Sets the # of ticks used in the histogram.  Numbers too high will cause text overlap
     * @param int ticks
     */
    public void setTicks(int ticks){
        this.ticks = ticks;
    }//end setTciks
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
        int maxx = 0;
        int minn = Integer.MAX_VALUE;//maxium so it'll get replaced
        for(int x = 0; x < M.numOfBars;x++){
            if(heights[x] < minn){
                minn = heights[x];
                min = minn;
            }
            if(heights[x] > maxx){
                maxx = heights[x];
                max = maxx;
            }
        }//end for
    }//end setData
    /**Draws the tick marks for the graph.  Also calculates the yFactor to keep
     * columns in the drawable area.  Possibility to add support to find lower scale that's not 0 in future?
     * @param Graphics G
     * 
     */
    private void drawYTicks(Graphics G){
        int count = 1;
        X = this.getWidth();
        Y = this.getHeight();
        //98
        String text = Double.toString(Math.abs(M.ucl));
        int decimalPlaces = text.length() - text.indexOf('.') - 1;
        int tyFactor = (Y-200)/max;//integer division.  # between ticks
        //dynamic resizing so the ticks don't get all squished together
        while(tyFactor < 20/*num of pixil in height*/){
            tyFactor *= 2;
            count++;
        }//end while
        //making space to draw numbers for ticks
        for(int x = 0; x <= (max/count + max%count);x++){
            G.drawLine(94, (Y-99) - tyFactor * x,99,(Y-99) - tyFactor * x);
            G.drawString(""+(x*count), 89 - (decimalPlaces*10), (Y-98) - tyFactor*x);
        }//end for
        yFactor = tyFactor;
    }//end drawticks
    /**LEGACY CODE.  Calculates the stretch factor to keep the histogram on the page.  Loops though 
     * the bar heights and finds the highest.  From the max height, it find the multiple 
     * that will cause it to hit the max of the y axis.  all other values will be 
     * multiplied by that value to keep scale.
     * 
     * 
     */
    private void calcYFactor(){
        //using dloat division.  -200 to keep in range of axis
        if(max != 0)
            yFactor = (double)(Y - 200) / (double)max;
        else
            yFactor = 1;
    }//end calcyfactor
    /**
     * This will be doing all of the painting to the monitor.  Basics include drawing the actual histogram,
     * but will hopefully be expanded to having tooltips and the like when the user hovers over columns.
     * 
     * It is important to note that the origin for graphics is the top left corner(0,0).
     * all numbers sued to paint will have to be negative in order to show up on the screen 
     */
    @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G);
        if(started){
            //axis and title
            G.drawString("Frequency", 10, Y/2);
            //grabbing screen size...
            X = this.getWidth();
            Y = this.getHeight();
            c = new Color(20,128,128);
            //Adding random color mode eventually for extra eye strain?
            G.setColor(Color.BLACK);//using grey
            //draw headers and lines here
            G.drawLine(99, 100, 99, Y-99);
            G.drawLine(99, Y-99, X-100, Y-99);
            //drawing tick marks
            drawYTicks(G);
            /*double lower = mc.lcl;
        double higher = lower + mc.cw;
        
        int[] bars = mc.barHeight();
        
        for (int i = 0; i < mc.numOfBars; i++) {
        
            if (i == 0) {
            
                bc.tblData.setValueAt("(" + (Math.round(lower*100.0)/100.0) + ", " + (Math.round(higher*100.0)/100.0) + ")", i, 0);
            
            }
            
            else {
                
                bc.tblData.setValueAt("[" + (Math.round(lower*100.0)/100.0) + ", " + (Math.round(higher*100.0)/100.0) + ")", i, 0);
                
            }
            bc.tblData.setValueAt(bars[i], i, 1);
            double relFreq = ((bars[i] / (double)data.size()) * 100.0);
            relFreq = Math.round(relFreq * 100.0)/100.0;
            bc.tblData.setValueAt(relFreq + "%", i, 2);
            lower = higher;
            higher = lower + mc.cw;
        }*///1 2 3 4 4 3 3 3 5 5 5 4 4 3 2 2
            yFactor = (Y-200)/max;
            for(int x = 0; x < heights.length; x++){
                G.setColor(c);
                G.fillRect(100 + x*((X-200)/M.numOfBars), Y - 99, ((X-200)/M.numOfBars), (int)(-heights[x]*yFactor));
                G.setColor(Color.BLACK);
                G.drawRect(100 + x*((X-200)/M.numOfBars), Y - 99, ((X-200)/M.numOfBars), (int)(-heights[x]*yFactor));
                
                
                G.drawLine(99 + (x+1)*((X-200)/M.numOfBars), Y - 99,99 + (x+1)*((X-200)/M.numOfBars), Y - 105);
                
            }//end for
        }//end if(started)
    }//end paintComponent
    /**
     * What the thread does once started.  Runs until the program is killed.  
     * Waits every 45 ms to allow other threads access to system resources
     * only calls repaint method to update the panel
     */
    public void run(){
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
    private void saveHistogram(){
        Container C = this;
        BufferedImage im = new BufferedImage(C.getWidth(), C.getHeight(), BufferedImage.TYPE_INT_ARGB);
        C.paint(im.getGraphics());
        try{
            ImageIO.write(im, "PNG", new File("Histogram.png"));
        }catch(Exception e){
            
        }//end catch
    }//end save
}//end GameRenderer