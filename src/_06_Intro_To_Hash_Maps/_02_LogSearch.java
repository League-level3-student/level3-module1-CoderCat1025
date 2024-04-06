package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons.
	 * Button 1: Add Entry
	 *      When this button is clicked, use an input dialog to ask the user
	 *      to enter an ID number.
	 *      After an ID is entered, use another input dialog to ask the user
	 *      to enter a name. Add this information as a new entry to your
	 *      HashMap.
	 * 
	 * Button 2: Search by ID
	 *      When this button is clicked, use an input dialog to ask the user
	 *      to enter an ID number.
	 *      If that ID exists, display that name to the user.
	 *      Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 *      When this button is clicked, display the entire list in a message
	 *      dialog in the following format:
	 *      ID: 123  Name: Harry Howard
	 *      ID: 245  Name: Polly Powers
	 *      ID: 433  Name: Oliver Ortega
	 *      etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 *      When this button is clicked, prompt the user to enter an ID using
	 *      an input dialog.
	 *      If this ID exists in the HashMap, remove it. Otherwise, notify the
	 *      user that the ID is not in the list.
	 */

	JPanel panel;
	JFrame frame;
	JButton entry;
	JButton search;
	JButton view;
	JButton remove;
	HashMap<Integer, String> IDList = new HashMap<Integer, String>();

	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		entry = new JButton();
		search = new JButton();
		view = new JButton();
		remove = new JButton();

		frame.add(panel);
		panel.add(entry);
		panel.add(remove);
		panel.add(search);
		panel.add(view);


		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		entry.setText("Add Entry");
		search.setText("Search by ID");
		view.setText("View List");
		remove.setText("Remove Entry");
		entry.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);

		frame.setName("Name Log");

		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) { 
		if (e.getSource() == entry) {
			String ID = JOptionPane.showInputDialog(null, "Enter an ID number.");
			String name = JOptionPane.showInputDialog(null, "Enter a name (first and last).");
			if (IDList.containsKey(Integer.parseInt(ID))) {
				JOptionPane.showMessageDialog(null, "ID " + ID + " is already in use.");
			} else {
				IDList.put(Integer.parseInt(ID), name);
				JOptionPane.showMessageDialog(null, "Entry sucessfully added.");
			}

		} else if (e.getSource() == search) {
			String id = JOptionPane.showInputDialog(null, "Enter an ID number.");
			if (IDList.containsKey(Integer.parseInt(id))) {
				JOptionPane.showMessageDialog(null, "ID " + id + " belongs to " + IDList.get(Integer.parseInt(id)));
			} else {
				JOptionPane.showMessageDialog(null, "There is no one with ID " + id + ".");
			}

		} else if (e.getSource() == view) {
			String list = "";
			Set <Integer> keys = IDList.keySet();

			for (Integer i : keys) {
				list = list + "ID: " + i + " Name: " + IDList.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);

		} else if (e.getSource() == remove) {
			String ID = JOptionPane.showInputDialog(null, "Enter an ID number.");
			if (IDList.containsKey(Integer.parseInt(ID))) {
				IDList.remove(Integer.parseInt(ID));
				JOptionPane.showMessageDialog(null, "Entry successfully removed.");
			} else {
				JOptionPane.showMessageDialog(null, "There is no one with ID " + ID + ".");
			}
		}

	}
}
