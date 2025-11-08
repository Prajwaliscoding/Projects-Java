public class Dog extends Animal {
	public static final int DEF_ENERGY = 50;
	private int energyLevel;

	public Dog() {
		super();
		this.energyLevel = DEF_ENERGY;
	}

// Order: name, weight, then energyLevel
	public Dog(String name, double weight, int energyLevel) {
		super(name, weight);
		setEnergyLevel(energyLevel);
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		if (energyLevel >= 0 && energyLevel <= 100) {
			this.energyLevel = energyLevel;
		} else {
			this.energyLevel = DEF_ENERGY;
		}
	}

// Typed equals: name ignore case via super, energy matches exactly
	public boolean equals(Dog other) {
		if (other == null)
			return false;
		return super.equals(other) && this.energyLevel == other.energyLevel;
	}

	public String toString() {
		return super.toString() + "\n" + "Energy Level: " + this.energyLevel;
	}
}
