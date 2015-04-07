import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SongPanel extends JPanel implements ActionListener {
	private JComboBox<Song> songs;
	private JTextField itemCode;
	private JTextField description;
	private JTextField artist;
	private JTextField album;
	private JTextField price;
	private JLabel song;	
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton accept;
	private JButton cancel;
	private JButton exit;
	
	public SongPanel() {
		this.setLayout(new BorderLayout());
		songs = new JComboBox<Song>(SongDatabase.readSongs());
		songs.addActionListener(new songListListener());
		song = new JLabel("Song: ");
		
		this.add(songs,BorderLayout.NORTH);
		this.add(newTextPanel(),BorderLayout.WEST);
		this.add(newButtonPanel(),BorderLayout.SOUTH);
	}
	private JPanel newTextPanel() {
		JPanel textPanel = new JPanel(new GridLayout(8,2));
		//textPanel.add(song);
		this.add(songs,BorderLayout.NORTH);
		itemCode = new JTextField(20);
		itemCode.setEditable(false);
		description = new JTextField(20);
		description.setEditable(false);
		artist = new JTextField(20);
		artist.setEditable(false);
		album = new JTextField(20);
		album.setEditable(false);
		price = new JTextField(20);
		price.setEditable(false);
		//private JTextField song = new JTextField(20);
		textPanel.add(new JLabel("Item Code: "));
		textPanel.add(itemCode);
		textPanel.add(new JLabel("Description: "));
		textPanel.add(description);
		textPanel.add(new JLabel("Artist: "));
		textPanel.add(artist);
		textPanel.add(new JLabel("Album: "));
		textPanel.add(album);
		textPanel.add(new JLabel("Price: "));
		textPanel.add(price);
		display();
		return textPanel;		
	}

	private JPanel newButtonPanel() {
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		add = new JButton("Add");
		add.addActionListener(new ButtonListener());
		edit = new JButton("Edit");
		edit.addActionListener(new ButtonListener());
		delete = new JButton("Delete");
		delete.addActionListener(new ButtonListener());
		accept = new JButton("Accept");
		accept.addActionListener(new AcceptCancelListener());
		accept.setEnabled(false);
		cancel = new JButton("Cancel");
		cancel.addActionListener(new AcceptCancelListener());
		cancel.setEnabled(false);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		buttonPanel.add(add);
		buttonPanel.add(edit);
		buttonPanel.add(delete);
		buttonPanel.add(accept);
		buttonPanel.add(cancel);
		buttonPanel.add(exit);
		return buttonPanel;
	}
	private void display() {
		itemCode.setText(((Song) songs.getSelectedItem()).getItemCode());
		description.setText(((Song) songs.getSelectedItem()).getDescription());
		artist.setText(((Song) songs.getSelectedItem()).getArtist());
		album.setText(((Song) songs.getSelectedItem()).getAlbum());
		price.setText(String.format( "%.2f",((Song) songs.getSelectedItem()).getPrice()));
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			System.exit(0);
		}
	}

	private class songListListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display();
		}
	}
	private String choice;
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			add.setEnabled(false);
			edit.setEnabled(false);
			delete.setEnabled(false);
			accept.setEnabled(true);
			cancel.setEnabled(true);
			songs.setEnabled(false);
			/*
			if(a.getSource() == exit) {
				System.exit(0);
			}
			*/
			if(a.getSource() == add) {
				choice = "Add";
				enableTextFields(true,true,true,true,true);
				clearTextFields(true,true,true,true,true);				
			}
			if(a.getSource() == edit) {
				choice = "Edit";
				enableTextFields(false,true,true,false,true);
			}
			if(a.getSource() == delete) {
				choice = "Delete";
			}
		}
		private void enableTextFields(boolean item,boolean d,boolean art,boolean alb,boolean p) {
			itemCode.setEditable(item);
			description.setEditable(d);
			artist.setEditable(art);
			album.setEditable(alb);
			price.setEditable(p);			
		}
		private void clearTextFields(boolean item,boolean d,boolean art, boolean alb, boolean p) {
			if(item) {
				itemCode.setText("");
			}
			if(d) {
				description.setText("");
			}
			if(art) {
				artist.setText("");
			}
			if(alb) {
				album.setText("");
			}
			if(p) {
				price.setText("");
			}
		}
		
	}
	
	private class AcceptCancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			add.setEnabled(true);
			edit.setEnabled(true);
			delete.setEnabled(true);
			accept.setEnabled(false);
			cancel.setEnabled(false);
			
			disableTextFields();
			songs.setEnabled(true);
			if(e.getSource() == accept) {
				validate();
				switch(choice) {
					case "Add":
						SongDatabase.writeSong(new Song(itemCode.getText(),description.getText(),artist.getText(),album.getText(),Double.parseDouble(price.getText())));
						break;
					case "Edit":
						SongDatabase.editSong(songs.getSelectedIndex(),new Song(itemCode.getText(),description.getText(),artist.getText(),album.getText(),Double.parseDouble(price.getText())));
						break;
					case "Delete":
						SongDatabase.deleteSong(songs.getSelectedIndex());
						break;					
				}
				DefaultComboBoxModel<Song> model = new DefaultComboBoxModel<Song>(SongDatabase.readSongs());
				songs.setModel(model);
			}
			songs.setSelectedIndex(0);
			display();
		}
		private void disableTextFields() {
		itemCode.setEditable(false);
		description.setEditable(false);
		artist.setEditable(false);
		album.setEditable(false);
		price.setEditable(false);
		}
		private void validate() {
			if(itemCode.getText().equals("")){
				JOptionPane.showMessageDialog(new SongPanel(),"Enter Item Code for the song here.","Item Code error",JOptionPane.ERROR_MESSAGE);
				itemCode.setText("default");
				return;
			}
			if(description.getText().equals("")) {
				JOptionPane.showMessageDialog(new SongPanel(),"Enter Description for the song.","Description",JOptionPane.ERROR_MESSAGE);
				description.setText("No Song Selected");
				return;
			}
			if(artist.getText().equals("")) {
				JOptionPane.showMessageDialog(new SongPanel(),"Enter Artist Name.","Artist",JOptionPane.ERROR_MESSAGE);
				artist.setText("No Song Selected");
				return;
			}
			if(album.getText().equals("")) {
				JOptionPane.showMessageDialog(new SongPanel(),"Enter Album Name.","Album",JOptionPane.ERROR_MESSAGE);
				album.setText("Single");
				return;
			}
			if(price.getText().equals("")) {
				JOptionPane.showMessageDialog(new SongPanel(),"Enter Price of the Song.","Price",JOptionPane.ERROR_MESSAGE);
				price.setText("0");
			}
			try{
				Double.parseDouble(price.getText());
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(new SongPanel(),"Price must be a number.","Enter a number",JOptionPane.ERROR_MESSAGE);
				price.setText("0");
			}
		}
	}
	
}
