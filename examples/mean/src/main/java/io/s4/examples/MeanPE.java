package io.s4.examples;

import io.s4.processor.AbstractPE;
import org.apache.log4j.Logger;

import com.esotericsoftware.minlog.Log;

/**
 * Calculate the moving average of the last N numbers
 */
public class MeanPE extends AbstractPE {
    private float avg;
    private int lastN;
    
    private float []terms;
    private int nofTerms;

    public MeanPE () {
        this.avg = 0;
        this.nofTerms = 0;
    }

    public void setLastN (int lastN) {
        this.lastN = lastN;
        this.terms = new float [this.lastN];
        this.nofTerms = 0;
    }
    
    public int getLastN () { 
        return lastN;
    }
    
    public MeanPE (int lastN) {
        this();
        
        this.setLastN(lastN);
    }
    
    /**
     * Log the sentence into the standard output.
     * 
     * @param sentence The sentence entering the system
     */
    public void processEvent(Term term) {
        
        // Remove the first term from the average
        if (this.nofTerms == lastN) {
            this.avg -= this.terms[0]/this.lastN;
            this.avg += term.getValue () / this.lastN;            

            Logger.getLogger("s4").debug ("Adding " + term.getValue()/this.lastN);
            Logger.getLogger("s4").debug ("Removing " + this.terms[0]/this.lastN);

            // Shift everyone left
            MeanPE.shiftLeft (this.terms, this.lastN);
        } else { 
            this.nofTerms++;
            this.terms[this.nofTerms-1] = term.getValue();
            
            this.avg += this.terms[this.nofTerms - 1] / this.lastN;
        }

        int i = 0;
        for (; i < this.lastN; i++) Logger.getLogger("s4").debug ("Array[" + i + "] = " + this.terms[i] + "\n");
        
        // Add the new term to the average
        this.terms[this.nofTerms - 1] = term.getValue();
        
        System.out.println("");
    }
    
    /**
     * Shift everyone one space left on the array
     * 
     * @param array
     * @param n
     */
    public static void shiftLeft (float []array, int n) {
        if (n <= array.length) {
            int i;
            
            for (i = 1; i < n; i++) 
                array[i - 1] = array[i];
        }
    }
    
    @Override
    public void output() {
        System.out.println ("The moving average is " + this.avg);
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }

}
