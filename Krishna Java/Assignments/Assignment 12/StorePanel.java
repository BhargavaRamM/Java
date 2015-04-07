import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class StorePanel extends JPanel implements ActionListener, ListSelectionListener {
	protected JComboBox<String> payType;
	private final String [] creditCards = {"Visa", "MasterCard", "Amex"};
	protected JTextField emailBox;
	protected JTextField nameBox;

	private Border cart;
	private JTextArea items;
	private JScrollPane cartScroll;
	
	private JScrollPane songsListScroll;
	protected JList<String> songs;
	protected Song[] songArray = {
						new Song("America",2.00,"A Horse with No Name"),
						new Song("Taylor Swift",3.00,"Blank Space"),
						new Song("Switch Foot",2.00,"Gone"),
						new Song("Maroon 5",2.00,"Stereo Hearts"),
						new Song("Mark Ronson",3.00,"UpTown Funk")};
	private String[] songNames = new String [songArray.length];
	
	protected JTextField cost;
	protected JButton calculate;
	protected JButton exit;

	public StorePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(13,1));
		
		payType = new JComboBox<String>(creditCards);
		emailBox = new JTextField(20);
		nameBox = new JTextField(15);
		
		
		panel.add(new JLabel("Credit Card:"));
		panel.add(payType);
		panel.add(new JLabel("email:"));
		panel.add(emailBox);
		panel.add(new JLabel("Name:"));
		panel.add(nameBox);
		
		for(int i = 0; i < songArray.length; i++)
			songNames[i] = songArray[i].getSongTitle();
		songs = new JList<String>(songNames);
		songs.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		songs.getSelectionModel().addListSelectionListener(this);
		songsListScroll = new JScrollPane(songs, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		cart = BorderFactory.createTitledBorder("Shopping Cart Contains:");
		items = new JTextArea(10, 20);
		items.setEditable(false);
		cartScroll = new JScrollPane(items, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cartScroll.setBorder(cart);
		
		
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cost = new JTextField(10);
		cost.setEditable(false);
		
		calculate = new JButton("Calculate");
		calculate.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		bottomPanel.add(new JLabel("Total: "));
		bottomPanel.add(cost);
		bottomPanel.add(calculate);
		bottomPanel.add(exit);
		
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.WEST);
		this.add(songsListScroll, BorderLayout.CENTER);
		this.add(cartScroll, BorderLayout.EAST);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}

	public void valueChanged(ListSelectionEvent e) {
		String value = "";
		for(int i : songs.getSelectedIndices()) {
			value += songArray[i] + "\n";
		}
		items.setText(value);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			System.exit(0);
		else if(e.getSource() == calculate) {
			double total = 0;
			for(int i : songs.getSelectedIndices()) {
				total += songArray[i].getPrice();
			}
			cost.setText(String.format("$%.2f", total));
		}
		
	}

	

}