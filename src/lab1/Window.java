package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Window {
	private static JLabel wordInputMsg = new JLabel("Слово");
	private static JLabel letterInputMsg = new JLabel("Буква");
	private static JLabel resultOutputMsg = new JLabel(" ");
	
	private static JTextField wordInputFld = new JTextField(10);
	private static JTextField letterInputFld = new JTextField(10);
	private static JButton getResultBtn = new JButton("Посчитать");
	
	private static String wordBuffer;
	private static String letterBuffer;
	
	private static final String errMsg = "bag args";
	private static String testBuffer;
	
	private static int getResult() {
		int result = 0;
		for(int i = 0; i < wordBuffer.length(); i++) {
			if( wordBuffer.charAt(i) == letterBuffer.charAt(0) )
				result++;
		}
		return result;
	}
	   
	private static void createAndShowGUI() {
		
		getResultBtn.addActionListener(new ActionListener() {		
			@Override	
			public void actionPerformed(ActionEvent e) {
				wordBuffer = wordInputFld.getText();
				letterBuffer = letterInputFld.getText();
				
				if(wordBuffer.isEmpty())
					resultOutputMsg.setText(" ");
				else if(letterBuffer.isEmpty())
					resultOutputMsg.setText(" ");
				else if(wordBuffer.isEmpty() && letterBuffer.isEmpty())
					resultOutputMsg.setText(" ");
				else if(letterBuffer.length() != 1) {
					resultOutputMsg.setText(" ");
				}
				else {
					int result = getResult();
					resultOutputMsg.setText(" ");
					resultOutputMsg.setText(Integer.toString(result));
				}
			}
		});
		
		letterInputFld.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  testBuffer = letterInputFld.getText();			  
			  }
			  public void removeUpdate(DocumentEvent e) {
				  testBuffer = letterInputFld.getText();				  
			  }
			  public void insertUpdate(DocumentEvent e) {
				  testBuffer = letterInputFld.getText();			  
			  }
		});
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		 	
	    JFrame frame = new JFrame("Вариант 17");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	    frame.setMinimumSize(new Dimension(210, 125));
	                                     
	    JPanel resultPanel = new JPanel();	  
	    resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 0));
	    resultPanel.add(getResultBtn);
	    resultPanel.add(resultOutputMsg);
	        
	    JPanel inputPanel = new JPanel();
	    inputPanel.setBorder(blackline);
	    inputPanel.setLayout(new GridBagLayout());
	        
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(0,4,4,0);        
	    c.anchor = GridBagConstraints.LINE_START;
	     
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
	    inputPanel.add(resultPanel, c);    
	        
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
