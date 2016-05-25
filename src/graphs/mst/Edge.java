package graphs.mst;

public class Edge implements Comparable<Edge> {

	protected final Vertex v, w;
	protected final double weight;

	public Edge(Vertex v, Vertex w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public Edge(Vertex v, Vertex w) {
		this.v = v;
		this.w = w;
		this.weight = 1.0;
	}

	public Vertex either() {
		return v;
	}

	public Vertex other(Vertex vertex) {
		return (vertex.equals(v)) ? w : v;
	}

	public int other(int v) {
		return v == this.v.value() ? w.value() : this.v.value();
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Edge that) {
		if (this.weight < that.weight)
			return -1;
		else if (this.weight > that.weight)
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "Edge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
	}

}
