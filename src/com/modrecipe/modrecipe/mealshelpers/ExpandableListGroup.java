package com.modrecipe.modrecipe.mealshelpers;

import java.util.ArrayList;

public class ExpandableListGroup {
 
	private String Name;
	private ArrayList<ExpandableListChild> Items;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public ArrayList<ExpandableListChild> getItems() {
		return Items;
	}
	public void setItems(ArrayList<ExpandableListChild> Items) {
		this.Items = Items;
	}
	
	
}


