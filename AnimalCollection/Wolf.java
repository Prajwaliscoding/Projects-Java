public class Wolf extends Dog {
	public static final String DEF_PACK_LEADER = "none";
	private String packLeaderName;

	public Wolf() {
		super();
		this.packLeaderName = DEF_PACK_LEADER;
	}

// Order: name, weight, energy, then packLeaderName
	public Wolf(String name, double weight, int energyLevel, String packLeaderName) {
		super(name, weight, energyLevel);
		setPackLeaderName(packLeaderName);
	}

	public String getPackLeaderName() {
		return packLeaderName;
	}

	public void setPackLeaderName(String packLeaderName) {
		if (packLeaderName != null) {
			this.packLeaderName = packLeaderName;
		} else {
			this.packLeaderName = DEF_PACK_LEADER;
		}
	}

	public boolean equals(Wolf other) {
		if (other == null)
			return false;
// name case-insensitive handled by super; pack leader compares normally
		return super.equals(other) && this.packLeaderName.equals(other.packLeaderName);
	}

	public String toString() {
		return super.toString() + "\n" + "Pack Leader: " + this.packLeaderName;
	}
}
