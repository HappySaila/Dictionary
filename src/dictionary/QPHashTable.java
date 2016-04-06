//WLSGRA012
package dictionary;
import java.util.List;
/**
 * Simple hash table implementation of Dictionary using quadratic probing.
 * 
 * @author Stephan Jamieson 
 * @version 24/4/2015
 */
public class QPHashTable extends AbstractHashTable {

	/**
	 * Create an LPHashTable with DEFAULT_SIZE table.
	 */ 
	public QPHashTable() { super(); }

	/**
	 * Create an LPHashTable with the given default size table.
	 */
	public QPHashTable(int size) { super(size); }  

	public int findIndex(String word) {
		// Implementation of findIndex() required here.
		int hashVal = hashFunction(word);
		int size = size();
		int iterator = table.length-1;
		int probe = 0;
		int probeValue = hashVal; //can change with every unsuccesful probe
		
		while(true){
			if (loadFactor()>0.5){
				//table needs rehashing
				//resizes the table
				/*table = rehash(table);
				iterator = table.length-1;*/
				return -1;
			}
			else if (table[hashVal]==null && hashVal<iterator){
				//empty slot, insert the word
				return hashVal;
			}
			else {
				//current slot taken and need to reprobe
				probe++;
				hashVal = probeValue + (int)Math.pow(probe,2);
				while (hashVal>iterator){
					hashVal -= table.length;
				}
			}
		}
	}
	protected Entry[] rehash(Entry[] oldArray){
		// Create a new, empty table
		QPHashTable newTable = allocateArray( nextPrime( 4 * oldArray.length));
		// Copy table over
		for( int i = 0; i < oldArray.length; i++ ){
			newTable.table[i]=oldArray[i];
		}
		return newTable.table;
	}
	private QPHashTable allocateArray( int arraySize ){	
		return new QPHashTable(arraySize);
	}
	private static int nextPrime( int n )
	{
		if( n % 2 == 0 )
			n++;
		for( ; !isPrime( n ); n += 2 )
			;
		return n;
	}
	public static boolean isPrime(int n) {
		// prime must be greater than 1
		if (n <= 1) {
			return false;
		}
		if (n <= 2) {
			return true;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
