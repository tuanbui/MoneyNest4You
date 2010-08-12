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
 * About.java
 * Details about MoneyNest4You 
 */

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class About {
	public About(){
		JFrame frame = new JFrame("About");		
		String s = "<html>MoneyNest4You<br><br>Version: 1.0<br><br>Copyright &copy 2010, Tuan Bui. All rights reserved.</html>";
		ImageIcon icon = new ImageIcon("src/moneynest4you.jpg");
		JLabel label = new JLabel(s);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(icon);
		frame.setSize(530,205);
		frame.add(label);
		frame.setVisible(true);	
		
		JScrollPane scroll = new JScrollPane(label);
		frame.add(scroll);
	}
}
