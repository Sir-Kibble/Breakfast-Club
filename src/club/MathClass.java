package club;

import java.util.*;

public class MathClass {

    ArrayList<Double> al;
    double ucl;
    double lcl;
    int numOfBars;
    double cw;
    
    public MathClass(ArrayList<Double> al) {
        
        this.al = al;
        
        Collections.sort(al);
        
        lcl = al.get(0);
        ucl = al.get(al.size() - 1);
        
        numOfBars = getNumOfBars();
        
        cw = getClassWidth();
        
    }//end constructor
    
    public double getQ1() {
        
        ArrayList<Double> data = new ArrayList();
        
        if (al.size() % 2 == 0) {
        
            for (int i = 0; i < (al.size() / 2); i++) {

                data.add((double)al.get(i));

            }
        
        }
        
        else {
        
            for (int i = 0; i < (al.size() / 2) - 1; i++) {

                data.add((double)al.get(i));

            }
        
        }
        
        MathClass mc = new MathClass(data);
        
        return (double) mc.getMedian(data);
        
    }
    
    public double getQ3() {
        
        ArrayList<Double> data = new ArrayList();
        
        if (al.size() % 2 == 0) {
        
            for (int i = al.size() / 2; i < al.size(); i++) {

                double x = (double)al.get(i);
                data.add(x);

            }
        
        }
        
        else {
            
            for (int i = (al.size() / 2) + 1; i < al.size(); i++) {

                double x = (double)al.get(i);
                data.add(x);

            }
            
        }
        
        MathClass mc = new MathClass(al);
        
        return (double) mc.getMedian(data);
        
    }
    
    public void getOutliers() {
        
        double lower = getQ1() - (1.5 * getIQR());
        double higher = getQ3() + (1.5 * getIQR());
        
        for (int i = 0; i < al.size(); i++) {
            
            if (al.get(i) < lower || al.get(i) > higher) {
                
                System.out.println(al.get(i));
                
            }
            
        }
        
    }
    
    public double getIQR() {
        
        return getQ3() - getQ1();
        
    }
    
    public int[] barHeight() {
        
        ArrayList<Double> clone = (ArrayList<Double>) al.clone();
        
        int[] w = new int[numOfBars];
        
        double lower = lcl;
        
        double upper = lcl + cw;
        
        int count = 0;
        
        for (int i = 0; i < w.length; i++) {

            for (int j = 0; j < clone.size(); j++) {
                
                if (count == 0) {
                    
                    if (clone.get(j)>= lower && clone.get(j) < upper) {
                        
                        w[i]++;
                        
                    }
                    
                }//end if
                
                else if (count == w.length - 1){
                    
                    if (clone.get(j) >= lower && clone.get(j) <= upper) {
                        
                        w[i]++;
                        
                    }
                    
                }//end else if
                
                else {
                    
                    if (clone.get(j) >= lower && clone.get(j) < upper) {
                        
                        w[i]++;
                        
                    }
                    
                }//end else

            }//end for j
            
            count++;
            lower += cw;
            upper += cw;

        }//end for i
        
        return w;
        
    }
    
    public double getClassWidth() {
        
        return (ucl - lcl) / numOfBars;
        
    }
    
    public int getNumOfBars() {
        
        int size = al.size();
        
        double x = Math.sqrt((double)size);
        
        int numOfBars = (int)Math.floor(x);
        
        if (x > 20) {
            
            numOfBars = 20;
            
        }
        
        else if (x < 4) {
            
            numOfBars = 4;
            
        }
        
        return numOfBars;
        
    }
    
    public double getMean(ArrayList<Double> al) {
        
        double x = 0;
        
        for (int i = 0; i < al.size(); i++) {
            
            double temp = (double) al.get(i);
            
            x += temp;
            
        }
        
        return x / al.size();
        
    }
    
    public double getMedian(ArrayList<Double> al) {
        
        Collections.sort(al);
        
        int mid = al.size()/2;
        if (al.size()%2 == 1) {
            
            return (double)al.get(mid);
            
        }//end if
        
        else {
            
            return ((double)al.get(mid - 1) + (double)al.get(mid)) / 2;
            
        }//end else
        
    }//end getMedian
    
    public double getMode(ArrayList al) {
        
        Double val = 0.0; 
        int maxCount = 0;
        
        for (int i = 0; i < al.size(); ++i) {
            
            int count = 0;
            
            for (int j = 0; j < al.size(); ++j) {
                
                if (al.get(j) == al.get(i)) {
                    
                    ++count;
                    
                }//end if
                
            }//end for
            
            if (count > maxCount) {
                
                maxCount = count;
                val = (Double) al.get(i);
                
            }//end if
            
        }//end for
        
        return (double)val;
        
    }//end getMode

}//end class