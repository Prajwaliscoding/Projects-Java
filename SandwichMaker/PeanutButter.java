public class PeanutButter {
	// Instance variables with defaults per spec
	private String name = "none";
	private int calories = 100; // 100..300 inclusive
	private boolean isCrunchy = false;

	// ----- Constructors -----
	public PeanutButter() {
	}

	public PeanutButter(String name, int calories, boolean isCrunchy) {
		setName(name);
		setCalories(calories);
		setCrunchy(isCrunchy);
	}

	// ----- Accessors -----
	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}

	public boolean getIsCrunchy() {
		return isCrunchy;
	}

	// ----- Mutators with validation -----
	public void setName(String name) {
		// must not be null; default "none"
		this.name = (name != null) ? name : "none";
	}

	public void setCalories(int calories) {
		// 100..300 inclusive; else default 100
		this.calories = (calories >= 100 && calories <= 300) ? calories : 100;
	}

	public void setCrunchy(boolean isCrunchy) {
		this.isCrunchy = isCrunchy; // boolean always valid
	}

	// ----- Equality -----
	// Per spec: names compared case-insensitively
	public boolean equals(PeanutButter other) {
		if (other == null)
			return false;
		return this.calories == other.calories && this.isCrunchy == other.isCrunchy
				&& this.name.equalsIgnoreCase(other.name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PeanutButter))
			return false;
		return equals((PeanutButter) o);
	}

	@Override
	public String toString() {
		return "Peanut Butter\n" + "Name: " + name + "\n" + "Calories: " + calories + "\n" + "Is Crunchy: " + isCrunchy
				+ "\n";
	}
}
