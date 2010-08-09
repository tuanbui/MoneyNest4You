import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class About {
	public About(){
		JFrame frame = new JFrame("About");
		
		String s = "MoneyNest4You is a application.";
		ImageIcon icon = new ImageIcon("src/moneynes4yout.jpg");
		JLabel label = new JLabel(s);
		label.setIcon(icon);
		frame.setSize(400,300);
		frame.add(label);
		frame.setVisible(true);	
		
		JScrollPane scroll = new JScrollPane(label);
		frame.add(scroll);
	}
}