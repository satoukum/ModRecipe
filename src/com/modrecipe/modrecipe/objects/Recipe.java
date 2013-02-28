package com.modrecipe.modrecipe.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import com.modrecipe.modrecipe.R.drawable.*;

/**
 * Conversation Object
 * @author Marissa.Nielsen
 *
 */
public class Recipe implements Serializable {

	private static final long serialVersionUID = 5543500557655301047L;

	private UUID UUID;
	private String Name;
	private ArrayList<Ingredient> IngredientList = new ArrayList<Ingredient>();
	private ArrayList<String> DirectionsList = new ArrayList<String>();
	private double ReadyInHours;
	private int ReadyInMinutes;
	private double Servings;
	private int imageResource;
	//private rating
	
	public Recipe() {
		//do nothing
	}
	
	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public ArrayList<Ingredient> getIngredientList() {
		return IngredientList;
	}



	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		IngredientList = ingredientList;
	}



	public ArrayList<String> getDirectionsList() {
		return DirectionsList;
	}



	public void setDirectionsList(ArrayList<String> directionsList) {
		DirectionsList = directionsList;
	}



	public double getReadyInHours() {
		return ReadyInHours;
	}



	public void setReadyInHours(double readyInHours) {
		ReadyInHours = readyInHours;
	}



	public int getReadyInMinutes() {
		return ReadyInMinutes;
	}



	public void setReadyInMinutes(int readyInMinutes) {
		ReadyInMinutes = readyInMinutes;
	}



	public double getServings() {
		return Servings;
	}



	public void setServings(double servings) {
		Servings = servings;
	}
	
	public UUID getUUID() 
	{
		return UUID;
	}
	public void setUUID(UUID UUID) {
		this.UUID = UUID;
	}
	
	public int getImageResource() {
		return imageResource;
	}
	public void setImageResource(int imageResource) {
		this.imageResource = imageResource;
	}

	/**
	 * ToString Method :)
	 */
	public String toString() {
		return getName();
	}


}