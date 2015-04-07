import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class SongStoreFrame extends JFrame {
	public SongStoreFrame() {
		setTitle("Music Store");
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel panel = new SongPanel();
		this.add(panel);
	}
	public static void main(String[] args) {
		JFrame frame = new SongStoreFrame();
		frame.setVisible(true);
	}
}