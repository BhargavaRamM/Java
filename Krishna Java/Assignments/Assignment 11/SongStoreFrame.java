import javax.swing.*;
public class SongStoreFrame extends JFrame {
	public SongStoreFrame() {
		setTitle("Music Store");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel panel = new StorePanel();
		this.add(panel);
	}
	public static void main(String [] args) {
		JFrame frame = new SongStoreFrame();
		frame.setVisible(true);
	}
	
}