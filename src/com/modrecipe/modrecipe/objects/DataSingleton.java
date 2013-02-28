package com.modrecipe.modrecipe.objects;

import java.util.ArrayList;

public class DataSingleton {

	private static DataSingleton instance = null; 
	
	public static User user = new User();
	
	protected DataSingleton() { 
		// Exists only to defeat instantiation. 
	}
	
	public static DataSingleton getInstance() { 
		if(instance == null) { 
			instance = new DataSingleton(); 
			user = setUser(); // TODO fix up
		} 
		return instance; 
	}
	
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}
	
	public static User setUser() {
		
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
	    setShoppingList();        
	    testUser.setMealRecipesList(setMeals()); 
	    testUser.setShoppingList(shoppingList);
	    
	    return testUser;
	}

private static ArrayList<ShoppingCategory> shoppingList = new ArrayList<ShoppingCategory>();
public static void setShoppingList() {
	ShoppingCategory sc = new ShoppingCategory("FRUITS & VEGETABLES");
	sc.setNumber(1);
	shoppingList.add(sc);
	
	sc = new ShoppingCategory("DAIRY, EGGS, & CHEESE");
	sc.setNumber(2);
	shoppingList.add(sc);
	
	sc = new ShoppingCategory("SPICES & BAKING");
	sc.setNumber(3);
	shoppingList.add(sc);
	
	sc = new ShoppingCategory("CONDIMENTS");
	sc.setNumber(4);
	shoppingList.add(sc);
	
	sc = new ShoppingCategory("MEAT & SEAFOOD");
	sc.setNumber(5);
	shoppingList.add(sc);
	
	sc = new ShoppingCategory("CANNED GOODS & SOUPS");
	sc.setNumber(6);
	shoppingList.add(sc);
	
	sc = new ShoppingCategory("FROZEN ITEMS");
	sc.setNumber(1);
	shoppingList.add(sc);
	
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
	i = new Ingredient("3 Breasts of Chicken"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);	
	
	for (Ingredient ingre : fakeIngredients) {
		for (ShoppingCategory shopcat : shoppingList) {
			if (shopcat.getName().equals(ingre.getCategory())) {
				shopcat.addIngredient(ingre);
			}
		}    		
	}
	
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
	
	for (Ingredient ingre : fakeIngredients) {    		
		for (ShoppingCategory shopcat : shoppingList) {
			if (shopcat.getName().equals(ingre.getCategory())) {
				shopcat.addIngredient(ingre);
			}
		}    		
	}
	
	return fakeIngredients;
}
/**
private ArrayList<Ingredient> setFakeIngredients3() {
	
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
	i = new Ingredient("2 Breasts of Chicken"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);	
	
	for (Ingredient ingre : fakeIngredients) {    		
		for (ShoppingCategory shopcat : shoppingList) {
			if (shopcat.getName().equals(ingre.getCategory())) {
				shopcat.addIngredient(ingre);
			}
		}    		
	}
	
	return fakeIngredients;
}
*/   
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
	i = new Ingredient("2 Breasts of Chicken"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);	
	
	for (Ingredient ingre : fakeIngredients) {    		
		for (ShoppingCategory shopcat : shoppingList) {
			if (shopcat.getName().equals(ingre.getCategory())) {
				shopcat.addIngredient(ingre);
			}
		}    		
	}
	
	return fakeIngredients;
}


private static ArrayList setMeals() {
	ArrayList<Recipe> meals = new ArrayList<Recipe>();
	
	Recipe r = new Recipe();
	r.setDirectionsList(setFakeDirections1());
	r.setIngredientList(setFakeIngredients1());
	r.setName("Chicken Divan");
	r.setReadyInHours(1);
	r.setReadyInMinutes(30);
	r.setServings(4);
	
	meals.add(r);
	
	r = new Recipe();
	r.setDirectionsList(setFakeDirections1());
	r.setIngredientList(setFakeIngredients2());
	r.setName("Sweet and Sour Meatballs");
	r.setReadyInHours(1);
	r.setReadyInMinutes(30);
	r.setServings(4);
	
	meals.add(r);
	
	r = new Recipe();
	r.setDirectionsList(setFakeDirections1());
	r.setIngredientList(setFakeIngredients1());//3
	r.setName("Chicken Pot Pie");
	r.setReadyInHours(1);
	r.setReadyInMinutes(30);
	r.setServings(4);
	
	meals.add(r);
/**
	r = new Recipe();
	r.setDirectionsList(setFakeDirections1());
	r.setIngredientList(setFakeIngredients1());
	r.setName("General Tso's Chicken");
	r.setReadyInHours(1);
	r.setReadyInMinutes(30);
	r.setServings(4);
	
	meals.add(r);

	r = new Recipe();
	r.setDirectionsList(setFakeDirections1());
	r.setIngredientList(setFakeIngredients1());
	r.setName("BBQ Chicken Pizza");
	r.setReadyInHours(1);
	r.setReadyInMinutes(30);
	r.setServings(4);
	
	meals.add(r);
*/    	
	r = new Recipe();
	r.setDirectionsList(setFakeDirections1());
	r.setIngredientList(setFakeIngredients6());
	r.setName("Sweet and Sour Chicken");
	r.setReadyInHours(1);
	r.setReadyInMinutes(30);
	r.setServings(4);
	
	meals.add(r);
    
    return meals;    	
	
}
	
}