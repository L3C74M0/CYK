//Thanks to mynttt. All rights reserved.  
package model;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class CYK {

	protected static String word;
	protected static String startingSymbol;
    public static ArrayList<String> terminals = new ArrayList<String>();
    public static ArrayList<String> nonTerminals = new ArrayList<String>();
	protected static TreeMap<String, ArrayList<String>> grammar = new TreeMap<>();

	public static boolean doSteps(String w) {
		word = w;
		String[][] cykTable = createCYKTable();
		return doCYK(doCyk(cykTable));
	}

	public static boolean doCYK(String[][] cykTable) {
		if (cykTable[cykTable.length - 1][cykTable[cykTable.length - 1].length - 1].contains(startingSymbol)) {
			return true;
		} else {
			return false;
		}
	}

	public static int findLongestString(String[][] cykTable) {
		int temp = 0;
		for (String[] s : cykTable) {
			for (String d : s) {
				if (d.length() > temp) {
					temp = d.length();
				}
			}
		}
		return temp;
	}

	//Jagged Array for the Algorithm
	public static String[][] createCYKTable() {
		int length = word.length();

		String[][] cykTable = new String[length + 1][];
		cykTable[0] = new String[length];
		for (int i = 1; i < cykTable.length; i++) {
			cykTable[i] = new String[length - (i - 1)];
		}
		for (int i = 1; i < cykTable.length; i++) {
			for (int j = 0; j < cykTable[i].length; j++) {
				cykTable[i][j] = "";
			}
		}
		return cykTable;
	}

	public static String[][] doCyk(String[][] cykTable) {
		// Step 1: Fill header row
		for (int i = 0; i < cykTable[0].length; i++) {
			cykTable[0][i] = manageWord(word, i);
		}
		// Step 2: Get productions for terminals
		for (int i = 0; i < cykTable[1].length; i++) {
			String[] validCombinations = checkIfProduces(new String[] { cykTable[0][i] });
			cykTable[1][i] = toString(validCombinations);
		}
		if (word.length() <= 1) {
			return cykTable;
		}
		// Step 3: Get productions for subwords with the length of 2
		for (int i = 0; i < cykTable[2].length; i++) {
			String[] downwards = toArray(cykTable[1][i]);
			String[] diagonal = toArray(cykTable[1][i + 1]);
			String[] validCombinations = checkIfProduces(getAllCombinations(downwards, diagonal));
			cykTable[2][i] = toString(validCombinations);
		}
		if (word.length() <= 2) {
			return cykTable;
		}
		// Step 3: Get productions for subwords with the length of n
		TreeSet<String> currentValues = new TreeSet<String>();

		for (int i = 3; i < cykTable.length; i++) {
			for (int j = 0; j < cykTable[i].length; j++) {
				for (int compareFrom = 1; compareFrom < i; compareFrom++) {
					String[] downwards = cykTable[compareFrom][j].split("\\s");
					String[] diagonal = cykTable[i - compareFrom][j + compareFrom].split("\\s");
					String[] combinations = getAllCombinations(downwards, diagonal);
					String[] validCombinations = checkIfProduces(combinations);
					if (cykTable[i][j].isEmpty()) {
						cykTable[i][j] = toString(validCombinations);
					} else {
						String[] oldValues = toArray(cykTable[i][j]);
						ArrayList<String> newValues = new ArrayList<String>(Arrays.asList(oldValues));
						newValues.addAll(Arrays.asList(validCombinations));
						currentValues.addAll(newValues);
						cykTable[i][j] = toString(currentValues.toArray(new String[currentValues.size()]));
					}
				}
				currentValues.clear();
			}
		}
		return cykTable;
	}

	public static String manageWord(String word, int position) {
		return Character.toString(word.charAt(position));
	}

	public static String[] checkIfProduces(String[] toCheck) {
		ArrayList<String> storage = new ArrayList<>();
		for (String s : grammar.keySet()) {
			for (String current : toCheck) {
				if (grammar.get(s).contains(current)) {
					storage.add(s);
				}
			}
		}
		if (storage.size() == 0) {
			return new String[] {};
		}
		return storage.toArray(new String[storage.size()]);
	}

	public static String[] getAllCombinations(String[] from, String[] to) {
		int length = from.length * to.length;
		int counter = 0;
		String[] combinations = new String[length];
		if (length == 0) {
			return combinations;
		}
		
		for (int i = 0; i < from.length; i++) {
			for (int j = 0; j < to.length; j++) {
				combinations[counter] = from[i] + to[j];
				counter++;
			}
		}
		return combinations;
	}

	public static String toString(String[] input) {
		return Arrays.toString(input).replaceAll("[\\[\\]\\,]", "");
	}

	public static String[] toArray(String input) {
		return input.split("\\s");
	}
	
	public static void parseGrammar() throws FileNotFoundException{
		File file = new File("grammar.txt");
        Scanner input = new Scanner(file);
        ArrayList<String> tmp = new ArrayList<>();
        int line = 2;

        startingSymbol = input.next();
        input.nextLine();

        while(input.hasNextLine() && line <= 3){
            tmp.addAll(Arrays.<String>asList(toArray(input.nextLine())));
            if(line == 2) { terminals.addAll(tmp); }
            if(line == 3) { nonTerminals.addAll(tmp); }
            tmp.clear();
            line++;
        }

        while(input.hasNextLine()){
            tmp.addAll(Arrays.<String>asList(toArray(input.nextLine())));
            String leftSide = tmp.get(0);
            tmp.remove(0);
            grammar.put(leftSide, new ArrayList<String>());
            grammar.get(leftSide).addAll(tmp);
            tmp.clear();
        }
        input.close();
    }
}