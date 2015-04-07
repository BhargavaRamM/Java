import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class ValidatingStorePanel extends StorePanel {
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			System.exit(0); 
		
		if(e.getSource() == calculate) {
			if(payType.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(this, "Enter your credit card number here.", "Credit Card Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(nameBox.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Enter your name.", "Name Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(emailBox.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Enter your email address here.", "E-mail Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(songs.getSelectedValuesList().size() == 0) {
				JOptionPane.showMessageDialog(this, "Please choose at least one song.", "Song Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			double total = 0;
			for(int i : songs.getSelectedIndices()) {
				total += songArray[i].getPrice();
			}
			cost.setText(String.format("$%.2f", total));
		}
		
	}
}