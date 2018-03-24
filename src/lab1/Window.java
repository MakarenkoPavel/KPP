package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * {@code Window} class is the main class of application.
 * This class designed to setup all GUI functional
 * @author Pavel
 * @version 1.0
 */
public class Window {
	
	private static final int FIELD_LENGTH = 10;
	private static final int WIDTH = 210;
	private static final int HEIGHT = 125;
	
	private static Process operation = new Process();
	
	/*
	 * Setup all GUI components
	 */
	public static void createAndShowGUI() {
		
		JFrame frame = new JFrame("Вариант 17");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	    frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
	    /* init all component */
	    JLabel wordInputMsg = new JLabel("Слово");
	    JLabel letterInputMsg = new JLabel("Буква");
	    JLabel resultOutputMsg = new JLabel(" ");
	    
	    JTextField wordInputFld = new JTextField(FIELD_LENGTH);
		//JTextField letterInputFld = new JTextField(10);
		CharTextField letterInputFld = new CharTextField(FIELD_LENGTH, 1);
	
		//JButton getResultBtn = new JButton("Посчитать");	
		ColoredButton getResultBtn = new ColoredButton("Посчитать", Color.WHITE, Color.LIGHT_GRAY);	
		
		/* set event listener to result button */
		getResultBtn.addActionListener(new ActionListener() {		
			@Override	
			public void actionPerformed(ActionEvent event) {
				
				operation.setWord(wordInputFld.getText());
				operation.setLetter(letterInputFld.getText());
				resultOutputMsg.setText(operation.getResult());
			}
		});
		
		/* add focus listener to text fields */
		wordInputFld.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent event) {
               	
            	wordInputFld.setBorder(BorderFactory.createMatteBorder(
                                    3, 1, 1, 1, Color.GRAY));
            }

            @Override
            public void focusLost(FocusEvent event) {

            	wordInputFld.setBorder(BorderFactory.createMatteBorder(
                        1, 1, 1, 1, Color.LIGHT_GRAY));
            }
        });
		
		letterInputFld.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent event) {
            
            	letterInputFld.setBorder(BorderFactory.createMatteBorder(
                        3, 1, 1, 1, Color.GRAY));      	
            }

            @Override
            public void focusLost(FocusEvent event) {

            	letterInputFld.setBorder(BorderFactory.createMatteBorder(
                        1, 1, 1, 1, Color.LIGHT_GRAY));
            }
        });	
		
		/* setup top level panels */
		JPanel resultPanel = new JPanel();	  
	    resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 0));
	    resultPanel.add(getResultBtn);
	    resultPanel.add(resultOutputMsg);
	    
	    JPanel appPanel = new JPanel();
	    appPanel.setLayout(new GridBagLayout());
		
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(0, 4, 4, 0);        
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
	
	/*
	 * The main method
	 */
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createAndShowGUI();
            }
        });
	}
}
