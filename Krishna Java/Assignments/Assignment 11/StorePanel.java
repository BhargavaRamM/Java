import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.Border;

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
	protected Song [] songArray = {
						new Song("Pitbull",4.00,"Mr.WorldWide"),
						new Song("Enrique",3.00,"Baby I Like It"),
						new Song("David Guetta",4.00,"Without You"),
						new Song("Michael Jackson",2.00,"Beat It"),
						new Song("Shakira",3.00,"Hips Don't Lie")};
	private String [] songNames = new String [songArray.length];
	
	protected JTextField cost;
	protected JButton calculate;
	protected JButton exit;

	public StorePanel() {
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(13,1));
		
		payType = new JComboBox<String>(creditCards);
		emailBox = new JTextField(12);
		nameBox = new JTextField(12);
		
		
		infoPanel.add(new JLabel("Credit Card:"));
		infoPanel.add(payType);
		infoPanel.add(new JLabel("email:"));
		infoPanel.add(emailBox);
		infoPanel.add(new JLabel("Name:"));
		infoPanel.add(nameBox);
		
		for(int i = 0; i < songArray.length; i++)
			songNames[i] = songArray[i].getSongTitle();
		songs = new JList<String>(songNames);
		songs.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		songs.getSelectionModel().addListSelectionListener(this);
		songsListScroll = new JScrollPane(songs, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		cart = BorderFactory.createTitledBorder("Your Shopping Cart Contains:");
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
		this.add(infoPanel, BorderLayout.WEST);
		this.add(songsListScroll, BorderLayout.CENTER);
		this.add(cartScroll, BorderLayout.EAST);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}

	public void valueChanged(ListSelectionEvent e) {
		String itemsVal = "";
		for(int i : songs.getSelectedIndices()) {
			itemsVal += songArray[i] + "\n";
		}
		items.setText(itemsVal);
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