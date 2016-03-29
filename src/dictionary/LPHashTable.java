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
    
	protected int findIndex(String word) {
		// Implementation of findIndex() required here.
		return 0;
	}

	public boolean containsWord(String word) {
		// Your code here. convert string into an integer and search table until word is found
		//instantioation
		int hashVal = hashFunction(word);
		int iterator = hashVal; //used to LP through the table incrementing it at every failed word search
		int tableSize = table.length; //used to know when the iterator must "wrap around"
		String storedVal;
		
		while(true){
			if (table[hashVal]!=null){
				storedVal = table[hashVal].getWord();
				if (storedVal.equals(word)){
					return true;
				}
				else{
					//the value in the table does not equal the word and we have to iterate
					iterator++;
					if (iterator>tableSize){
						iterator = 0;
					}
				}
			}
			else{
				//reached an empty slot, thus word is not in the table
				return false;
			}
		}
	}

	public List<Definition> getDefinitions(String word) {
		// Your code here.
		return null;
	}

	public void insert(String word, Definition definition) {        
		// Your code here. Need to create a new Entry object
		if (loadFactor()==1){
			return;
		}
		Entry entry = new Entry(word);
		entry.addDefinition(definition);
		boolean inserting = false;
		int i = 1; //used to iterate through the array
		int hashVal = super.hashFunction(word);
		
		if (!this.containsWord(word)){
			table[hashVal]=entry;
			entries++;
		}
		//else we linear probe
		else{
			while(inserting){
				try{
					//if the end of the array has not been reached then we just check if the next space in the table is open
					if (table[hashVal+i]==null){
						//next space in the table is available
						table[hashVal+i]=entry;
						inserting = false; //value was inserted and the loop must now come to a close
						break;
					}
					else{
						//next slot in the table is also taken, therefore we have to check next slot table[HashVal+ ++i]
						i++;
					}
				}
				catch(Exception e){
					//table out of range , must make hashVal=0 and i=0
					hashVal=0;
					i=0;
				}
			}
		}
	}
}
