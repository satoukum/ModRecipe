package com.modrecipe.modrecipe.tabs;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.mealshelpers.MealExpandableListAdapter;
import com.modrecipe.modrecipe.mealshelpers.MealAddDialogFragment;
import com.modrecipe.modrecipe.mealshelpers.MealClearDialogFragment;
import com.modrecipe.modrecipe.mealshelpers.MealPastDialogFragment;
import com.modrecipe.modrecipe.objects.DataSingleton;
import com.modrecipe.modrecipe.objects.Recipe;

/**
 * A dummy fragment representing a section of the app, but that simply
 * displays dummy text.
 */
public class MealsSectionFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	public MealsSectionFragment() {
		
	}
	
	static View rootView;

	private static ArrayList<Recipe> ExpListItems = new ArrayList<Recipe>();
	private static ExpandableListView ExpandList;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_meals, container, false);
        
		ExpandList = (ExpandableListView) rootView.findViewById(R.id.ExpList2);
		ExpListItems = DataSingleton.getInstance().getUser().getMealRecipesList(); //SetStandardGroups();
		DataSingleton.getInstance().setMealExpAdapter(new MealExpandableListAdapter(this.getActivity(), ExpListItems)); //??
		ExpandList.setAdapter(DataSingleton.getInstance().getMealExpAdapter());
		
		// clear listener
		ImageView clearBtn = (ImageView) rootView.findViewById(R.id.clearBtn);
		clearBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				DialogFragment newFragment = new MealClearDialogFragment();
			    newFragment.show(getFragmentManager(), "clear");
		
			}
			
		});
		
		// past listener
		ImageView pastBtn = (ImageView) rootView.findViewById(R.id.pastBtn);
		pastBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				DialogFragment newFragment = new MealPastDialogFragment();
			    newFragment.show(getFragmentManager(), "Past Meals");
		
			}
			
		});
		
		// add listener
		ImageView addBtn = (ImageView) rootView.findViewById(R.id.addBtn);
		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				DialogFragment newFragment = new MealAddDialogFragment();
			    newFragment.show(getFragmentManager(), "add");
		
			}
			
		});
		
        return rootView;
        }
}