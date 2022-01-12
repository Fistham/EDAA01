package textproc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor {

	private Set<String> stopWords = new HashSet<String>();
	private Map<String, Integer> words = new HashMap<String, Integer>();

	public GeneralWordCounter(Set<String> stopWords) {
		this.stopWords = stopWords;
	}

	public void process(String w) {
		if (!stopWords.contains(w)) {
			if (!words.containsKey(w)) {
				words.put(w, 1);
			} else {
				words.put(w, words.get(w) + 1);
			}
		}
	}

	public void report() {
		for(String key : words.keySet()) {
			if(words.get(key)>=200) {
				System.out.println(key + " : " + words.get(key));
			}
		}
	}

}
