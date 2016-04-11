import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import dictionary.*;
import java.util.*;
import java.io.*;

public class TestQPHashTable {
	@Test
	public void Test1(){
		AbstractHashTable table = new QPHashTable(10);
		AbstractHashTable table2 = new QPHashTable();
		table.insert("b",null);
		table.insert("b",null);
		table.insert("l",null);
		table.insert("v",null);
		assertTrue(table.getTable()[2].getWord().equals("v"));
	}
	@Test
	public void Test2(){
		AbstractHashTable table = new QPHashTable(1);
		table.insert("b",null);
		try{
			table.insert("l",null);
		}
		catch(Exception e){
			assertTrue(true); //load factor is 1
		}
	}
}