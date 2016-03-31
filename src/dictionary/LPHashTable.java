package dictionary;
import java.util.List;
/**
 * Simple hash table implementation of Dictionary using linear probing.
 * 
 * @author Stephan Jamieson 
 * @version 24/4/2015
 */
public class LPHashTable extends AbstractHashTable {

	/**
	 * Create an LPHashTable with DEFAULT_SIZE table.
	 */ 
	public LPHashTable() { super(); }

	/**
	 * Create an LPHashTable with the given default size table.
	 */
	public LPHashTable(int size) { super(size); }  
	
	public int findIndex(String word) {
		// Implementation of findIndex() required here.
		int hashVal = hashFunction(word);
		int size = size();
		int iterator = table.length;
		while(true){
			if (loadFactor()==1){
				//table is full
				return -1;
			}
			else if (table[hashVal]==null){
				//empty slot, insert the word
				return hashVal;
			}
			else {
				hashVal++;
				if (hashVal>iterator-1){
					hashVal = 0;
				}
			}
		}
	}
}
