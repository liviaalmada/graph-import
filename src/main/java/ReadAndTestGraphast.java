import org.graphast.model.EdgeImpl;
import org.graphast.model.GraphImpl;

public class ReadAndTestGraphast {
	public static void main(String[] args) {
		String graphast = "/Users/liviaalmada/git/graph-data/graphast/";

		GraphImpl graph = new GraphImpl(graphast);
		graph.load();
		System.out.println(graph.getEdge(1).getLabel());
		org.graphast.model.Edge e = graph.getEdge(2);
		long fromNode = e.getFromNode();
		System.out.println(fromNode);
		System.out.println(graph.getNode(fromNode).getExternalId());
		long toNode = e.getToNode();
		System.out.println(toNode);
		System.out.println(graph.getNode(toNode).getExternalId());
		
		EdgeImpl edge = (EdgeImpl)graph.getEdge(fromNode, toNode);
		System.out.println(edge.getExternalId());
	}
}
