package maven.archetype.webapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * App to sort and score memes
 *
 */
public class MemeSorter 
{
    public static void main( String[] args )
    {
    	File file = new File(System.getProperty("user.dir")+"\\resources\\memes_input_file.txt");
		List<Meme> l = deserialize(file);
		sortMemes(l);
		assignMemeScore(l);
		serialize(l,file);
	 
    }
    
    
    /*
     * Function to deserialize json objects to into
     * a list of Java objects
     */
	public static List<Meme> deserialize(File file){
		try {   	
			// get json as buffer from file
			BufferedReader br = new BufferedReader(new FileReader(file));
			// Usign Gson library to serialize and deserialize
			Gson gson = new Gson();
			List<Meme> list = gson.fromJson(br, new TypeToken<ArrayList<Meme>>() {}.getType());			   			   
			return list;
			
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }
		 return null;  
	}
	
	/*
	 * Function to sort the memes based on the meme name using Comparator
	 */
	public static void sortMemes(List<Meme> list) {
		Collections.sort(list, Meme.MemeNameComparator);
	}
	
	/*
	 * Function to assign random lulz score from 1-10
	 */
	public static void assignMemeScore(List<Meme> list) {
		
		Random rand = new Random();
		for (int i=0; i< list.size(); i++) {
			 list.get(i).setLulz_Score(rand.nextInt(10)+1);
		}
	}
	
	
	/*
	 * Function to serialize sorted objects with lulz scores to json objects and 
	 * writing to the same file
	 */
	public static void serialize(List<Meme> list, File file) {

		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
			String json = gson.toJson(list);
			br.write(json);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
