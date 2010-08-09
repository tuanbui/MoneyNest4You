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

import java.io.*;

public class MoneyNest4You extends JFrame implements TableModelListener{
	protected static final String[][] Object = null;
	private static int lastRow=2;
	private static int firstRowNum=0;
	private static int rowCount=2;
	private static int tableLength=120;
	JTable table;
	double[] num = new double[5];
	static DefaultTableModel model;
	
	
	public MoneyNest4You (){
		String[] columnTitles = {"First Name",
								"Last Name",
								"Account Type",
								"Account Number",
								"Transaction Amount"};

		Object[][] data = {
							{"<html><b><font color=blue>First Name</font></b></html>", "<html><b><font color=blue>Last Name</font></b></html>",
								"<html><b><font color=blue>Account Type</font></b></html>", "<html><b><font color=blue>Account Number</font></b></html>", "<html><b><font color=blue>Transaction Amount</font></b></html>"},
							{"","","","", new Double(0)},
							{"<html><b><font color=blue>Total</font></b></html>","","","", new Double(0)}};
		JFrame frame = new JFrame("MoneyNest4You");
		frame.setVisible(true);
		frame.setSize(930, 300);
		frame.pack();
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu file = new JMenu("File");
		menubar.add(file);
		ImageIcon exitIcon = new ImageIcon("src/exit.png");
		ImageIcon saveIcon = new ImageIcon("src/saveIcon.png");
		JMenuItem save = new JMenuItem("Save", saveIcon);
		file.add(save);
		JMenuItem exit = new JMenuItem("Exit", exitIcon);
		file.add(exit);
		
		JMenu options = new JMenu("Options");
		menubar.add(options);
		JMenuItem graph = new JMenuItem("Graph");
		options.add(graph);
		
		JMenu help = new JMenu("Help");
		menubar.add(help);
		JMenuItem about = new JMenuItem("About");
		help.add(about);
		
		
		JPanel leftpane = new JPanel();
		JPanel rightpane = new JPanel();
		JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftpane, rightpane);
		frame.add(splitpane);
		splitpane.setOneTouchExpandable(true);
		splitpane.setDividerLocation(210);
		leftpane.setBackground(Color.white);
		rightpane.setBackground(Color.gray);
		leftpane.setLayout(new GridLayout(3,1));
		JButton calButton = new JButton("Calculate");
		JButton predictButton = new JButton("Predict");
		JButton insertRowButton = new JButton("Insert Row");
		leftpane.add(calButton);
		leftpane.add(predictButton);
		leftpane.add(insertRowButton);

		model = new DefaultTableModel(data, columnTitles){
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
		table.setPreferredSize(new Dimension(750, tableLength));
		rightpane.add(table);
		
		JScrollPane scroll = new JScrollPane(rightpane);
		splitpane.add(scroll);
		
		
		insertRowButton.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e) {
				tableLength += 20;
				table.setPreferredSize(new Dimension(750, tableLength));
				model.insertRow(1, new Object[]{"","","","", new Double(0)});
				rowCount++;
				lastRow++;
			}
		});		
		
		about.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e) {
				About about2 = new About();
			}
		});	
		
		calButton.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e){
					update();
			}
		});
		
		save.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e){
					Writer output = null;
				    try {
						output = new BufferedWriter(new FileWriter("MoneyNest4You.txt")); 
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				    try {
				    	for(int i=1; i<lastRow;i++){
							Object first = model.getValueAt(i, 0 );
							Object last = model.getValueAt(i, 1 );
							Object acct_type = model.getValueAt(i, 2 );
							Object acct_num = model.getValueAt(i, 3 );
							Object amount = model.getValueAt(i, 4 );
							output.write(String.valueOf( first ));
							output.write(" ");
							output.write(String.valueOf( last ));
							output.write(" ");
							output.write(String.valueOf( acct_type ));
							output.write(" ");
							output.write(String.valueOf( acct_num ));
							output.write(" ");
							output.write(String.valueOf( amount ));
							output.write("\n");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    try {
						output.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
		for(int i=1; i<lastRow;i++){
			Object value = model.getValueAt(i, 4 );
		    total += Double.parseDouble( String.valueOf( value ) );
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