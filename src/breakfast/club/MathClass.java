package breakfast.club;
/**
 *
 * @author Mole
 */
public class MathClass {
    public static void main(String[] args) {
        
    }
    
    class Math1 {
        //x-axis
        double tableWidth;
        double n = 0; //data set quantity
        double lcl = 0; //lower class limit
        double ucl = 0; //upper class limit
        
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
    }
}

