package com.modrecipe.modrecipe.listhelpers;

public class Ingredient1 {

	private String Name;
	private String Tag;
	private boolean Striked;
	private Recipe1 Elg;
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public boolean isStriked() {
		return Striked;
	}
	public void setStrike(boolean striked) {
		this.Striked = striked;
	}
	public Recipe1 getExpandableListGroup() {
		return Elg;
	}
	public void setExpandableListGroup(Recipe1 elg) {
		this.Elg = elg;
	}
	public String getTag() {
		return Tag;
	}
	public void setTag(String Tag) {
		this.Tag = Tag;
	}
	
}


