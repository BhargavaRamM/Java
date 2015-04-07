import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class SongStoreFrame extends JFrame {
	public SongStoreFrame() {
		setTitle("Music Store");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel panel = new ValidatingStorePanel();
		this.add(panel);
	}
	public static void main(String[] args) {
		JFrame frame = new SongStoreFrame();
		frame.setVisible(true);
	}
	
}