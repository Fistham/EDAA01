package textproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor {

//	Until D14
//	private Map<String, Integer> words = new HashMap<String, Integer>();
	private Set<String> stopWords = new HashSet<String>();
	private Map<String, Integer> words = new TreeMap<String, Integer>();

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
		Set<Map.Entry<String, Integer>> wordSet = words.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(new WordCountComparator());

		for (int i = 0; i < 25; i++) {
			System.out.println(wordList.get(i));
		}

//		Sets minimum limit of word count to 200 (from previous exercise)		

//		for(String key : words.keySet()) {
//			if(words.get(key)>=200) {
//				System.out.println(key + " : " + words.get(key));
//			}
//		}
	}

}
