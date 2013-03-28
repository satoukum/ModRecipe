package com.modrecipe.modrecipe.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import android.widget.ArrayAdapter;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.listhelpers.ListExpandableListAdapter;
import com.modrecipe.modrecipe.mealshelpers.MealExpandableListAdapter;

public class DataSingleton {

	private static DataSingleton instance = null; 
	
	public static User user = new User();
	public static HashMap<java.util.UUID, com.modrecipe.modrecipe.objects.Recipe> recipes = new HashMap<java.util.UUID, com.modrecipe.modrecipe.objects.Recipe>();
	
	protected DataSingleton() { 
		// Exists only to defeat instantiation. 
		 // TODO fix up; // is this the right place?
	}
	
	public static DataSingleton getInstance() { 
		if(instance == null) { 
			instance = new DataSingleton(); 
			user = setUser(); // TODO fix up
		} 
		return instance; 
	}
	
	/**
	 * Holds all the recipes
	 */
	public static void setRecipes() {
		
		recipes = new HashMap<java.util.UUID, com.modrecipe.modrecipe.objects.Recipe>();
		
		Recipe r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c4a32e87-f664-439a-a6f9-da3e4af81f39"));
		r.setImageResource(R.drawable.recipe_broccolichickendivan);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients1());
		r.setName("Broccoli Chicken Divan");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("78c12828-55d6-48dd-9f5f-0af37865b33f"));
		r.setImageResource(R.drawable.recipe_sweetandsourmeatballs);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients2());
		r.setName("Sweet and Sour Meatballs");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("e7a004cf-a110-4652-9dd2-ac2cea285feb"));
		r.setImageResource(R.drawable.recipe_easychickenpotpie);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients3());
		r.setName("Easy Chicken Pot Pie");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("968e212f-a7e4-4fa6-98b8-dece3bcf1eda"));
		r.setImageResource(R.drawable.recipe_sweetandsourchicken);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients6());
		r.setName("Sweet and Sour Chicken");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		// HASHED
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f35"));
		r.setImageResource(R.drawable.recipe2);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients3());
		r.setName("Chicken Pot Pie Bites");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f34"));
		r.setImageResource(R.drawable.recipe6);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients3());
		r.setName("Lentil Soup");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f33"));
		r.setImageResource(R.drawable.recipe3);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients3());
		r.setName("Creamy Braised Chicken with Pappardelle");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f32"));
		r.setImageResource(R.drawable.recipe4);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients3());
		r.setName("Cowboy Cookies");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);

		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f31"));
		r.setImageResource(R.drawable.recipe5);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients3());
		r.setName("Triple Decker Peaut Butter Brownies");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f30"));
		r.setImageResource(R.drawable.recipe1);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients3());
		r.setName("Cappuccino-Chocolate Cupcakes");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);

		recipes.put(r.getUUID(), r);
		
		
	}
	/**
	public void setRecipes(User user){
		this.user = user;
	}*/
	public HashMap<java.util.UUID, com.modrecipe.modrecipe.objects.Recipe> getRecipes(){
		return recipes;
	}
	
	// On List Section Fragment, This is the Expandable List Adapter
	private ListExpandableListAdapter ExpListAdapter;
	public ListExpandableListAdapter getListExpAdapter() {
		return ExpListAdapter;
	}
	public void setListExpAdapter(ListExpandableListAdapter ExpListAdapter) {
		this.ExpListAdapter = ExpListAdapter;
	}
	
	// On Meal Section Fragment, This is the Expandable List Adapter
	private MealExpandableListAdapter ExpMealAdapter;
	public MealExpandableListAdapter getMealExpAdapter() {
		return ExpMealAdapter;
	}
	public void setMealExpAdapter(MealExpandableListAdapter ExpMealAdapter) {
		this.ExpMealAdapter = ExpMealAdapter;
	}	

	// Meal Section Fragment -> Add Meal -> from Liked Meals -> AddMealActivity adapter
	private ArrayAdapter<Recipe> FLMAdapter = null;
	public ArrayAdapter<Recipe> getFromLikedMealsAdapter() {
		return FLMAdapter;
	}
	public void setFromLikedMealsAdapter(ArrayAdapter<Recipe> FLMAdapter) {
		this.FLMAdapter = FLMAdapter;
	}
	// Meal Section Fragment -> Add Meal -> from Pinned Meals -> AddMealActivity adapter
	private ArrayAdapter<Recipe> FPMAdapter = null;
	public ArrayAdapter<Recipe> getFromPinnedMealsAdapter() {
		return FPMAdapter;
	}
	public void setFromPinnedMealsAdapter(ArrayAdapter<Recipe> FPMAdapter) {
		this.FPMAdapter = FPMAdapter;
	}	
	
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}
	
	public static User setUser() {
		
		// Recipes database
		setRecipes(); // TODO
		
	    // SET UP SINGLETON
	    User testUser = new User();
	    testUser.setEmail("nielsen.marissa@gmail.com");
	    testUser.setName("Marissa Nielsen");
	    testUser.setUsername("marissa");
	    
	    testUser.setFbloginid(null); // TODO
	    testUser.setFollowerList(null); //TODO
	    testUser.setFollowingList(null); //TODO

	    testUser.setPinnedRecipesList(null); //TODO
	    testUser.setFavoriteRecipesList(null); //TODO
	    testUser.setShoppingList();
	    testUser.setDefaultMeals();
	    testUser.setDefaultLikedMeals();
	    testUser.setDefaultPinnedMeals();
	    testUser.setPastRecipes();
	    
	    return testUser;
	}


    
private static ArrayList<String> fakeDirections = new ArrayList<String>();
private static ArrayList<String> setFakeDirections1() {
	
	fakeDirections.add("Combine rice with 1 1/2 c. water and cook for 20 minutes.");
	fakeDirections.add("While rice is cooking, combine ground beef, egg, onion, bread crumbs, " +
    			"and salt and pepper. Form into 1-in meatballs, and broil on a rimmed " +
    			"cookie sheet on low in the oven until cooked through.");
	fakeDirections.add("Bring pineapple juice and oil to a boil for one minute. Meanwhile, mix" +
    			"soy sauce, sugar, and vinegar together. Add to the boiling juice and " +
    			"simmer on medium until sauce thickens.");
	fakeDirections.add("Combine sauce, meatballs, and canned fruit. Serve hot over fresh rice." +
				"Can be served or warmed in crockpot as well.");
	
	return fakeDirections;
}

private static ArrayList<Ingredient> setFakeIngredients1() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("1 c. Cheddar Cheese, grated"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);
	i = new Ingredient("1/4 c. Bread Cumbs"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 t. Curry Powder"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Mayonnaise"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1 c. Rice"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("3 Chicken Breasts"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);	
	
	return fakeIngredients;
}


private static ArrayList<Ingredient> fakeIngredients = new ArrayList<Ingredient>();
private static ArrayList<Ingredient> setFakeIngredients2() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("1 lb. Ground Beef"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);
	i = new Ingredient("1 Egg"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Yellow Onion, chopped"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1/4 c. Bread Crumbs"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 t. Salt"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 t. Pepper"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 c. Rice"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 T. Oil"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 T. Soy Sauce"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Sugar"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("3 T. Apple Cider Vinegar"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("15 oz. can Pineapple Tidbits"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	i = new Ingredient("8 oz. Mandarin Oranges"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	
	return fakeIngredients;
}

private static ArrayList<Ingredient> setFakeIngredients3() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("1 can Cream of Chicken Soup"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	i = new Ingredient("1 can Cream of Mushroom Soup"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. White Onion"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);	
	i = new Ingredient("1 pkg. Pie Shells"); i.setCategory("FROZEN ITEMS");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Miracle Whip"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1 bag Frozen Mixed Vegetables"); i.setCategory("FROZEN ITEMS");
	fakeIngredients.add(i);
	i = new Ingredient("2 Chicken Breasts"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);	
	
	return fakeIngredients;
}
   
private static ArrayList<Ingredient> setFakeIngredients6() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("1/2 Green Bell Pepper"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 Red Bell Pepper"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1 15 oz can Pineapple Tidbits"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Yellow Onion"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1 10 oz bottle Italian dressing"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1 10 oz jar Approcot jam"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1 c. Rice"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("2 Chicken Breasts"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);	
		
	return fakeIngredients;
}

/**
 * Collapse groups once everything is selected:
   If the ingredient just striked is the last one in that category,
   move that shopping category to the end of the list.
 * @param child
 * @param scList
 */
public void checkGroupToBottom(Ingredient child) {
	ArrayList<ShoppingCategory> scList = getUser().getShoppingList();
	boolean moveToBottom = true;
	for (ShoppingCategory sc : scList) {
		if (sc.getName().equals(child.getCategory())) {
			for (Ingredient elc : sc.getIngredientList()) {
				if (!elc.getStriked()) {
    				moveToBottom = false;
    			}
			}
		}
	}
	if (moveToBottom) {
		ShoppingCategory removeMe = null;
		for (ShoppingCategory sc : scList) {
			if (sc.getName().equals(child.getCategory())) {
				removeMe = sc;
				removeMe.setBottom(true);
			}
		}
		scList.remove(removeMe);
		scList.add(removeMe);
		DataSingleton.getInstance().getListExpAdapter().notifyDataSetChanged();
	}
}
/**
 * Moves ShoppingCategory group back to the top 
   if item unclicked and the group was on the bottom
 * @param child
 * @param scList
 */
public void checkGroupToTop(Ingredient child) {
	ArrayList<ShoppingCategory> scList = getUser().getShoppingList();
	
	boolean moveToTop = false;
	for (ShoppingCategory sc : scList) {
		if (sc.getName().equals(child.getCategory())) {
			if (sc.getBottom() == true) {
				moveToTop = true;
			}
		}
	}
	if (moveToTop) {
		ShoppingCategory moveMeUp = null;
		for (ShoppingCategory sc : scList) {
			if (sc.getName().equals(child.getCategory())) {
				moveMeUp = sc;
				moveMeUp.setBottom(false);
			}
		}
		scList.remove(moveMeUp);
		scList.add(0, moveMeUp);
		DataSingleton.getInstance().getListExpAdapter().notifyDataSetChanged();
	}
}
	
}
