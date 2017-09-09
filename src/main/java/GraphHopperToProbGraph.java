
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.graphast.importer.OSMImporterImpl;
import org.graphast.model.EdgeImpl;
import org.graphast.model.GraphImpl;

public class GraphHopperToProbGraph {

	public static void main(String[] args) {

		String osmFile = "/Users/liviaalmada/Dataset Beijing/Beijing.osm";
		// "/Users/liviaalmada/git/graph-data/osm-fortaleza.osm";
		String graphastDir = "/Users/liviaalmada/git/graph-data/graphast-beijing/";
		// "/Users/liviaalmada/git/graph-data/graphast/"
		String graphhopperDir = "/Users/liviaalmada/git/graph-data/graph-hopper/beijing";
		//"/Users/liviaalmada/git/graph-data/graph-hopper/ghnetwork"
		String pathname = "/Users/liviaalmada/git/graph-data/fortal-graphast-to-graphhopper-map-beijing";
		//"/Users/liviaalmada/git/graph-data/fortal-graphast-to-graphhopper-map"
		
		GraphImpl graph = (GraphImpl) new OSMImporterImpl(osmFile, graphhopperDir, graphastDir).execute();
		System.out.println("Number of nodes:" + graph.getNumberOfNodes());
		System.out.println("Number of edges:" + graph.getNumberOfEdges());
		graph.save();

		try {
			// Define file mapping from edges

			FileWriter writer = new FileWriter(new File(pathname));
			for (int i = 0; i < graph.getNumberOfEdges(); i++) {
				EdgeImpl edge = (EdgeImpl) graph.getEdge(i);
				writer.write(edge.getId() + "," + edge.getExternalId() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
