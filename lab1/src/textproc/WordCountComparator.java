package textproc;

import java.util.*;
import java.util.Map.Entry;

public class WordCountComparator implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

		int compare = o2.getValue().compareTo(o1.getValue());
		if (compare != 0) {
			return compare;
		} else {
			return o2.getKey().compareTo(o1.getKey());
		}

	}

}
