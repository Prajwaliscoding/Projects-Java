import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DogManager {
// dogs: A List<Dog> to store the collection of dogs.
	private List<Dog> dogs;

	public DogManager() {
		this.dogs = new ArrayList<Dog>();
	}

// addDog(Dog dog): Adds a new dog if the name is unique.
	public boolean addDog(Dog dog) {
		if (dog == null)
			return false;
		String newName = dog.getName();
		if (newName == null)
			return false;
// Enforce unique name (case-insensitive to be safe)
		for (Dog d : dogs) {
			if (d.getName().equalsIgnoreCase(newName)) {
				return false; // name already exists
			}
		}
		dogs.add(dog);
		return true;
	}

// removeDog(String name): Removes a dog by name (case-insensitive).
	public boolean removeDog(String name) {
		if (name == null)
			return false;
		for (int i = 0; i < dogs.size(); i++) {
			if (dogs.get(i).getName().equalsIgnoreCase(name)) {
				dogs.remove(i);
				return true;
			}
		}
		return false;
	}

// searchDog(String name): Returns a Dog instance if found, otherwise null.
	public Dog searchDog(String name) {
		if (name == null)
			return null;
		for (Dog d : dogs) {
			if (d.getName().equalsIgnoreCase(name)) {
				return d;
			}
		}
		return null;
	}

// sortDogsByAge(): Sorts the list of dogs by age in ascending order.
	public void sortDogsByAge() {
// Use a simple Comparator (no streams)
		Collections.sort(dogs, new Comparator<Dog>() {
			@Override
			public int compare(Dog a, Dog b) {
				return Integer.compare(a.getAge(), b.getAge());
			}
		});
	}

// getAllDogs(): Returns the full list of dogs.
	public List<Dog> getAllDogs() {
		return dogs;
	}
}
