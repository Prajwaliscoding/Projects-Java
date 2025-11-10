public class Dog {
// Instance Variables
	private String name; // non-null
	private DogBreed breed; // enum
	private int age; // >= 0, default 0
	private double weight; // >= 0, default 1.0
// Default values (as required)
	private static final String DEFAULT_NAME = "Unknown";
	private static final DogBreed DEFAULT_BREED = DogBreed.OTHER;
	private static final int DEFAULT_AGE = 0;
	private static final double DEFAULT_WEIGHT = 1.0;

// Default Constructor
	public Dog() {
		this.name = DEFAULT_NAME;
		this.breed = DEFAULT_BREED;
		this.age = DEFAULT_AGE;
		this.weight = DEFAULT_WEIGHT;
	}

// Parameterized Constructor: (name, breed, age, weight) in that order
	public Dog(String name, DogBreed breed, int age, double weight) {
		setName(name);
		setBreed(breed);
		setAge(age);
		setWeight(weight);
	}

// Accessors
	public String getName() {
		return name;
	}

	public DogBreed getBreed() {
		return breed;
	}

	public int getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}

// Mutators (validate; if invalid, set to default)
	public void setName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name.trim();
		} else {
			this.name = DEFAULT_NAME;
		}
	}

	public void setBreed(DogBreed breed) {
		if (breed != null) {
			this.breed = breed;
		} else {
			this.breed = DEFAULT_BREED;
		}
	}

	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			this.age = DEFAULT_AGE;
		}
	}

	public void setWeight(double weight) {
		if (weight >= 0) {
			this.weight = weight;
		} else {
			this.weight = DEFAULT_WEIGHT;
		}
	}

// Equals method: returns true if all properties match
	public boolean equals(Dog other) {
		if (other == null)
			return false;
		if (!this.name.equals(other.name))
			return false;
		if (this.breed != other.breed)
			return false;
		if (this.age != other.age)
			return false;
		if (Double.compare(this.weight, other.weight) != 0)
			return false;
		return true;
	}

// toString
	@Override
	public String toString() {
		return "[Dog] Name: " + this.name + " Breed: " + this.breed + " Age: " + this.age + " Weight: " + this.weight;
	}
}
