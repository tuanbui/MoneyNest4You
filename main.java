import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class main extends JPanel{
	
	public static void main (String[] args){
		String[] columnTitles = {"First Name",
	            "Last Name",
	            "Account Type",
	            "Account Number",
	            "Transaction Amount"};

	Object[][] data = {
	{"-", "-",
	"-", "00000000", new Float(0.0)},
	{"-", "-",
	"-", "00000000", new Float(0.0)},
	{"-", "-",
	"-", "00000000", new Float(0.0)},
	{"-", "-",
	"-", "00000000", new Float(0.0)},
	{"-", "-",
	"-", "00000000", new Float(0.0)},
	{"-", "-",
	"-", "00000000", new Float(0.0)},
	{"-", "-",
	"-", "00000000", new Float(0.0)},
	{"-", "-",
	"-", "00000000", new Float(0.0)},
	{"Tuan", "-",
		"-", "00000000", new Float(0.0)}
		};
		JFrame frame = new JFrame("MoneyNest4You");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 300);
        JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu file = new JMenu("File");
		menubar.add(file);
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		
		JMenu help = new JMenu("Help");
		menubar.add(help);
		JMenuItem about = new JMenuItem("About");
		help.add(about);
		
		JTable table = new JTable(data, columnTitles);
        frame.add(table);
        
        JScrollPane scroll = new JScrollPane(table);
        frame.add(scroll);
		
		class exitaction implements ActionListener{
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		}
		
		exit.addActionListener(new exitaction());
	}
}
