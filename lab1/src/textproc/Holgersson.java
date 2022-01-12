package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

//		SingleWordCounter exercise		
//
//		TextProcessor p1 = new SingleWordCounter("nils");
//		TextProcessor p2 = new SingleWordCounter("norge");
//		ArrayList<TextProcessor> list = new ArrayList<>();
//		list.add(p1);
//		list.add(p2);
//
//		while (s.hasNext()) {
//			String word = s.next().toLowerCase();
//			for (int i = 0; i < list.size(); i++) {
//				list.get(i).process(word);
//			}
//		}
//
//		for (int i = 0; i < list.size(); i++) {
//			list.get(i).report();
//		}

//		MultiWordCounter exercise
//
//		TextProcessor p = new MultiWordCounter(REGIONS);
//
//		while (s.hasNext()) {
//			String word = s.next().toLowerCase();
//			p.process(word);
//
//		}
//
//		p.report();

//		GeneralWordCounter

		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopWords = new HashSet<String>();

		while (scan.hasNext()) {
			stopWords.add(scan.next());
		}
		scan.close();

		TextProcessor p = new GeneralWordCounter(stopWords);

		while (s.hasNext()) {
			p.process(s.next().toLowerCase());
		}

		s.close();

		p.report();

	}
}