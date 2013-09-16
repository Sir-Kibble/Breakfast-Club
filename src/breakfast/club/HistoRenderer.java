package breakfast.club;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
//import java.util.ArrayList;
/**
 * David DeMeritt       dbdemeritt@valdosta.edu
 * Aug 2, 2011
 * Version: 1.0.0
 * Description:  
 * 9/16/13 - Almost a direct copy/paste from some code I wrote for a video game.  I'll have to
 * come back later and mess with it.  Buttons are not hooked up yet, but that shouldn't
 * be too hard to implement.  
 */
public class HistoRenderer extends JPanel implements Runnable, MouseListener  {
    public static final int TYPE_USHORT_555_RGB = 9;
    Thread T;
    int funds;
    String selection;
    int mouseX,mouseY;
    boolean started, terrainFlag, buttonSelected;
    int clicks;
    //Tile[][] level;
    static String[] gameFilePaths = {"resources\\images\\grass1.png","resources\\images\\path1.png","resources\\images\\spawn1.png",
        "resources\\images\\exit1.png","resources\\images\\build1.png","resources\\images\\exit1.png","resources\\images\\selection.png"};
    static String[] buildFilePaths = {"resources\\images\\MGbutton.png", "resources\\images\\LAbutton.png", "resources\\images\\buttonSelection.png"};
    BufferedImage[] GameImages;
    BufferedImage[] BuildImages;
    BufferedImage I;
    //private TowerController Towers;
    //private MobController Mobs;
    public HistoRenderer(boolean go){
        T = new Thread(this);
        terrainFlag = true;
        buttonSelected = false;
        clicks = 0;
        //Towers = new TowerController();
        //Mobs = new MobController();
        started = go;
        selection = "";
        addMouseListener(this);
        //addMouseMotionListener(this);
        
        GameImages = new BufferedImage[7];//<---  update this when adding stuff
        for(int x = 0; x < gameFilePaths.length; x++){
            GameImages[x] = new BufferedImage(24,24, TYPE_USHORT_555_RGB);
            try{
                GameImages[x] = ImageIO.read(new File(gameFilePaths[x]));
            }catch(IOException e){

            }//end catch
        }//end for
        BuildImages = new BufferedImage[3];//   <---  update this when adding stuff
        for(int x = 0; x < buildFilePaths.length; x++){
            BuildImages[x] = new BufferedImage(206,48, TYPE_USHORT_555_RGB);
            try{
                BuildImages[x] = ImageIO.read(new File(buildFilePaths[x]));
            }catch(IOException e){

            }//end catch
        }//end for
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


    @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G);
        if(started){

        //button building
            G.drawImage(BuildImages[0], 578, 0, null);
            G.drawImage(BuildImages[1], 578, 80, null);
            //G.drawImage(BuildImages[2], 578, 498, null);
            G.drawString("", 646, 505);
            
            //selected image and button drawing
            if(!terrainFlag)
            G.drawImage(GameImages[6], mouseX*24, mouseY*24, null);
            
            if(buttonSelected){
                if(selection.equals("MG"))
                G.drawImage(BuildImages[2], 578, 0, null);
                else if (selection.equals("LA"))
                G.drawImage(BuildImages[2], 578, 80, null);
            }

            this.repaint();
        }//end if(started)
    }//end paintComponent

    public void run(){
        while(true){
                repaint();
             try{
        T.sleep(20);
        }catch(InterruptedException googles){/*nothing!*/}
        }//end while
    }//end run
    
    
    //start mouse methods
    public void mouseClicked(MouseEvent e) {
        //do mob info with click and towers
        //Mob MM = Mobs.mobAtLocation(e.getX(), e.getY());
        //Tower TT = Towers.towerAtLocation(e.getX(), e.getY());
        //display Mob info
            
    }

    public void mousePressed(MouseEvent e) {
        /*if(firstClick){
            System.out.println("1");
            firstClick = false;
            }
        else 
            firstClick = true;*/
    }

    public void mouseReleased(MouseEvent e) {
        /*if(started){
            if(e.getButton() != MouseEvent.BUTTON1){
                clicks = 0;
            }//end started and button check
            else if(clicks == 0 && e.getButton() == MouseEvent.BUTTON1){
                //System.out.println("first click");
                //insert checks for existing towers, mobs, and terrain
                if(e.getX() < 578 && e.getY() < 578){
                    System.out.println("Terrain: "+this.level[e.getX()/24][e.getY()/24].toString());
                    mouseX = e.getX()/24;
                    mouseY = e.getY()/24;
                    terrainFlag = true;
                }
                else if(e.getX() > 578 && e.getY() < 81){
                    System.out.println("MG tower");
                    terrainFlag = false;
                    buttonSelected = true;
                    selection = "MG";
                }//end mg tower
                else if(e.getX() > 578 && e.getY() < 161){
                    System.out.println("LA tower");
                    terrainFlag = false;
                    buttonSelected = true;
                    selection = "LA";
                }//end la tower
                clicks++;
            }//end first click
            else if(clicks == 1 && e.getButton() == MouseEvent.BUTTON1 && !terrainFlag){
                clicks++;
            }
            else if(clicks == 1 && terrainFlag)
                clicks = 0;
            else if(clicks == 2 && e.getButton() == MouseEvent.BUTTON1){
                System.out.println("second click");
                //insert checks here to make sure final second click point is valid
                clicks++;
            }//end second second click
            else if(clicks == 3){
                clicks++;
            }//end clicks 3
            else if(clicks > 3 ){
                clicks = 0;
                buttonSelected = false;
            }//end clicks 3+
        }//end if started
                /*
                if(!started && e.getButton() != MouseEvent.BUTTON1){
                clicks = 0;
                
            }//end started and button check
            else if(clicks == 0 && e.getButton() == MouseEvent.BUTTON1 ){
                System.out.println("first click");
                clicks++;
            }//end first click
            else if(clicks == 1 && e.getButton() == MouseEvent.BUTTON1)
                clicks++;
            else if(clicks == 2 && e.getButton() == MouseEvent.BUTTON1){
                System.out.println("second click");
                clicks++;
            }//end second second click
            if(clicks == 3)
                clicks++;
            else if(clicks > 3 )
                clicks = 0;
                */
            //end firstCLick
    }//end mouseReleased

    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}//end GameRenderer
    
    
    
    
    
    
    
    
    
    
    
    //end mouse methods

    /*public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        //System.out.println(e.getX() + ", "+ e.getY()+" true: "+ e.getXOnScreen() +", "+e.getYOnScreen());
    }*/
