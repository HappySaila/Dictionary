import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

//import com.sun.xml.internal.ws.wsdl.writer.document.Definitions;

import dictionary.*;
import java.util.*;
import java.io.*;

public class TestLPHashTable {
	@Test
	public void Test1(){
		AbstractHashTable table = new LPHashTable(10);
		AbstractHashTable table2 = new LPHashTable();
		table.insert("b",null);
		table.insert("b",null);
		table.insert("l",null);
		table.insert("v",null);
		assertTrue(table.getTable()[0].getWord().equals("v"));
	}
	@Test
	public void Test2(){
		AbstractHashTable table = new LPHashTable(1);
		table.insert("b",null);
		try{
			table.insert("l",null);
		}
		catch(Exception e){
			assertTrue(true); //load factor is 1
		}
	}
	@Test
	public void Test3(){
		AbstractHashTable table = new LPHashTable(10);
		table.insert("b",null);
		boolean contains = table.containsWord("b");
		boolean contains2 = table.containsWord("c");
		assertTrue(contains);
		assertTrue(!contains2);
	}
	@Test
	public void Test4(){
		AbstractHashTable table = new LPHashTable(2);
		table.insert("b",null);
		table.insert("b",null);
		List<Definition> list = table.getDefinitions("b");
		List<Definition> list2 = table.getDefinitions("c");
		assertTrue(list2==null);
		assertTrue(list.get(0)==null);
	}
	@Test
	public void Test5(){
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		AbstractHashTable table = new LPHashTable(1);
		table.insert("hello",null);
		table.dump();
		//System.out.println("\n\n\n");
		//System.out.println("   0 : hello: [null]\n#Entries: 1.");
		//System.out.println(table.getTable()[0]);
		assertEquals(outContent.toString(),("\n   0 : hello: [null]\n#Entries: 1."));
		System.setOut(null);
	}
	@Test
	public void Test6(){
		AbstractHashTable table = new LPHashTable(10);
		table.insert("hello",null);
		table.insert("ello",null);
		table.insert("hllo",null);
		table.insert("helo",null);
		table.insert("helo",null);
		table.insert("hell",null);
		table.empty();
		assertTrue(table.size()==0);
	}
}