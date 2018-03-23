package lab1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TestGUI {

	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Вариант 17");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	    frame.setMinimumSize(new Dimension(210, 125));
		
	    /* init all component */
	    JLabel wordInputMsg = new JLabel("Слово");
	    JLabel letterInputMsg = new JLabel("Буква");
	    JLabel resultOutputMsg = new JLabel(" ");
	    
	    JTextField wordInputFld = new JTextField(10);
		JTextField letterInputFld = new JTextField(10);
		
		JButton getResultBtn = new JButton("Посчитать");
		
		/* set event listener to result button */
		getResultBtn.addActionListener(new ActionListener() {		
			@Override	
			public void actionPerformed(ActionEvent e) {
				resultOutputMsg.setText("123");
			}
		});
		
		wordInputFld.addKeyListener(new KeyListener() {			 
			@Override
		    public void keyTyped(KeyEvent event) {
				letterInputMsg.setText(wordInputFld.getText());
		    }
		 
		    @Override
		    public void keyReleased(KeyEvent event) {
		    	letterInputMsg.setText(wordInputFld.getText());
		    }
		 
		    @Override
		    public void keyPressed(KeyEvent event) {
		    	letterInputMsg.setText(wordInputFld.getText());
		    }
		});
		
		/* set event listener to input field */
		
		
		/* setup top level panels */
		JPanel resultPanel = new JPanel();	  
	    resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 0));
	    resultPanel.add(getResultBtn);
	    resultPanel.add(resultOutputMsg);
	    
	    JPanel appPanel = new JPanel();
	    appPanel.setLayout(new GridBagLayout());
		
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(0,4,4,0);        
	    c.anchor = GridBagConstraints.LINE_START;
	    
	    c.gridx = 0;
	    c.gridy = 0;        
	    appPanel.add(wordInputMsg, c);        
	 
	    c.gridx = 1;
	    c.gridy = 0;        
	    appPanel.add(wordInputFld, c);	        
	    
	    c.gridx = 0;
	    c.gridy = 1;       
	    appPanel.add(letterInputMsg, c);
	        
	    c.gridx = 1;
	    c.gridy = 1;  
	    appPanel.add(letterInputFld, c);
	        
	    c.gridx = 0;
	    c.gridy = 2;
	    c.gridwidth = 0;
	    appPanel.add(resultPanel, c);
	    
	    /* add application panel to main frame */
	    frame.add(appPanel);
		frame.pack();
	    frame.setVisible(true);
	}
	
	public static void main() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createAndShowGUI();
            }
        });
	}
}
