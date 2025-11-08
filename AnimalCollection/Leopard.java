public class Leopard extends Cat {
	public static final int DEF_SPOTS = 1;
	private int numberOfSpots;

	public Leopard() {
		super();
		this.numberOfSpots = DEF_SPOTS;
	}

// Order: name, weight, mood, then spots
	public Leopard(String name, double weight, String mood, int numberOfSpots) {
		super(name, weight, mood);
		setNumberOfSpots(numberOfSpots);
	}

	public int getNumberOfSpots() {
		return numberOfSpots;
	}

	public void setNumberOfSpots(int numberOfSpots) {
		if (numberOfSpots >= 1) {
			this.numberOfSpots = numberOfSpots;
		} else {
			this.numberOfSpots = DEF_SPOTS;
		}
	}

	public boolean equals(Leopard other) {
		if (other == null)
			return false;
		return super.equals(other) && this.numberOfSpots == other.numberOfSpots;
	}

	public String toString() {
		return super.toString() + "\n" + "Number of Spots: " + this.numberOfSpots;
	}
}
