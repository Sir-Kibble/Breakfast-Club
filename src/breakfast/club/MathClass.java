package breakfast.club;
/**
 *
 * @author Mole
 */
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
        
        public double[] barHeight( double numBars, double[] values ) {
            
            double sum = 0; //Sum of values 
            double classNum = 0; //Number of classes: sum of values divided by number of bars
            
            int count = 1;
            double[]  barDimen = new double[100];
            double tempSum = values[0];
            int barLocation = 0;
          
            for( int i = 0; i < values.length; i++ ) {
                Arrays.sort( values );
                sum = sum + values[i];
            }
            
            classNum = sum / numBars; 
            
            // ???
            for( int i = 1; i < numBars; i++ ) {
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


