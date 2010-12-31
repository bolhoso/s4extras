#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import io.s4.processor.AbstractPE;
import org.apache.log4j.Logger;

/**
 * Receive a string and print it to the standard output
 */
public class StringReceiverPE extends AbstractPE {

    /**
     * Log the sentence into the standard output.
     * 
     * @param sentence The sentence entering the system
     */
    public void processEvent(Sentence sentence) {
      System.out.printf ("The sentence %d have been received. Text: %s\n", sentence.getId(), sentence.getText());
      Logger.getLogger("s4").info("Sentence received " + Long.toString (sentence.getId()));
    }
    
    @Override
    public void output() {
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }

}
