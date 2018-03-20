package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Window {
	
	private static void createAndShowGUI() {
	   
		 	Border blackline = BorderFactory.createLineBorder(Color.black);
		 	
	        JFrame frame = new JFrame("Вариант 17");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	        frame.setMinimumSize(new Dimension(210, 125));
	       
	        /* Components init block */
	        JLabel wordInputMsg = new JLabel("Слово");
	        JLabel letterInputMsg = new JLabel("Буква");
	        JLabel resultOutputMsg = new JLabel(" ");
	        
	        JTextField wordInputFld = new JTextField(10);
	        JTextField letterInputFld = new JTextField(10);
	               
	        JButton getResultBtn = new JButton("Посчитать");
	        /* Components block end */            
              
	        JPanel firstPanel = new JPanel();
	        firstPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	        firstPanel.add(wordInputMsg);
	        firstPanel.add(wordInputFld);
	        
	        JPanel secondPanel = new JPanel();
	        secondPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	        secondPanel.add(letterInputMsg);
	        secondPanel.add(letterInputFld);
	        
	        JPanel thirdPanel = new JPanel();	  
	        thirdPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 0));
	        thirdPanel.add(getResultBtn);
	        thirdPanel.add(resultOutputMsg);
	        
	        JPanel inputPanel = new JPanel();
	        inputPanel.setBorder(blackline);
	        inputPanel.setLayout(new GridBagLayout());
	        
	        GridBagConstraints c = new GridBagConstraints();
	        c.insets = new Insets(0,4,4,0);
	        
	        c.anchor = GridBagConstraints.LINE_START;
	        //c.anchor = GridBagConstraints.CENTER;
	     
	        c.gridx = 0;
	        c.gridy = 0;        
	        inputPanel.add(wordInputMsg, c);        
	 
	        c.gridx = 1;
	        c.gridy = 0;        
	        inputPanel.add(wordInputFld, c);	        
	    
	        c.gridx = 0;
	        c.gridy = 1;       
	        inputPanel.add(letterInputMsg, c);
	        
	        c.gridx = 1;
	        c.gridy = 1;  
	        inputPanel.add(letterInputFld, c);
	        
	        c.gridx = 0;
	        c.gridy = 2;
	        c.gridwidth = 0;
	        inputPanel.add(thirdPanel, c);    
	        
	        JPanel panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	        
	        
	        panel.add(inputPanel);
	   
	        frame.add(panel);
	        frame.pack();
	        frame.setVisible(true);
	    }
	 
	    public static void main(String[] args) {

	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
}
