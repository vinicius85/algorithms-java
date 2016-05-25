package graphs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuildAdjacencyList {

	public static void createAdjacencyList(String input, String output, Traversal traversal, boolean isReverse)
			throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(input));
		BufferedWriter writer = new BufferedWriter(new FileWriter(output));

		writer.write(reader.lines().count() + "\n");

		reader.close();
		reader = new BufferedReader(new FileReader(input));

		reader.lines().forEach(line -> {
			String[] rel = line.split(":");
			String vertex = rel[0];
			String[] vertices = rel[1].split(" ");
			List<String> orderedVertices = Arrays.asList(vertices);
			if (traversal == Traversal.POST_ORDER) {
				Collections.reverse(orderedVertices);
			}
			for (String v : orderedVertices) {
				try {
					if (!isReverse) {
						writer.write(vertex.charAt(0) + " " + v.charAt(0) + "\n");
					} else {
						writer.write(v.charAt(0) + " " + vertex.charAt(0) + "\n");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		reader.close();
		writer.close();
	}

	public static void main(String[] args) throws IOException {
		// BuildAdjacencyList.createAdjacencyList("src/resources/graph-input",
		// "src/resources/graph-output");
	}

}
