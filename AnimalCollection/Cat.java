public class Cat extends Animal {
	public static final String DEF_MOOD = "sleepy";
	private String mood;

	public Cat() {
		super();
		this.mood = DEF_MOOD;
	}

// Order: inherited first (name, weight) then this class (mood)
	public Cat(String name, double weight, String mood) {
		super(name, weight);
		setMood(mood);
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		if (mood != null && (mood.equalsIgnoreCase("sleepy") || mood.equalsIgnoreCase("playful")
				|| mood.equalsIgnoreCase("hungry"))) {
// store as given
			this.mood = mood;
		} else {
			this.mood = DEF_MOOD;
		}
	}

// Typed equals: all instance variables must match.
// Name ignores case (handled by Animal.equals), mood compares normally.
	public boolean equals(Cat other) {
		if (other == null)
			return false;
		return super.equals(other) && this.mood.equals(other.mood);
	}

	public String toString() {
		return super.toString() + "\n" + "Mood: " + this.mood;
	}
}
