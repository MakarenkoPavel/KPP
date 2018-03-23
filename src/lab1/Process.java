package lab1;

public class Process {
	private String word;
	private String letter;
	
	public void setWord(String word) {
		
		this.word = word;
	}
	
	public void setLetter(String letter) {
		
		this.letter = letter;
	}
	
	public String getWord() {
		
		return word;
	}
	
	public String getLetter() {
		
		return letter;
	}
	
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
