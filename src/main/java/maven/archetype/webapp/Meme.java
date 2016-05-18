package maven.archetype.webapp;

import java.util.Comparator;


/**
 * Meme class with same member variables as the json
 * Comparator to sort the memes by their name.
 */

public class Meme {
	
	private String name;
	private String url;
	private int lulz_Score;
	
	public Meme(String name, String url, int lulz_score) {
		this.name = name;
		this.url = url;
		this.lulz_Score = lulz_score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getLulz_Score() {
		return lulz_Score;
	}
	public void setLulz_Score(int lulz_Score) {
		this.lulz_Score = lulz_Score;
	}
	
	
	public static Comparator<Meme> MemeNameComparator 
                          = new Comparator<Meme>() {

	    public int compare(Meme m1, Meme m2) {
	    	
	      String Name1 = m1.getName().toUpperCase();
	      String Name2 = m2.getName().toUpperCase();

	      return Name1.compareTo(Name2);

	    }

	};
			
}
