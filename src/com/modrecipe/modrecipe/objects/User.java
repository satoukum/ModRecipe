package com.modrecipe.modrecipe.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	
	private static final long serialVersionUID = 5543500557655301047L;
	
	private String Name;
	private String Username;
	private String Fbloginid;
	private String Email;
	private ArrayList<User> FollowerList = new ArrayList<User>();
	private ArrayList<User> FollowingList = new ArrayList<User>();
	private ArrayList<Recipe> FavoriteRecipesList = new ArrayList<Recipe>();
	private ArrayList<Recipe> PinnedRecipesList = new ArrayList<Recipe>();
	private ArrayList<Recipe> MealRecipesList = new ArrayList<Recipe>();
	private ArrayList<ShoppingCategory> ShoppingList = new ArrayList<ShoppingCategory>();	

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getFbloginid() {
		return Fbloginid;
	}
	public void setFbloginid(String fbloginid) {
		Fbloginid = fbloginid;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public ArrayList<User> getFollowerList() {
		return FollowerList;
	}
	public void setFollowerList(ArrayList<User> followerList) {
		FollowerList = followerList;
	}
	public ArrayList<User> getFollowingList() {
		return FollowingList;
	}
	public void setFollowingList(ArrayList<User> followingList) {
		FollowingList = followingList;
	}
	public ArrayList<Recipe> getFavoriteRecipesList() {
		return FavoriteRecipesList;
	}
	public void setFavoriteRecipesList(ArrayList<Recipe> favoriteRecipesList) {
		FavoriteRecipesList = favoriteRecipesList;
	}
	public ArrayList<Recipe> getPinnedRecipesList() {
		return PinnedRecipesList;
	}
	public void setPinnedRecipesList(ArrayList<Recipe> pinnedRecipesList) {
		PinnedRecipesList = pinnedRecipesList;
	}
	public ArrayList<Recipe> getMealRecipesList() {
		return MealRecipesList;
	}
	public void setMealRecipesList(ArrayList<Recipe> mealRecipesList) {
		MealRecipesList = mealRecipesList;
	}
	
	public ArrayList<ShoppingCategory> getShoppingList() {
		return ShoppingList;
	}
	public void setShoppingList(ArrayList<ShoppingCategory> shoppingList) {
		ShoppingList = shoppingList;
	}

	public String toString() {
		return getName();
	}
}
