package com.syeedode.authservices;

import com.syeedode.authservices.affinity.AffMapPrinter;
import com.syeedode.authservices.affinity.Affinity;
import com.syeedode.authservices.affinity.AffinityCalculater;
import com.syeedode.authservices.affinity.AffinityFileReader;
import com.syeedode.authservices.trees.NodeForTree;

import java.util.List;
import java.util.Map;

public class AffinityMainClass {

	private static final String FILENAME = "/Users/syeedode/java_projects/auth/src/convertToAtlassian/resources/affinityFile";

	public static void main(String[] args) {
		AffinityFileReader affinityReader = new AffinityFileReader();
		List<Affinity> affinities = affinityReader.readFile(FILENAME);

		AffinityCalculater calculater = new AffinityCalculater();

		Map<List<String>,Integer> stringListMap = calculater.calculateAffinity(affinities);


		AffMapPrinter printer = new AffMapPrinter();
		System.out.println("\n\n\n" + "Clearing the board for the final showing: " + "\n\n\n");
		printer.printAffinityMap(stringListMap);
		System.out.println("\n\n\n" + "Clearing the board for the final showing: " + "\n\n\n");
		printer.printHighestAffinity(stringListMap);
	}

}
