package lab1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 * {@code CharTextField} class implements override of {@code JTextField}
 * with new event listeners
 * 
 * @author pavel
 * @version 1.0
 */
public class CharTextField extends JTextField {
	
	private String buffer;
	private int limit;
	
	/**
	 * Initialization constructor
	 * 
	 * @param len		length of text field
	 * @param limit		limits chars to input
	 */
	public CharTextField(int len, int limit) {
		super(len);
		this.limit = limit;
		
		this.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  
				  buffer = getText();	
				  System.out.println(buffer);
			  }
			  public void removeUpdate(DocumentEvent e) {

				  buffer = getText();				
				  System.out.println(buffer);
			  }
			  public void insertUpdate(DocumentEvent e) {
				  buffer = getText();
				  System.out.println(buffer);
			  }
			});
		
		this.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (getText().length() >= limit) 
		            e.consume(); 
		    }  
		});
			
	}
	
}
