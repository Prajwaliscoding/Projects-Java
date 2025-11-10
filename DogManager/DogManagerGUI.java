import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DogManagerGUI extends JFrame {
	private final DogManager manager;
// UI components
	private JTextField nameField;
	private JComboBox<DogBreed> breedCombo;
	private JSpinner ageSpinner;
	private JSpinner weightSpinner;
	private JTextArea displayArea;
	private JButton addButton;
	private JButton removeButton;
	private JButton searchButton;
	private JButton sortButton;

	public DogManagerGUI() {
		super("Dog Manager");
		this.manager = new DogManager();
		initUI();
	}

	private void initUI() {
// Inputs panel (top)
		JPanel inputPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(4, 4, 4, 4);
		gbc.fill = GridBagConstraints.HORIZONTAL;
// Name
		gbc.gridx = 0;
		gbc.gridy = 0;
		inputPanel.add(new JLabel("Name:"), gbc);
		nameField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 0;
		inputPanel.add(nameField, gbc);
// Breed
		gbc.gridx = 0;
		gbc.gridy = 1;
		inputPanel.add(new JLabel("Breed:"), gbc);
		breedCombo = new JComboBox<DogBreed>(DogBreed.values());
		gbc.gridx = 1;
		gbc.gridy = 1;
		inputPanel.add(breedCombo, gbc);
// Age (integer >= 0)
		gbc.gridx = 0;
		gbc.gridy = 2;
		inputPanel.add(new JLabel("Age:"), gbc);
		ageSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 200, 1));
		gbc.gridx = 1;
		gbc.gridy = 2;
		inputPanel.add(ageSpinner, gbc);
// Weight (double >= 0)
		gbc.gridx = 0;
		gbc.gridy = 3;
		inputPanel.add(new JLabel("Weight:"), gbc);
		weightSpinner = new JSpinner(new SpinnerNumberModel(1.0, 0.0, 500.0, 0.1));
		gbc.gridx = 1;
		gbc.gridy = 3;
		inputPanel.add(weightSpinner, gbc);
// Buttons panel (middle)
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addButton = new JButton("Add Dog");
		removeButton = new JButton("Remove Dog");
		searchButton = new JButton("Search Dog");
		sortButton = new JButton("Sort Dogs by Age");
		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);
		buttonPanel.add(searchButton);
		buttonPanel.add(sortButton);
// Display area (bottom): scrollable, non-editable text area
		displayArea = new JTextArea(12, 40);
		displayArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(displayArea);
// Wire up actions
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onAddDog();
			}
		});
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onRemoveDog();
			}
		});
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSearchDog();
			}
		});
		sortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.sortDogsByAge();
				appendAllDogs("Dogs sorted by age (ascending):");
			}
		});
// Layout frame
		setLayout(new BorderLayout(6, 6));
		add(inputPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.SOUTH);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // center
	}

	private void onAddDog() {
		String name = nameField.getText();
		DogBreed breed = (DogBreed) breedCombo.getSelectedItem();
		int age = ((Integer) ageSpinner.getValue()).intValue();
		double weight = ((Double) weightSpinner.getValue()).doubleValue();
		Dog newDog = new Dog(name, breed, age, weight);
		boolean added = manager.addDog(newDog);
		if (added) {
			appendAllDogs("Dog added.");
		} else {
			appendMessage("Name must be unique. Dog not added.");
		}
	}

	private void onRemoveDog() {
		String name = nameField.getText();
		if (name == null || name.trim().isEmpty()) {
			appendMessage("Please enter the name to remove.");
			return;
		}
		boolean removed = manager.removeDog(name);
		if (removed) {
			appendAllDogs("Dog removed.");
		} else {
			appendMessage("Dog not found.");
		}
	}

	private void onSearchDog() {
		String name = nameField.getText();
		if (name == null || name.trim().isEmpty()) {
			appendMessage("Please enter the name to search.");
			return;
		}
		Dog found = manager.searchDog(name);
		if (found != null) {
			appendMessage("Found: " + found.toString());
		} else {
			appendMessage("Dog not found.");
		}
	}

	private void appendAllDogs(String header) {
		StringBuilder sb = new StringBuilder();
		sb.append(header).append("\n");
		for (Dog d : manager.getAllDogs()) {
			sb.append(d.toString()).append("\n");
		}
		displayArea.setText(sb.toString());
	}

	private void appendMessage(String msg) {
		if (displayArea.getText().isEmpty()) {
			displayArea.setText(msg);
		} else {
			displayArea.append("\n" + msg);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new DogManagerGUI().setVisible(true);
			}
		});
	}
}
