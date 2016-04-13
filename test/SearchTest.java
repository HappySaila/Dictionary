import dictionary.AbstractHashTable;
import dictionary.Loader;
//
import java.io.File;
//
import java.lang.reflect.Constructor;
import java.util.Scanner;
/**
 * Program for testing load performance of a given hash table implementation of Dictionary.
 * 
 */
public class SearchTest {


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
		int sampleSize = Integer.parseInt(args[3]);
		int trials = Integer.parseInt(args[4]);
		int totalProbes = 0;

		int realTests = (int)(0.8*sampleSize);
		int nonsenseTests = (int)(0.2*sampleSize);

		// Your code here.
		File file = new File("data/" +args[2]);
		DataReader reader = new DataReader(file);
		
		System.out.println("Hoorah");
		try{
			loader.loader(file);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		for (int j=0; j<trials; j++){
			Randomizer rand = new Randomizer(reader.asList());
			Nonsense non = new Nonsense(1,10);
			for (int i=0; i<realTests; i++){
				//get and find a random word
				try{
					String load = rand.next().toString();
					final Scanner scanner = new Scanner(load).useDelimiter("\\s*:\\s*");
					scanner.next();
					String word = scanner.next();
					//System.out.println(word);
					table.containsWord(word);
				}
				catch(Exception e){
					
				}
			}
			for (int i=0; i<nonsenseTests; i++){
				try{
					String word = non.next();
					//System.out.println(word);
					table.containsWord(word);
				}
				catch(Exception e){
					
				}
			}
			System.out.println("Number of probes: "+table.getProbeCount());
		}
		System.out.println("loadFactor: "+table.loadFactor());
		System.out.println("total probe counts: "+table.getProbeCount()/trials);
	}
}
