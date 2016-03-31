package dictionary;
import java.util.List;
/**
 * Simple hash table implementation of Dictionary using quadratic probing.
 * 
 * @author Stephan Jamieson 
 * @version 24/4/2015
 */
public class SCHashTable extends AbstractHashTable {

	protected ChainedEntry[] table; 
	/**
	 * Create an LPHashTable with DEFAULT_SIZE table.
	 */ 
	public SCHashTable() {
		this(DEFAULT_SIZE); 
	}

	/**
	 * Create an LPHashTable with the given default size table.
	 */
	public SCHashTable(int size) { 
		super(size);
		this.table = new ChainedEntry[size];
		this.entries = 0;
	}  

	public int findIndex(String word) {
		// Implementation of findIndex() required here.
		return hashFunction(word);
	}
	public void insert(String word, Definition definition) {        
		// Your code here. Need to create a new Entry object
		//inserts value with no linear probe... If space is already occupied then the word will not be added
		int index = findIndex(word);
		ChainedEntry temp;

		if (table[index]==null){
			table[index]=new ChainedEntry(word, null);
			table[index].addDefinition(definition);
			entries++;
		}
		else {
			//if the slot is already taken
			temp = table[index]; //create temp chainedEntry so that we can iterate through the linked list
			while (true){
				if (temp.getWord()==word){
					table[index].addDefinition(definition);
					return;
				}
				else if(temp.getNext()==null){
					//checked all words for a similar word
					ChainedEntry entry = new ChainedEntry(word, temp);
					entry.addDefinition(definition);
					table[index]=entry;
					entries++;
					return;
				}
				else{
					//entry contains a link that needs to be checked
					temp = temp.getNext();
				}
			}
		}

	}
	public boolean containsWord(String word) {
		// Your code here. convert string into an integer and search table until word is found
		//instantioation
		int index = findIndex(word);
		ChainedEntry temp;
		if (table[index]==null){
			return false;
		}
		else{
			//words are at the index in the table
			temp = table[index];
			while(temp.getNext()!=null)
				if (temp.getWord()==word){
					return true;
				}
				else{
					temp = temp.getNext();
				}
		}
		//perform one more check for final link
		if (temp.getWord()==word){
			return true;
		}
		else{
			return false;
		}
	}
	public List<Definition> getDefinitions(String word) {
		// Your code here. 
		int index = findIndex(word);
		ChainedEntry temp;
		
		if (table[index]==null){
			return null;
		}
		else {
			//slot at index is not null
			temp = table[index];
			while(temp.getNext()!=null){
				if (temp.getWord().equals("word")){
					return temp.getDefinitions();
				}
				else{
					temp = temp.getNext();
				}
			}
			//one more time for final link
			if (temp.getWord().equals("word")){
				return temp.getDefinitions();
			}
			else{
				return null;
			}
		}
	}
	public ChainedEntry[] getTable(){
		return this.table;
	}
}

