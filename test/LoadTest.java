import dictionary.AbstractHashTable;
import dictionary.Loader;
//
import java.io.File;
//
import java.lang.reflect.Constructor;
/**
 * Program for testing load performance of a given hash table implementation of Dictionary.
 * 
 */
public class LoadTest {

   
    /** 
     * Create an instance of the given class of dictionary with the given table size.
     */
    private static AbstractHashTable createTable(final String className, final int tableSize) throws Exception { 
        final Class<? extends AbstractHashTable> tableClass = Class.forName(className).asSubclass(AbstractHashTable.class);
        final Constructor<? extends AbstractHashTable> intConstructor = tableClass.getConstructor(int.class);
        return intConstructor.newInstance(tableSize);
    }
    
    public static void main(final String[] args) throws Exception {
        // Create a dictionary object from the class name and table size given as command line arguments.
        final AbstractHashTable table = createTable(args[0], Integer.parseInt(args[1]));
        final Loader loader = new Loader(table);

        // Your code here.
    }
    
    
}
