//package breakfast.club;
/**
 *
 * @author Mole

import java.util.*;

public class MathClass {
    public static void main(String[] args) {
       //Math1 m = new Math1();
    
    }    
    class Math1 {
        //x-axis
        double tableWidth;
        double n = 0; //data set quantity
        double lcl = 0; //lower class limit
        double ucl = 0; //upper class limit
        
        public Math1() {
            
        }
        public Math1(double n, double tableWidth, double lcl, double ucl) {
            this.n = n;
            this.tableWidth = tableWidth;
            this.lcl = lcl;
            this.ucl = ucl;
        }
        
        //method computing x-axis, do we need to return anything? 
        public void xaxis(double numBars) {
            
            //if user enters number b/w 4 & 20
            if( numBars > 4 && numBars < 20 ) {
               //number of bars needed to draw 
            }
            else 
                numBars = Math.sqrt(n); 
        }
        
        public double barWidth( double lcl, double ucl, double numBars) {
            double width = 0;
            return width = ( ucl - lcl ) / numBars;
            
            //x-axis total width?
        }
        
        public List<Double> barHeight( double numBars, List<Double> values ) {
            
            double sum = 0; //Sum of values 
            double classNum = 0; //Number of classes: sum of values divided by number of bars
            
            int count = 1;
            ArrayList<Double> barDimen = new ArrayList<Double>(); //Convert to ArrayList
            //ArrayList<Double> tempSum = values[0]; //Convert to ArrayList
            int barLocation = 0;
          
            for( int i = 0; i < values.size(); i++ ) {
                Collections.sort( values );
                sum = sum + values.get(i);
            }
            
            classNum = sum / numBars; 
            
            // ??? Please adjust this code to implement arraylist instead of arrays
            /*for( int i = 1; i < numBars; i++ ) {
                if( i == classNum * count ) {
                   barDimen[ barLocation ] = tempSum / numBars;
                   tempSum = 0;
                   barLocation++;
                   count++;
                }
                tempSum += values[i];
            }
            
            return barDimen;
        }
    }
}
*/





/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package breakfast.club;

import java.util.ArrayList;

public class MathClass {
//x-axis
    double tableWidth;
    double[] data;
    ArrayList<Double> A;
    ArrayList<Double> heights;
    int n = 0; //data set quantity
    double lcl = 0; //lower class limit
    double ucl = 0; //upper class limit

    public MathClass(ArrayList<Double> a,int useSpec){
        Double [] dat = a.toArray(new Double[0]);
        //this is literally the only way to do this...
        for(int x = 0;x < dat.length;x++){
            data[x] = dat[x];
        }//end for
        
        nCalc(useSpec);
        heights = barHeight();
    }
    //find # bins
    //split a between bins
    //find lcl ucl on each bin
    //other calculations?
    public MathClass() {

    }
    public MathClass(int n, double lcl, double ucl) {
        this.n = n;
        this.lcl = lcl;
        this.ucl = ucl;
    }
    
    
    
    /**calculates the # of 'bins' or columns the data will be put into.  
     * @param numColumns User-specified input.  If <4 or > 20, it's recalculated
     */
    private void nCalc(int x){
        if (x < 4 || x > 20)
            n = (int)Math.floor(Math.sqrt(x));
        else
            n = x;
    }//end

    /**method computing x-axis, do we need to return anything? 
     * 
     * @param numBars
     * @return 
     */
    public int xaxis(double numBars) {

        //if user enters number b/w 4 & 20
        if( numBars > 4 && numBars < 20 ) {
           //number of bars needed to draw

        }
        else 
        {
            numBars = Math.sqrt(n);
            numBars = (double)Math.round(numBars * 1) / 1;

        }
        //System.out.println(numBars);
        return 0;//numBars;
    }
    /**
     * Calculates bar width
     * @param lcl
     * @param ucl
     * @param numBars
     * @return barWidth
     */
    public double barWidth( double lcl, double ucl, double numBars) {
        double width = 0;
        numBars = xaxis(numBars);
        return width = ( ucl - lcl ) / numBars;

        //x-axis total width?
            //if all barWidths are the same, the return is used for all bars
    }

    public ArrayList<Double> barHeight() {
        ArrayList<Double> values;
        values = A;
        ArrayList<Double> barDimen = new ArrayList<Double>(); //Convert to ArrayList
        double numBars = n;
        double sum = 0; //Sum of values 
        //double classNum = 0; //Number of classes: sum of values divided by number of bars

        //ArrayList<Double> clone = (ArrayList<Double>)values.clone(); //works if all values are consecutive
        //Collections.sort(clone); //couldnt just sort the values, caused some lcl ucl values to encapsulate a larger amount of values than other classes
        ArrayList<Double> clone = new ArrayList<Double>();

        for(int i = 0; i < values.size();i++)//creates consecutive values that can be used for calculating amount of values for each class
        {
            clone.add((double)i);
        }

        int[] width = new int[(int)numBars];//holds the sizes that each class can hold

        double lower = 0;

        double w = barWidth(lower, values.size(), numBars);

        double upper = lower + w;

        double last = -1;

        //Calculates the amount of values to place into each bin (class)
        for (int i = 0; i < width.length; i++) {
            //System.out.println("i: " + i);
            for (int j = 0; j < clone.size(); j++) {
                //System.out.println("j " + j);

                if (clone.get(j) >= lower && clone.get(j)<= upper) {

                    if (clone.get(j) == last) {}
                    else {

                        width[i]++;

                        last = clone.get(j);

                    }//end else

                }//end if

            }//end for

            lower+= w;
            upper+= w;

        }//end for
        //End of Calculating amount of values for each bin

        int count = 0;
        for (int i = 0; i < width.length; i++) {
            for(int j = 0; j < width[i]; j++)
            {
                sum += values.get(count);
                //System.out.println("Class Number " + i + " value "+ j +":\t" + values.get(count)+ "\t+=\t"+sum);//for testing
                count++;
            }
            //System.out.println("BarHeight["+i+"]:\t" + sum); //for testing

            //classNum = sum/width[i];    //The average value for the class
            //barDimen.add(classNum);
            barDimen.add(sum);              //all values in class summed together

            sum = 0;
        }

        return barDimen;
    }
}
//}





