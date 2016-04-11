import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import dictionary.*;
import java.util.*;
import java.io.*;

public class TestSCHashTable {
	@Test
	public void Test1(){
		SCHashTable table = new SCHashTable(10);
		SCHashTable table2 = new SCHashTable();
		table.insert("b",null);
		table.insert("l",null);
		table.insert("v",null);
		table.insert("a",null);
		table.insert("a",null);
		boolean contains = table.containsWord("v");
		boolean contains2 = table.containsWord("t");
		List<Definition> list = table.getDefinitions("t");
		List<Definition> list2 = table.getDefinitions("l");
		List<Definition> list3 = table.getDefinitions("v");
		List<Definition> list4 = table.getDefinitions("db");
		assertTrue(list==null);
		assertTrue(list2.get(0)==null);
		assertTrue(list3.get(0)==null);
		assertTrue(list4==null);
		assertTrue(!contains2);
		assertTrue(contains);
		assertTrue(table.getTable()[8].getNext().getNext().getWord().equals("b"));
	}
	@Test
	public void Test2(){
		SCHashTable table = new SCHashTable(1);
		table.insert("b",null);
		try{
			table.insert("a",null);
		}
		catch(Exception e){
			assertTrue(true); //load factor is 1
		}
	}
}