/* 
 * Copyright (c) 2010, Tuan Bui
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the 
 * following conditions are met:
 *
 *   - Redistributions of source code must retain the above copyright notice, this list of conditions and the following 
 *   disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the 
 *   following disclaimer in the documentation and/or other materials provided with the distribution.
 *   - Neither the name of the MoneyNest4You nor the names of its contributors may be used to endorse or promote products 
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, 
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR 
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF 
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/* 
 * MoneyNest4You.java
 * Functionalities of the following function:
 *    -Insert data
 *    -Calculate total
 *    -Predict next transaction
 *    -Insert new row into table
 *    -Save data
 *    -Infomation about MoneyNest4You
 *    -Exit program 
 */
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
		/* 
		 * Column titles 
		 */
		String[] columnTitles = {"First Name",
								"Last Name",
								"Account Type",
								"Account Number",
								"Transaction Amount"};
		/* 
		 * Total Column 
		 */
		Object[][] data = {
							{"<html><b><font color=blue>First Name</font></b></html>", "<html><b><font color=blue>Last Name</font></b></html>",
								"<html><b><font color=blue>Account Type</font></b></html>", "<html><b><font color=blue>Account Number</font></b></html>", "<html><b><font color=blue>Transaction Amount</font></b></html>"},
							{"","","","", new Double(0)},
							{"<html><b><font color=blue>Total</font></b></html>","","","", new Double(0)}};
		
		/* 
		 * Build frame 
		 */
		JFrame frame = new JFrame("MoneyNest4You");
		frame.setVisible(true);
		frame.setSize(930, 300);
		frame.pack();
		
		/* 
		 * Create menu 
		 */
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		/* 
		 * Menu items
		 */
		JMenu file = new JMenu("File");
		menubar.add(file);
		ImageIcon exitIcon = new ImageIcon("src/exit.png");
		ImageIcon saveIcon = new ImageIcon("src/saveIcon.png");
		JMenuItem save = new JMenuItem("Save", saveIcon);
		file.add(save);
		JMenuItem exit = new JMenuItem("Exit", exitIcon);
		file.add(exit);
		
		/* 
		 * Menu items 
		 */
		JMenu options = new JMenu("Options");
		menubar.add(options);
		JMenuItem graph = new JMenuItem("Graph");
		options.add(graph);
		
		/* 
		 * Menu items
		 */
		JMenu help = new JMenu("Help");
		menubar.add(help);
		JMenuItem about = new JMenuItem("About");
		help.add(about);
		
		/* 
		 * Split into 2 panels, left panel for calculation, predict, and insert row buttons.
		 * Right panel is for the table.
		 */
		JPanel leftpane = new JPanel();
		JPanel rightpane = new JPanel();
		JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftpane, rightpane);
		frame.add(splitpane);
		splitpane.setOneTouchExpandable(true);
		splitpane.setDividerLocation(210);
		leftpane.setBackground(Color.white);
		rightpane.setBackground(Color.gray);
		leftpane.setLayout(new GridLayout(3,1));
		
		/* 
		 * Create buttons
		 */
		JButton calButton = new JButton("Calculate");
		JButton predictButton = new JButton("Predict");
		JButton insertRowButton = new JButton("Insert Row");
		leftpane.add(calButton);
		leftpane.add(predictButton);
		leftpane.add(insertRowButton);

		/* 
		 * Table, select which row is editable 
		 */
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
		
		/* 
		 * Insert button action.
		 * Insert new row, and increase table length.
		 */
		insertRowButton.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e) {
				tableLength += 20;
				table.setPreferredSize(new Dimension(750, tableLength));
				model.insertRow(1, new Object[]{"","","","", new Double(0)});
				rowCount++;
				lastRow++;
			}
		});		
		
		/*
		 * Predict button action.
		 * Get total and row count, pass it to to Predict function. 
		 */
		predictButton.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e){
				double total=0;
				for(int i=1; i<lastRow;i++){
					Object value = model.getValueAt(i, 4 );
				    total += Double.parseDouble( String.valueOf( value ) );
				}
				Predict predictTransaction = new Predict(total, rowCount);
			}
		});
		
		/*
		 * About button action.
		 * Call function for detail about MoneyNest4You.
		 */
		about.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e) {
				About about2 = new About();
			}
		});	
		
		/*
		 * Calculate button action.
		 * Call update function to calculate amount total.
		 */
		calButton.addActionListener(new ActionListener(){	
			public void actionPerformed (ActionEvent e){
					update();
			}
		});
		
		/*
		 * Save menu item action.
		 * Create text file, read in data, and save data to text file.
		 */
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
		
		/*
		 * Exit program.
		 */
		class exitaction implements ActionListener{
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		}
		
		exit.addActionListener(new exitaction());
	}
	
	/*
	 * Update function
	 * Loop through the table, get amount value, and add them to total.
	 * Insert total to the Total column.
	 */
    public static void update(){
    	double total=0;
		for(int i=1; i<lastRow;i++){
			Object value = model.getValueAt(i, 4 );
		    total += Double.parseDouble( String.valueOf( value ) );
		}
		model.setValueAt(total, lastRow, 4 );
    }
    
    /*
     * Call MoneyNest4You function.
     */
	public static void main(String[] args)
	{
		MoneyNest4You mn4y = new MoneyNest4You();
	}


	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}