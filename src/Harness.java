import dictionary.*;
import java.util.Scanner;

public class Harness{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Definition definition = new Definition(WordType.toWordType("noun"),"default definition just for temp testing.");
		
		String welcome = "\n\nWelcome to Hash Table Helper. Enter size you want your Table to be.";
		System.out.println(welcome);
		int size = sc.nextInt();
		LPHashTable table = new LPHashTable(size);
		
		String todo = "\n\nEnter the number for what you want to do. Press \"!\" to quit and print.\n\n1) insertVal.\n2) check if val is in table.\n3) check table size status.\n4) view a words hash val with out inseting it.";
		//System.out.println(todo+"run");
		String command = sc.nextLine();

		while (!command.equals("!")){
			//enters 1: the user can add values to the table
			if (command.equals("1")){
				while(!command.equals("#")){
					System.out.println("Enter the word that you want to insert. \"#\" to go back");
					command = sc.nextLine();
					if (!command.equals("#")){
						table.insert(command,definition);
					}
				}
			}
			//enters 2: check if the value is in the table and if it is not you can add it
			if (command.equals("2")){
				while(!command.equals("#")){
					System.out.println("Enter the word that you want to check for existance. \"#\" to go back");
					command = sc.nextLine();
					if (!command.equals("#")){
						boolean contains = table.containsWord(command);
						if (contains){
							System.out.println("the table does contain the word: "+command);
						}
						else{
							System.out.println("Error: \""+command+"\" not found;");
							System.out.println("Do you want to insert the word? y/n");
							String reply =sc.nextLine();
							if (reply.equals("y")){
								table.insert(command,definition);
							}
						}
					}
				}
			}
			//enters 3: print amount of values in the table and the loadFactor
			if (command.equals("3")){
				System.out.println("Table size: "+table.size()+"/"+size);
				System.out.println("Do you want to print the table? y/n");
				String reply = sc.nextLine();
				if (reply.equals("y")){
					table.dump();
				}
			}
			//enters 4: check the hash value of a word and can insert the word if need
			if (command.equals("4")){
				while(!command.equals("#")){
					System.out.println("Enter the word that you want to view. \"#\" to go back");
					command = sc.nextLine();
					if (!command.equals("#")){
						table.view(command);
						System.out.println("Do you want to add the word to the table? y/n");
						String reply = sc.nextLine();
						if (reply.equals("y")){
							table.insert(command,definition);
						}
					}
				}
			}
			System.out.println(todo);
			command = sc.nextLine();
		}
		//quit
		System.out.println("Dumping...");
		table.dump();
		System.out.println("\n\nEnd of operation.");
	}
}