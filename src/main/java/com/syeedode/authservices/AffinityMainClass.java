package com.syeedode.authservices;

import com.syeedode.authservices.affinity.AffMapPrinter;
import com.syeedode.authservices.affinity.Affinity;
import com.syeedode.authservices.affinity.AffinityCalculater;
import com.syeedode.authservices.affinity.AffinityFileReader;
import com.syeedode.authservices.graphs.GTraversalStateEnum;
import com.syeedode.authservices.graphs.Graph;
import com.syeedode.authservices.graphs.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AffinityMainClass {

	private static final String FILENAME = "/Users/syeedode/java_projects/auth/src/main/resources/affinityFile";

	public static void man(String[] args) {
		AffinityFileReader affinityReader = new AffinityFileReader();
		List<Affinity> affinities = affinityReader.readFile(FILENAME);

		AffinityCalculater calculater = new AffinityCalculater();

		Map<List<String>,Integer> stringListMap = calculater.calculateAffinity(affinities);


		AffMapPrinter printer = new AffMapPrinter();
		System.out.println("\n\n\n" + "Clearing the board for the final showing: " + "\n\n\n");
		printer.printAffinityMap(stringListMap);
	}

	public static void main(String[] args) {
		Graph g = AffinityMainClass.valueOf();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end   = n[5];
	}

	public static Graph valueOf() {
		Graph g = new Graph();
		Node[] temp = new Node[];
		temp[0] = Node.valueOf("a", 3);
		temp[1] = Node.valueOf("b", 0);
		temp[2] = Node.valueOf("c", 0);
		temp[3] = Node.valueOf("d", 1);
		temp[4] = Node.valueOf("e", 1);
		temp[5] = Node.valueOf("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

	public static boolean search(Graph graph, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<>();

		// Initialize state
		for(Node u : graph.getNodes()){
			u.setState(GTraversalStateEnum.UNVISITED);
		}

		
	}


}
