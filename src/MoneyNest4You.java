import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class MoneyNest4You extends JFrame implements TableModelListener{
	protected static final String[][] Object = null;
	private static int lastRow=1;
	private static int firstRowNum=0;
	private static int rowCount=1;
	private static float f=0;
	//private float total=0;
	private static int columnNum=1;
	private static int tableLength=120;
	JTable table;
	static DefaultTableModel model;
	
	public MoneyNest4You (){
		String[] columnTitles = {"First Name",
	            "Last Name",
	            "Account Type",
	            "Account Number",
	            "Transaction Amount"};

	Object[][] data = {
	{"","","","", f},
	{"<html><b><font color=blue>Total</font></b></html>","","","", f}};
		JFrame frame = new JFrame("MoneyNest4You");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1010, 475);
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu file = new JMenu("File");
		menubar.add(file);
		ImageIcon icon = new ImageIcon("src/exit.png");
		JMenuItem exit = new JMenuItem("Exit", icon);

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
		rightpane.setLayout(new GridLayout(1,0));
		JButton calButton = new JButton("Calculate");
		//calButton.setPreferredSize(new Dimension(105, 50));
		JButton predictButton = new JButton("Predict");
		//predictButton.setPreferredSize(new Dimension(105, 50));
		JButton insertRowButton = new JButton("Insert Row");
		//insertRowButton.setPreferredSize(new Dimension(105, 50));
		leftpane.add(calButton);
		leftpane.add(predictButton);
		leftpane.add(insertRowButton);

		model = new DefaultTableModel(data, columnTitles){
			 public boolean isCellEditable( int row, int col )  
			 	{  
				 	if (row!= lastRow ){  
				 		return true;  
				 	}  
				 	else {  
				 		return false;  
				 	}  
			 	}  
		};
		model.addTableModelListener(null);
		table = new JTable(model);
		table.setPreferredSize(new Dimension(760, tableLength));
		table.getTableHeader().setReorderingAllowed(false); 
		rightpane.add(table);
		JScrollPane scroll2 = new JScrollPane(rightpane);
		splitpane.add(scroll2);
		JScrollPane scroll = new JScrollPane(table);
		rightpane.add(scroll);
		
		insertRowButton.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e) {
				tableLength+=17;
				table.setPreferredSize(new Dimension(760, tableLength));
				model.insertRow(0, new Object[]{"","","","", f});
				rowCount++;
				lastRow++;
			}
		});		
		
		calButton.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e) {
				update();
			}
		});
		
		
		class exitaction implements ActionListener{
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		}
		
		exit.addActionListener(new exitaction());
	}
	
	public static void update(){
		double total=0;
		for(int i=0; i<lastRow; i++){
			Object value = model.getValueAt(i, 4 );
		    total =  total + Double.parseDouble( String.valueOf( value ) );
		}
		model.setValueAt(total, lastRow, 4 );
	}
	public static void main(String[] args)
	{
		MoneyNest4You mn4y = new MoneyNest4You();
	}


	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}