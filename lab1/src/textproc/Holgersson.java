package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {

//		SingleWordCounter solution in main		
//
//		TextProcessor p1 = new SingleWordCounter("nils");
//		TextProcessor p2 = new SingleWordCounter("norge");
//		ArrayList<TextProcessor> list = new ArrayList<>();
//		list.add(p1);
//		list.add(p2);
//
//		Scanner s = new Scanner(new File("nilsholg.txt"));
//		s.findWithinHorizon("\uFEFF", 1);
//		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
//
//		while (s.hasNext()) {
//			String word = s.next().toLowerCase();
//			for (int i = 0; i < list.size(); i++) {
//				list.get(i).process(word);
//			}
//		}
//
//		s.close();
//		for (int i = 0; i < list.size(); i++) {
//			list.get(i).report();
//		}

//		MultiWordCounter solution in main

		TextProcessor p = new MultiWordCounter(REGIONS);

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			p.process(word);

		}

		p.report();

	}
}