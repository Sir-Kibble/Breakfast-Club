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
import javax.swing.JColorChooser;
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
    //private JColorChooser JC;
    private Color c = Color.BLUE;//temp color
    private MathClass M;
    String title,xAxis,yAxis;
    private int X,Y,n,ticks, max, min,mouseX,mouseY;
    private double yFactor;
    private boolean started,flag;
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
        //JC = new JColorChooser();
    }
    public HistoMaker(boolean go, ArrayList<Double> data){
        double [] temp;
        T = new Thread(this);
        
        //JC = new JColorChooser();
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
        if(n == 0)
            M = new MathClass(a);
        else
            M = new MathClass(a,n);
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
        int max = 0;
        for(int x = 0; x < heights.length; x++){
            if(heights[x] > max)
                max = heights[x];
        }//end for
        String text = Double.toString(max);
        int decimalPlaces = text.length() - text.indexOf('.') - 1;
        int tyFactor = (Y-200)/max;//integer division.  # between ticks
        //dynamic resizing so the ticks don't get all squished together
        while(tyFactor < 20/*num of pixil in height*/){
            tyFactor *= 2;
            count*=2;
        }//end while
        //making space to draw numbers for ticks
        for(int x = 0; x <= (max/count/* + max%count*/);x++){
            G.drawLine(94, (Y-99) - tyFactor * x,X-100,(Y-99) - tyFactor * x);
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
            if(title != null)
            G.drawString(title, X/2, 45);
            if(xAxis != null)
            G.drawString(xAxis,X/2,Y-45);
            if(yAxis == null)
                G.drawString("Frequency", 10, Y/2);
            else
                G.drawString(yAxis, 10, Y/2);
            //grabbing screen size...
            X = this.getWidth();
            Y = this.getHeight();
            //c = new Color(20,128,128);
            //Adding random color mode eventually for extra eye strain?
            G.setColor(Color.BLACK);//using grey
            //draw headers and lines here
            G.drawLine(99, 100, 99, Y-99);
            G.drawLine(99, Y-99, X-100, Y-99);
            //drawing tick marks
            drawYTicks(G);
            
        //1 2 3 4 4 3 3 3 5 5 5 4 4 3 2 2
            yFactor = (Y-200)/max;
            double lower = M.lcl;
            double higher = lower + M.cw;
            
            for(int x = 0; x < heights.length; x++){
                if(mouseX > 100 + x*((X-200)/M.numOfBars) && mouseX < 100 + (x+1)*((X-200)/M.numOfBars))
                    
                    G.setColor(JColorChooser.showDialog(this, "Pick a color", null));
                else
                    G.setColor(c);
                
                G.drawRect(100 + x*((X-200)/M.numOfBars), Y - 99, ((X-200)/M.numOfBars), (int)(-heights[x]*yFactor));
                G.setColor(Color.BLACK);
                //G.drawRect(100 + x*((X-200)/M.numOfBars), Y - 99, ((X-200)/M.numOfBars), (int)(-heights[x]*yFactor));
                
                
                G.drawLine(99 + (x+1)*((X-200)/M.numOfBars), Y - 99,99 + (x+1)*((X-200)/M.numOfBars), Y - 105);

                Double z = (Math.round(lower*100.0)/100.0);
                String y = z.toString();

                //G.drawString(y,75+((X-200)/n * x)+((X-200)/n)/2, Y-75);
                
                if (x == 0) {
                
                    G.drawString(y, 85, Y-75);
                
                }
                
                else if (x == heights.length - 1) {
                    
                    Double i = M.ucl;
                    
                    G.drawString(i.toString(), X-115, Y - 75);
                    G.drawString(y, 85 + (x) * ((X-115-85) / M.numOfBars), Y - 75);
                    
                }
                
                else {
                    
                    G.drawString(y, 85 + (x) * ((X-115-85) / M.numOfBars), Y - 75);
                    
                }
                
                lower = higher;
                higher = lower + M.cw;
                flag = false;
                mouseX = 0;
                mouseY = 0;
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
            mouseX = e.getX();
            mouseY = e.getY();
            flag = true;
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
        BufferedImage im = new BufferedImage(C.getWidth(), C.getHeight(), BufferedImage.TYPE_INT_BGR);
        C.paint(im.getGraphics());
        try{
            ImageIO.write(im, "PNG", new File("Histogram.png"));
        }catch(Exception e){
            System.out.println("Error saving file!!");
        }//end catch
    }//end save

    public Thread getT() {
        return T;
    }

    public void setT(Thread T) {
        this.T = T;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public MathClass getM() {
        return M;
    }

    public void setM(MathClass M) {
        this.M = M;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getyFactor() {
        return yFactor;
    }

    public void setyFactor(double yFactor) {
        this.yFactor = yFactor;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int[] getHeights() {
        return heights;
    }

    public void setHeights(int[] heights) {
        this.heights = heights;
    }
    
}//end GameRenderer