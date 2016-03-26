import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Performance testing utility. May be used to view the contents of a list in a randomised order.
 * 
 * @author Stephan Jamieson
 * @version 18/3/2016
 */
public class Randomizer<E> {
      
    private Random random;
    private List<E> data;
    
    /**
     * Create a Randomizer object for the given data. (Note: creates a shallow copy.)
     */
    public Randomizer(List<E> data) {
        this.data = new ArrayList<E>(data);
        this.random = new Random();
    }
    
    /**
     * View a randomly selected element.
     */
    public E next() {
        assert(!data.isEmpty());
        return data.remove(random.nextInt(data.size()));
    }
            
    /**
     * Determine if there are any elements left to view.
     */
    public boolean hasNext() { return !data.isEmpty(); }

}
