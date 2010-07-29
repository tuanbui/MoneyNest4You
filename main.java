import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JPanel implements ActionListener{
	
	public static void main (String[] args){
		String[] columnTitles = {"First Name",
	            "Last Name",
	            "Account Type",
	            "Account Number",
	            "Transaction Amount"};

	Object[][] data = {
	{"First Name", "Last Name",
	"Account Type", "Account Number", "Transaction Amount"}};
		JFrame frame = new JFrame("MoneyNest4You");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1010, 300);
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
		
		
		JPanel leftpane = new JPanel();
		JPanel rightpane = new JPanel();
		JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftpane, rightpane);
		frame.add(splitpane);
		splitpane.setOneTouchExpandable(true);
		splitpane.setDividerLocation(200);
		leftpane.setBackground(Color.white);
		rightpane.setBackground(Color.gray);
		leftpane.setLayout(new GridLayout(3,1));
		JButton calButton = new JButton("Calculate");
		//calButton.setPreferredSize(new Dimension(105, 50));
		JButton predictButton = new JButton("Predict");
		//predictButton.setPreferredSize(new Dimension(105, 50));
		JButton insertRowButton = new JButton("Insert Row");
		//insertRowButton.setPreferredSize(new Dimension(105, 50));
		leftpane.add(calButton);
		leftpane.add(predictButton);
		leftpane.add(insertRowButton);

		final DefaultTableModel model = new DefaultTableModel(data, columnTitles);
		JTable table = new JTable(model);
		table.setPreferredSize(new Dimension(760, 300));
		rightpane.add(table);
		
		JScrollPane scroll = new JScrollPane(rightpane);
		splitpane.add(scroll);

		insertRowButton.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e) {
				model.insertRow(1, new Object[]{"","","","", new Float(0.0)});
			}
		});		

		
		class exitaction implements ActionListener{
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		}
		
		exit.addActionListener(new exitaction());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
