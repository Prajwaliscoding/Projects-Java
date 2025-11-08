public class DomesticDog extends Dog {
	public static final String DEF_TYPE = "retriever";
	private String type;

	public DomesticDog() {
		super();
		this.type = DEF_TYPE;
	}

// Order: name, weight, energy, then type
	public DomesticDog(String name, double weight, int energyLevel, String type) {
		super(name, weight, energyLevel);
		setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type != null && (type.equalsIgnoreCase("retriever") || type.equalsIgnoreCase("terrier")
				|| type.equalsIgnoreCase("husky") || type.equalsIgnoreCase("mutt"))) {
			this.type = type;
		} else {
			this.type = DEF_TYPE;
		}
	}

// Typed equals: all fields must match; name & type are case-insensitive
	public boolean equals(DomesticDog other) {
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
