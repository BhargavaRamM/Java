import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Invoice extends JPanel implements ActionListener {
	private JTextField subTotal;
	private JTextField discountPercentage;
	private JTextField discountAmount;
	private JTextField invoiceTotal;
	private JButton calculate;
	private JButton exit;
	
	public Invoice() {
		JPanel textValues = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		subTotal = new JTextField(20);
		discountPercentage = new JTextField(15);
		discountPercentage.setEditable(false);
		discountAmount = new JTextField(20);
		discountAmount.setEditable(false);
		invoiceTotal = new JTextField(20);
		invoiceTotal.setEditable(false);
		
		textValues.add(new JLabel("Sub Total: "));
		textValues.add(subTotal);
		textValues.add(new JLabel("Discount Percentage: "));
		textValues.add(discountPercentage);
		textValues.add(new JLabel("Discount Amount: "));
		textValues.add(discountAmount);
		textValues.add(new JLabel("Invoice Total: "));
		textValues.add(invoiceTotal);
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		calculate = new JButton("Calculate");
		calculate.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		buttons.add(calculate);
		buttons.add(exit);
		
		this.setLayout(new BorderLayout());
		this.add(textValues, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == calculate) {
			displayDiscounts();
		} else if(e.getSource() == exit) {
			System.exit(0);
		}
	}
	public void displayDiscounts() {
		int n = Integer.parseInt(subTotal.getText());
		double discount = 0.00;
		if(n < 100) {
			discount = 0.00;
		} else if(n < 200) {
			discount = 0.1;
		} else {
			discount = 0.15;
		}
		discountPercentage.setText( (discount * 100) + "%");
		discountAmount.setText(Double.toString(discount * n));
		invoiceTotal.setText(Double.toString( n - (discount * n) ));
	}
}
