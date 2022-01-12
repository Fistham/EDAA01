package textproc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {
	// Until D14
	//	private Map<String, Integer> wordMap = new HashMap<String, Integer>();
	
	// From D14
	private Map<String, Integer> wordMap = new TreeMap<String, Integer>();

	public MultiWordCounter(String[] words) {
		for (int i = 0; i < words.length; i++) {
			wordMap.put(words[i], 0);
		}
	}

	public void process(String w) {

		if (wordMap.containsKey(w)) {
			wordMap.put(w, wordMap.get(w) + 1);
		}

	}

	public void report() {
		for (String key : wordMap.keySet()) {
			System.out.println(key + ": " + wordMap.get(key));
		}
	}

}
