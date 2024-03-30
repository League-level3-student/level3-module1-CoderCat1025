package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	/*
	 * Create a GUI with two buttons. One button reads "Add Name" and the other
	 * button reads "View Names". When the add name button is clicked, display
	 * an input dialog that asks the user to enter a name. Add that name to an
	 * ArrayList. When the "View Names" button is clicked, display a message
	 * dialog that displays all the names added to the list. Format the list as
	 * follows:
	 * Guest #1: Bob Banders
	 * Guest #2: Sandy Summers
	 * Guest #3: Greg Ganders
	 * Guest #4: Donny Doners
	 */
	ArrayList<String> names;
	JFrame frame;
	JPanel panel;
	JButton addButton;
	JButton viewButton;
	String answer;

	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		addButton = new JButton();
		viewButton = new JButton();

		frame.add(panel);
		panel.add(addButton);
		panel.add(viewButton);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addButton.setText("Add Name");
		addButton.addActionListener(this);
		viewButton.setText("View Names");
		viewButton.addActionListener(this);

		names = new ArrayList<String>();

		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			answer = JOptionPane.showInputDialog("Enter a name (preferably both first and last).");
			names.add(answer);
		}

		if (e.getSource() == viewButton) {
			
			String guests = "";

			for (int i = 0; i < names.size(); i++) {
				guests = guests + "Guest #" + (i+1) + ": " + names.get(i) + "\n";
			}

			if (names.isEmpty()) {
				JOptionPane.showMessageDialog(null,  "No one has been invited yet.");
			} else {
				JOptionPane.showMessageDialog(null, guests);
			}
		}
	}

}

