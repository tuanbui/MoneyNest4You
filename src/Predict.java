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
 * Predict.java
 * With total amount and row count, Predict function calculates 
 * and print approximate amount. 
 */

import java.awt.FlowLayout;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Predict {
	double approx = 0;
	String s1 = "<html>From the transaction table,<br> your next expenditure<br> will be:</html>";
	public Predict(double total, int count){
		JFrame frame = new JFrame("Predict");
		approx = total / (count-1);
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMinimumFractionDigits(2);
		JLabel label1 = new JLabel(s1, SwingConstants.CENTER);
		JLabel label2 = new JLabel("$"+String.valueOf(df.format(approx)), SwingConstants.CENTER);
		label1.setVerticalAlignment(SwingConstants.TOP);
		frame.setSize(270,170);
		frame.add(label1);
		frame.add(label2);
		frame.setVisible(true);	
		
		JScrollPane scroll = new JScrollPane(label1);
		frame.add(scroll);
	}
	
}