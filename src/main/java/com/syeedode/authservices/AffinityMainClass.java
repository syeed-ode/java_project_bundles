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
import java.util.Objects;

import static com.syeedode.authservices.graphs.GTraversalStateEnum.*;
import static com.syeedode.authservices.graphs.GTraversalStateEnum.VISITED;

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
		Node beginNode = n[0];
		Node endNode   = n[6];

		System.out.println("\n\nThere is"
				+  (search(g,beginNode,endNode) ? " a connection " : " no connection " )
				+ "between these two nodes.");
	}

	public static Graph valueOf() {
		Graph g = new Graph();
		Node[] temp = new Node[7];
		temp[0] = Node.valueOf("a", 3);
		temp[1] = Node.valueOf("b", 0);
		temp[2] = Node.valueOf("c", 0);
		temp[3] = Node.valueOf("d", 1);
		temp[4] = Node.valueOf("e", 1);
		temp[5] = Node.valueOf("f", 0);
		temp[6] = Node.valueOf("g", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		temp[2].addAdjacent(temp[6]);
		for (int i = 0; i < temp.length; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

	public static boolean search(Graph graph, Node start, Node end) {

		if(Objects.isNull(start) || Objects.isNull(end)) return false;

		if(start.equals(end)) return true;

		LinkedList<Node> q = new LinkedList<>();

		// Initialize state

		start.setState(VISITING);
		q.add(start);
		Node u;

		while(!q.isEmpty()) {
			u = q.removeFirst();
			if(Objects.nonNull(u)) {
				if(Objects.nonNull(u.getAdjacent())) {
					for(Node adjacentNode : u.getAdjacent()) {
						if(Objects.nonNull(adjacentNode)){
							if(adjacentNode.getState().equals(UNVISITED)) {
								if(adjacentNode.equals(end)) {
									return true;
								} else {
									adjacentNode.setState(VISITING);
									q.add(adjacentNode);
								}
							}
						}
					}
					u.setState(VISITED);
				}
			}
		}
		return false;
	}


}
