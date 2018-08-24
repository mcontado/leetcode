package easy;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortDataInLogFile {
	
	/**
	 * Sorts data in log file.
	 * @param logFileSize The size of log
	 * @param logFile The list of String for logFile
	 * @return the result list of String
	 */
	public static List<String> sortData(final int logFileSize, final List<String> logFile) {
		List<String> result = new ArrayList<>();
		// hold list of indices for lines with numbers in file
		List<Integer> lineNumbers = new ArrayList<>();
		// Sorted map so that the key will be sorted when adding to the map
		SortedMap<String, List<SimpleEntry>> mapOfWordsAndIdentifierPairs = new TreeMap<>();
		
		for (int i=0; i<logFileSize; i++) {
			// Create a string array for each line
			final String[] arrLines = logFile.get(i).toLowerCase().split("\\s+");
			// Check the 2nd index in the current line if the the zeroeth (first char) is digit
			if (Character.isDigit(arrLines[1].charAt(0))) {
				lineNumbers.add(i);
			} else {
				final StringBuilder stringKey = new StringBuilder();
				// we started at 1 index because that is the second value in the list.
				for (int j=1; j<arrLines.length; j++) {
					stringKey.append(arrLines[j]);
				}
				// i is the current index in the logLines loop
				// arrLines[0] is the first word in each line that marked as identifier.
				final SimpleEntry<String, Integer> entryPair = new SimpleEntry(arrLines[0], i);
				
				// the string key exists in the map, therefore add it to the list of simple entry pair.
				if (mapOfWordsAndIdentifierPairs.containsKey(stringKey.toString())) {
					mapOfWordsAndIdentifierPairs.get(stringKey.toString()).add(entryPair);
				} else {
					final List<SimpleEntry> listOfSimpleEntry = new ArrayList<>();
					listOfSimpleEntry.add(entryPair);
					mapOfWordsAndIdentifierPairs.put(stringKey.toString(), listOfSimpleEntry);
				}
			}		
		}
					
		sortMapValuesAndAddToResult(mapOfWordsAndIdentifierPairs, result, logFile);
		
		// lastly add those lines from lineNumbers list
		for (int n: lineNumbers) {
			result.add(logFile.get(n));
		}
		return result;
	}
	
	public static void sortMapValuesAndAddToResult(
			final SortedMap<String, List<SimpleEntry>> mySortedKeysMap,
			final List<String> result, 
			final List<String> logFile) {
		
		for (Entry<String, List<SimpleEntry>> entry: mySortedKeysMap.entrySet()) {
			// if the value size is just 1, no need to sort, just add it directly to the result file
			if (entry.getValue().size() == 1) {
				final int index = (int) entry.getValue().get(0).getValue();
				result.add(logFile.get(index));
			} else {
				// sort the identifier by key
				List<SimpleEntry> mySortedIdentifier = 
						entry.getValue()
						.stream()
						.sorted(Comparator.comparing(SimpleEntry<String, Integer>::getKey))
						.collect(Collectors.toList());
				
				// After soring, add it to the result
				for (final SimpleEntry simpleEntry: mySortedIdentifier) {
					final int index = (int) simpleEntry.getValue();
					result.add(logFile.get(index));
				}
			}
		}
	}

	public static void main(String[] args) {
		// TEST CASE 1:
		int logFileSize = 4;
		List<String> logLines = new ArrayList<>();
		logLines.add("mi2 jog mid pet");
		logLines.add("wz3 34 54 398");
		logLines.add("a1 alps cow bar");
		logLines.add("x4 45 21 7");
		
		System.out.println(sortData(logFileSize, logLines));
		
		// TEST CASE 1:
		int logFileSize2 = 6;
		List<String> logLines2 = new ArrayList<>();
		logLines2.add("t2 13 121 98");
		logLines2.add("r1 box ape bit");
		logLines2.add("b4 xi me nu");
		logLines2.add("br8 eat num did");
		logLines2.add("w1 has uni gry");
		logLines2.add("f3 52 54 31");
				
		System.out.println(sortData(logFileSize2, logLines2));
		
	}

}
