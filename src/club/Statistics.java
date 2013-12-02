package club;


import java.util.ArrayList;



/**
 *
 * @author jwvandyke
 */
public class Statistics {
    
    ArrayList<Double> data;
    BreakfastClub bc;
    MathClass mc;
    int n;
    
    public Statistics(ArrayList<Double> data, BreakfastClub bc) {
        
        this.bc = bc;
        this.data = data;
        
        mc = new MathClass(data);
        
        if (!data.isEmpty()) {
            
            setMean();
            setMedian();
            setMode();
            setTable();
            
        }
        
    }
    
    public void setMean() {
        
        double x = mc.getMean(data);
        
        x = Math.round(x*100.0)/100.0;
        
        String y = String.valueOf(x);
        
        bc.lblMeanData.setText(y);
        
    }
    
    public void setMedian() {
        
        double x;
        String y;
        
        x = mc.getMedian(data);
        
        x = Math.round(x*100.0)/100.0;
        
        y = String.valueOf(x);
        
        bc.lblMedianData.setText(y);
        
    }
    
    public void setMode() {
        
        double x;
        String y;
        
        x = mc.getMode(data);
        
        x = Math.round(x*100.0)/100.0;
        
        y = String.valueOf(x);
        
        bc.lblModeData.setText(y);
        
    }
    
    public void setTable() {
        
        if(n == 0)
            mc = new MathClass(data);
        else
            mc = new MathClass(data,n);
        double lower = mc.lcl;
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
            
        }
        
    }
    
}//end Statistics
