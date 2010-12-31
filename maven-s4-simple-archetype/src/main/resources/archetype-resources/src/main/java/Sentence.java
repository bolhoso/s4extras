#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

/**
 * Represents a ${artifactId} sentence
 */
public class Sentence {
    private long id;
    private String text;
    private long time;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{id:")
          .append(id)
          .append(",text:")
          .append(text)       
          .append(",time:")
          .append(time) 
          .append("}");

        return sb.toString();
    }
}
