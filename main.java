import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class main extends JPanel{
	public main() {
        super(new GridLayout(1,0));

        String[] columnTitles = {"First Name",
                                "Last Name",
                                "Account Type",
                                "Account Number",
                                "Transaction Amount"};

        Object[][] data = {
	    {"-", "-",
	     "-", "00000000", new Float(0.0)}
        };
        
        

        JTable table = new JTable(data, columnTitles);
        table.setSize(1100, 200);

        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
    }

	public static void main (String[] args){
		JFrame frame = new JFrame("MoneyNest4You");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 300);
		main newContentPane = new main();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
		
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
		
		class exitaction implements ActionListener{
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		}
		exit.addActionListener(new exitaction());
	}
}
