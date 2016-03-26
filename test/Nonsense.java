import java.util.Random;
/**
 * Class for randomly generating 'nonsense' words.
 * <p>
 * The word is in quotes because some might not actually be nonsense. 
 * Results need to be checked against a lexicon. 
 * 
 * @author Stephan Jamieson
 * @version 20/3/2016
 */
public class Nonsense {

    private final static String ALPHABET="abcdefghijklmnopqrstuvwxyz";
    private final Random random;
    private final int min;
    private final int max;
    
    /**
     * Create an object for generating nonsense words of a length s such that min&lt=;s&lt;max.
     */
    public Nonsense(final int min, final int max) {
        assert(min<=max);
        random=new Random();
        this.min=min;
        this.max=max;
    }
    
    /**
     * Obtain a nonsense word.
     */
    public String next() {
        int length = random.nextInt(max-min)+min;
        final StringBuilder builder = new StringBuilder();
        while(length>0) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            length--;
        }
        return builder.toString();
    }
}

