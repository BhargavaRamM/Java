import java.util.*;
import javax.swing.*;

public class Calculator extends JFrame {
	public Calculator() {
		setTitle("Calculator");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel calculatorPanel = new Invoice();
		this.add(calculatorPanel);
	}
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.setVisible(true);
	}
}