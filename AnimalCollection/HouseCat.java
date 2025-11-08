public class HouseCat extends Cat {
	public static final String DEF_TYPE = "short hair";
	private String type;

	public HouseCat() {
		super();
		this.type = DEF_TYPE;
	}

// Order: name, weight, mood, then type
	public HouseCat(String name, double weight, String mood, String type) {
		super(name, weight, mood);
		setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type != null && (type.equalsIgnoreCase("short hair") || type.equalsIgnoreCase("ragdoll")
				|| type.equalsIgnoreCase("sphinx") || type.equalsIgnoreCase("Scottish fold"))) {
			this.type = type;
		} else {
			this.type = DEF_TYPE;
		}
	}

// Typed equals: all fields must match; name & type ignore case
	public boolean equals(HouseCat other) {
		if (other == null)
			return false;
		boolean baseOk = super.equals(other);
		boolean typeOk = this.type.equalsIgnoreCase(other.type);
		return baseOk && typeOk;
	}

	public String toString() {
		return super.toString() + "\n" + "Type: " + this.type;
	}
}
