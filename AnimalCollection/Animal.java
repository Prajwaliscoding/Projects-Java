public class Animal {
// Defaults from spec
	public static final String DEF_NAME = "none";
	public static final double DEF_WEIGHT = 1.0;
// Instance variables
	private String name;
	private double weight;

// Default constructor sets defaults
	public Animal() {
		this.name = DEF_NAME;
		this.weight = DEF_WEIGHT;
	}

// Parameterized constructor: order matches variables (name, weight)
	public Animal(String name, double weight) {
		setName(name);
		setWeight(weight);
	}

// Accessors
	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

// Mutators with validation
	public void setName(String name) {
		if (name != null) {
			this.name = name;
		} else {
			this.name = DEF_NAME;
		}
	}

	public void setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			this.weight = DEF_WEIGHT;
		}
	}

// Typed equals as in spec (not overriding Object.equals)
// Name compared ignoring case, other fields compare normally.
	public boolean equals(Animal other) {
		if (other == null)
			return false;
		boolean nameSame = this.name.equalsIgnoreCase(other.name);
		boolean weightSame = this.weight == other.weight;
		return nameSame && weightSame;
	}

// String with all fields
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name : ").append(this.name).append("\n");
		sb.append("Weight: ").append(this.weight);
		return sb.toString();
	}
}
