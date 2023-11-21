package malecluk.AoC2022.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Path to input file
		String inputFilePath = "data/input.txt";

		File inputFile = new File(inputFilePath);

		Scanner sc = null;
		try {
			// Let's use scanner for file and use new line as a delimiter
			sc = new Scanner(inputFile);
			sc.useDelimiter("\n");

			// on which position (which one of the Elves) we are
			int position = 0;
			
			// total calories per one of the Elves
			int total = 0;
			
			// List for all totals to find max(es) easily, using Integer to be able to easily remove items per value
			ArrayList<Integer> totals = new ArrayList<Integer>();

			while (sc.hasNext()) {
				String nextLine = sc.next().trim();

				if (nextLine.length() == 0) {
					// check empty line - reset counters and store results
					Integer i = Integer.valueOf(total);
					totals.add(position, i);
					position++;
					total = 0;
				} else {
					// no empty line - just add new number to current total
					int current = Integer.parseInt(nextLine); // expecting always int here, no check for other value
					total = total + current;
				}
			}
			
			// dirty counter for sum of all three max values
			int sumOfThree = 0;

			// get first max
			Integer max1 = Collections.max(totals);
			sumOfThree = sumOfThree + max1;
			System.out.println("max 1: " + max1);

			// remove current max from list
			totals.remove(max1);

			// find another maximum
			Integer max2 = Collections.max(totals);
			sumOfThree = sumOfThree + max2;
			System.out.println("max 2: " + max2);

			totals.remove(max2);

			Integer max3 = Collections.max(totals);
			sumOfThree = sumOfThree + max3;
			System.out.println("max 3: " + max3);

			System.out.println("Sum max. three: " + sumOfThree);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
