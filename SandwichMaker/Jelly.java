public class Jelly {
	// Instance variables with defaults per spec
	private String name = "none";
	private int calories = 50; // 50..200 inclusive
	private String fruitType = "Grape"; // Apple, Blackberry, Grape, Blueberry, Tomato

	// ----- Constructors -----
	public Jelly() {
	}

	public Jelly(String name, int calories, String fruitType) {
		setName(name);
		setCalories(calories);
		setFruitType(fruitType);
	}

	// ----- Accessors -----
	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}

	public String getFruitType() {
		return fruitType;
	}

	// ----- Mutators with validation -----
	public void setName(String name) {
		this.name = (name != null) ? name : "none";
	}

	public void setCalories(int calories) {
		this.calories = (calories >= 50 && calories <= 200) ? calories : 50;
	}

	public void setFruitType(String fruitType) {
		if (fruitType != null && isAllowedFruit(fruitType)) {
			this.fruitType = normalizedFruit(fruitType);
		} else {
			this.fruitType = "Grape";
		}
	}

	private boolean isAllowedFruit(String f) {
		return f.equalsIgnoreCase("Apple") || f.equalsIgnoreCase("Blackberry") || f.equalsIgnoreCase("Grape")
				|| f.equalsIgnoreCase("Blueberry") || f.equalsIgnoreCase("Tomato");
	}

	private String normalizedFruit(String f) {
		if (f.equalsIgnoreCase("Apple"))
			return "Apple";
		if (f.equalsIgnoreCase("Blackberry"))
			return "Blackberry";
		if (f.equalsIgnoreCase("Grape"))
			return "Grape";
		if (f.equalsIgnoreCase("Blueberry"))
			return "Blueberry";
		return "Tomato";
	}

	// ----- Equality -----
	// Per spec: name and fruitType compared case-insensitively
	public boolean equals(Jelly other) {
		if (other == null)
			return false;
		return this.calories == other.calories && this.name.equalsIgnoreCase(other.name)
				&& this.fruitType.equalsIgnoreCase(other.fruitType);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Jelly))
			return false;
		return equals((Jelly) o);
	}

	@Override
	public String toString() {
		return "Jelly\n" + "Name: " + name + "\n" + "Calories: " + calories + "\n" + "Fruit Type: " + fruitType + "\n";
	}
}
