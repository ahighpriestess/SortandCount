import java.util.*;
import java.io.*;

public class SortandCount {

	public static void main(String[] args) {
		String fileName = "";
		String text = "";
		int count = 0;
		String data = "";
		String data2 = "";
		LinkedList<String> list = new LinkedList<>();
		Map<String, Integer> treeMap = new TreeMap<String, Integer>();
		try (Scanner input = new Scanner(System.in)) {

			if (args.length > 0) {
				fileName = args[0];
			} else {
				System.out.println("Welcome to Sort and Count! ");
				System.out.println("Enter file name: ");
				fileName = input.nextLine();
			}

			try {
				File theFile = new File(fileName);
				try (Scanner file = new Scanner(theFile)) {
					while (file.hasNext()) {
						text = text + " " + file.nextLine();
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.toString());
			}

			String[] theText = text.split("[^A-Za-z0-9\s+]");
			LinkedList<String> temp = new LinkedList<String>();

			for (int i = 0; i < theText.length; i++) {
				temp.add(theText[i]);
			}

			boolean theLower = false;

			for (int i = 0; i < temp.size(); i++) {
				String word = temp.get(i).toLowerCase();
				String word2 = temp.get(i);
				for (int j = 0; j < temp.size(); j++) {
					if (word.equals(temp.get(j))) {
						theLower = true;
					}

				}
				if (theLower == true) {
					list.add(word);
				} else if (theLower != true) {
					list.add(word2);
				}
				theLower = false;
			}

			String listString = "";
			for (String s : list) {
				listString += s + " ";
			}

			Map<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
			String[] words = listString.split(" ");
			for (int i = 0; i < words.length; i++) {
				String key = words[i];
				if (key.length() > 0) {
					if (!map.containsKey(key)) {
						map.put(key, 1);
					} else {
						int value = map.get(key);
						value++;
						map.put(key, value);
					}
				}
			}
			Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
			
			for(Map.Entry<String, Integer> e: entrySet) 
			{
				System.out.println(e.getKey() + " [" + e.getValue() + "]");
			}
		}
		
	}
}