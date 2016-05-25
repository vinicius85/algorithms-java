package graphs.mst;

public class Vertex {

	private final Character name;

	public Vertex(Character name) {
		this.name = name;
	}

	public int value() {
		return name.charValue() - 65;
	}

	public int index() {
		return name.charValue();
	}

	public Character getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + "]";
	}
	
	

}
