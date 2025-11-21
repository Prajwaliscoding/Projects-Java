public class Bread {
	// Instance variables with defaults per spec
	private String name = "none";
	private int calories = 50; // 50..250 inclusive
	private String type = "Whole Grain"; // one of allowed types

	// ----- Constructors -----
	public Bread() {
		/* defaults already set above */ }

	public Bread(String name, int calories, String type) {
		setName(name);
		setCalories(calories);
		setType(type);
	}

	// ----- Accessors -----
	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}

	public String getType() {
		return type;
	}

	// ----- Mutators with validation -----
	public void setName(String name) {
		// must not be null; default "none"
		this.name = (name != null) ? name : "none";
	}

	public void setCalories(int calories) {
		// 50..250 inclusive; otherwise default 50
		this.calories = (calories >= 50 && calories <= 250) ? calories : 50;
	}

	public void setType(String type) {
		// Allowed: “Honey Wheat”, “White”, “Whole Grain”, “Whole Wheat”
		if (type != null && isAllowedType(type)) {
			this.type = normalizedBreadType(type);
		} else {
			this.type = "Whole Grain";
		}
	}

	// Helper: check allowed bread types (case-insensitive)
	private boolean isAllowedType(String t) {
		return t.equalsIgnoreCase("Honey Wheat") || t.equalsIgnoreCase("White") || t.equalsIgnoreCase("Whole Grain")
				|| t.equalsIgnoreCase("Whole Wheat");
	}

	// Normalize casing to match one of the allowed strings (nice for printing)
	private String normalizedBreadType(String t) {
		if (t.equalsIgnoreCase("Honey Wheat"))
			return "Honey Wheat";
		if (t.equalsIgnoreCase("White"))
			return "White";
		if (t.equalsIgnoreCase("Whole Grain"))
			return "Whole Grain";
		return "Whole Wheat";
	}

	// ----- Equality -----
	// Per spec: takes another Bread and returns true if ALL fields match (name/type
	// ignore case)
	public boolean equals(Bread other) {
		if (other == null)
			return false;
		return this.calories == other.calories && this.name.equalsIgnoreCase(other.name)
				&& this.type.equalsIgnoreCase(other.type);
	}

	// Java best practice: also override Object.equals for collections / consistency
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Bread))
			return false;
		return equals((Bread) o);
	}

	@Override
	public String toString() {
		// Concatenate all instance variable values (formatted for readability)
		return "Bread\n" + "Name: " + name + "\n" + "Calories: " + calories + "\n" + "Type: " + type + "\n";
	}
}
