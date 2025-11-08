public class AnimalCollection {
// Class constant and storage
	public static final int DEF_SIZE = 100;
	private Animal[] animals;

	public AnimalCollection() {
		animals = new Animal[DEF_SIZE];
	}

// Adds at the first empty slot; if full, does nothing.
	public void addAnimal(Animal a) {
		if (a == null)
			return;
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] == null) {
				animals[i] = a;
				return;
			}
		}
// full: nothing happens
	}

// Removes first matching animal (by data). If not found, nothing happens.
	public void removeAnimal(Animal target) {
		if (target == null)
			return;
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] != null && equalsByType(animals[i], target)) {
// compact the array to keep order neat
				for (int j = i; j < animals.length - 1; j++) {
					animals[j] = animals[j + 1];
				}
				animals[animals.length - 1] = null;
				return;
			}
		}
	}

// Helper that calls the right typed equals (as required by the spec)
	private boolean equalsByType(Animal a, Animal b) {
		if (a.getClass() != b.getClass())
			return false;
		if (a instanceof HouseCat) {
			return ((HouseCat) a).equals((HouseCat) b);
		} else if (a instanceof Leopard) {
			return ((Leopard) a).equals((Leopard) b);
		} else if (a instanceof DomesticDog) {
			return ((DomesticDog) a).equals((DomesticDog) b);
		} else if (a instanceof Wolf) {
			return ((Wolf) a).equals((Wolf) b);
		} else if (a instanceof Cat) {
			return ((Cat) a).equals((Cat) b);
		} else if (a instanceof Dog) {
			return ((Dog) a).equals((Dog) b);
		} else {
			return ((Animal) a).equals((Animal) b);
		}
	}

// Prints all animals with separators
	public void printAnimals() {
		for (Animal a : animals) {
			if (a != null) {
				System.out.println("----------------------");
				System.out.println(a.toString());
			}
		}
		if (hasAny()) {
			System.out.println("----------------------");
		}
	}

	private boolean hasAny() {
		for (Animal a : animals)
			if (a != null)
				return true;
		return false;
	}
}
