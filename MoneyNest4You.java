import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

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
	private static int lastRow=2;
	private static int firstRowNum=0;
	private static int rowCount=2;
	private static float f=0;
	//private float total=0;
	private static int columnNum=1;
	JTable table;
	
	
	public MoneyNest4You (){
		String[] columnTitles = {"First Name",
	            "Last Name",
	            "Account Type",
	            "Account Number",
	            "Transaction Amount"};

	Object[][] data = {
	{"<html><b><font color=blue>First Name</font></b></html>", "<html><b><font color=blue>Last Name</font></b></html>",
	"<html><b><font color=blue>Account Type</font></b></html>", "<html><b><font color=blue>Account Number</font></b></html>", "<html><b><font color=blue>Transaction Amount</font></b></html>"},
	{"","","","", f},
	{"<html><b><font color=blue>Total</font></b></html>","","","", f}};
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
		rightpane.setLayout(new GridLayout(2,1));
		JButton calButton = new JButton("Calculate");
		//calButton.setPreferredSize(new Dimension(105, 50));
		JButton predictButton = new JButton("Predict");
		//predictButton.setPreferredSize(new Dimension(105, 50));
		JButton insertRowButton = new JButton("Insert Row");
		//insertRowButton.setPreferredSize(new Dimension(105, 50));
		leftpane.add(calButton);
		leftpane.add(predictButton);
		leftpane.add(insertRowButton);

		final DefaultTableModel model = new DefaultTableModel(data, columnTitles){
			 public boolean isCellEditable( int row, int col )  
			 	{  
				 	if ( row != firstRowNum && row!= lastRow ){  
				 		return true;  
				 	}  
				 	else {  
				 		return false;  
				 	}  
			 	}  
		};
		model.addTableModelListener(null);
		table = new JTable(model);
		table.setPreferredSize(new Dimension(760, 300));
		rightpane.add(table);
		
		JScrollPane scroll = new JScrollPane(rightpane);
		splitpane.add(scroll);
		
		
		
		insertRowButton.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e) {
				model.insertRow(1, new Object[]{"","","","", f});
				rowCount++;
				lastRow++;
			}
		});		
		
		calButton.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e) {
					double total=0;
					int i=1;
				while(i<lastRow){
					Object value = model.getValueAt(i, 4 );
				    total =  total + Double.parseDouble( String.valueOf( value ) );
				    i++;
				}
				model.setValueAt(total, lastRow, 4 );
			}
		});
		
		
		class exitaction implements ActionListener{
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		}
		
		exit.addActionListener(new exitaction());
	}
	

	public static void main(String[] args)
	{
		MoneyNest4You mn4y = new MoneyNest4You();
		mn4y.setDefaultCloseOperation( EXIT_ON_CLOSE );
		mn4y.pack();
		mn4y.setLocationRelativeTo( null );
		mn4y.setVisible(true);
	}


	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}

