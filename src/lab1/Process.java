package lab1;

/**
 * {@code Process} class provide functional to count letters in the word
 * 
 * @author pavel
 * @version 1.0
 */

public class Process {
	private String word;
	private String letter;
	
	/**
	 * Set world to count
	 * 
	 * @param word 		new word
	 */
	public void setWord(String word) {
		
		this.word = word;
	}
	
	/**
	 * Set letter to count
	 * 
	 * @param letter	new letter
	 */	
	public void setLetter(String letter) {
		
		this.letter = letter;
	}
	
	/**
	 * Return current word
	 * 
	 * @return		word
	 */
	public String getWord() {
		
		return word;
	}
	
	/**
	 * Return current letter
	 * 
	 * @return		letter
	 */
	public String getLetter() {
		
		return letter;
	}
	
	/**
	 * This method return count of the letters in the word
	 * 
	 * @return		how many letters in the word
	 */
	public String getResult() {
		if(letter.length() != 1) 
			return " ";
			
		Integer count = 0;
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == letter.charAt(0)) {
				count++;
			}
		}	
		return count.toString();	
	}
}
