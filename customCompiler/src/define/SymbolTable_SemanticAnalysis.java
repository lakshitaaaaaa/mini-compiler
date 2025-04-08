package define;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable_SemanticAnalysis {
	private final Map<String,String> table = new HashMap<>();
	
	public void define(String name, String type) {
		table.put(name, type);
	}
	
	public String lookup(String name) {
		return table.get(name);
	}
	
	public void printTable() {
	    System.out.println("\n---- SYMBOL TABLE ----\n");
	    for (Map.Entry<String, String> entry : table.entrySet()) {
	        System.out.println("Name: " + entry.getKey() + "  |  Type: " + entry.getValue());
	    }
	}


}
