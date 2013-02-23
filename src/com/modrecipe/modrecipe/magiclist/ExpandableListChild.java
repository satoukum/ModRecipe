package com.modrecipe.modrecipe.magiclist;

public class ExpandableListChild {

	private String Name;
	private String Tag;
	private boolean Striked;
	private ExpandableListGroup Elg;
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public boolean getStriked() {
		return Striked;
	}
	public void setStrike(boolean striked) {
		this.Striked = striked;
	}
	public ExpandableListGroup getExpandableListGroup() {
		return Elg;
	}
	public void setExpandableListGroup(ExpandableListGroup elg) {
		this.Elg = elg;
	}
	public String getTag() {
		return Tag;
	}
	public void setTag(String Tag) {
		this.Tag = Tag;
	}
	
}


