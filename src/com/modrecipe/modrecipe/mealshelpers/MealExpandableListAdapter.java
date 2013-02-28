package com.modrecipe.modrecipe.mealshelpers;

import java.util.ArrayList;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.R.id;
import com.modrecipe.modrecipe.R.layout;
import com.modrecipe.modrecipe.main.*;
import com.modrecipe.modrecipe.objects.Ingredient;
import com.modrecipe.modrecipe.objects.Recipe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Taken from: http://www.dreamincode.net/forums/topic/270612-how-to-get-started-with-expandablelistview/
 * 
 *
 */
public class MealExpandableListAdapter extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<Recipe> groups;
	public MealExpandableListAdapter(Context context, ArrayList<Recipe> groups) {
		this.context = context;
		this.groups = groups;
	}
	
	public void addItem(Ingredient item, Recipe group) {
		if (!groups.contains(group)) {
			groups.add(group);
		}
		int index = groups.indexOf(group);
		ArrayList<Ingredient> ch = groups.get(index).getIngredientList();
		ch.add(item);
		groups.get(index).setIngredientList(ch);
	}
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		ArrayList<Ingredient> chList = groups.get(groupPosition).getIngredientList();
		return chList.get(childPosition);
	}

	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view,
			ViewGroup parent) {
		final Ingredient child = (Ingredient) getChild(groupPosition, childPosition);
		
		if (view == null) {
			LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			view = infalInflater.inflate(R.layout.meal_expandlist_child_item, null);
		}
		final TextView tv = (TextView) view.findViewById(R.id.tvChild);
		tv.setText(child.getTitle().toString());
		tv.setTag(child.getTag());
    		
		// TODO Auto-generated method stub
		return view;
	}

	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		ArrayList<Ingredient> chList = groups.get(groupPosition).getIngredientList();
		return chList.size();

	}

	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return groups.get(groupPosition);
	}

	public int getGroupCount() {
		// TODO Auto-generated method stub
		return groups.size();
	}

	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	public View getGroupView(int groupPosition, boolean isLastChild, View view,
			ViewGroup parent) {
		final Recipe group = (Recipe) getGroup(groupPosition);
		if (view == null) {
			LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			view = inf.inflate(R.layout.meal_expandlist_group_item, null);
		}
		TextView tv = (TextView) view.findViewById(R.id.tvGroup);
		tv.setText(group.getName());
		
		//gotoBtn
		ImageView iv = (ImageView) view.findViewById(R.id.gotoBtn);
		iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent childActivityIntent = new Intent(v.getContext(),
				RecipeActivity.class);
				
            	childActivityIntent.putExtra("recipe_imgsrc", group.getImageResource());
            	childActivityIntent.putExtra("allowpin", "true");
            	v.getContext().startActivity(childActivityIntent);
            }
        });

		
		// TODO Auto-generated method stub
		return view;
	}

	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}


