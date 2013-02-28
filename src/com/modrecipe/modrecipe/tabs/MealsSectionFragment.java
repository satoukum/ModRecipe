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

	private ArrayList<Recipe> ExpListItems = new ArrayList<Recipe>();
	private ExpandableListView ExpandList;
	
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
/**	
    public ArrayList<ExpandableListGroup> SetStandardGroups() {
    	ArrayList<ExpandableListGroup> list = new ArrayList<ExpandableListGroup>();
    	ArrayList<ExpandableListChild> list2 = new ArrayList<ExpandableListChild>();
    	
        ExpandableListGroup gru1 = new ExpandableListGroup();
        gru1.setName("Chicken Pot Pie Bites");
        ExpandableListChild ch1_1 = new ExpandableListChild();
        ch1_1.setName("All-purpose flour, as needed"); ch1_1.setTag(null); list2.add(ch1_1);
        ExpandableListChild ch1_2 = new ExpandableListChild();
        ch1_2.setName("2 14-16 oz packages all-butter puff pastry, thawed"); ch1_2.setTag(null); list2.add(ch1_2);
        ExpandableListChild ch1_3 = new ExpandableListChild();
        ch1_3.setName("1 egg"); ch1_3.setTag(null); list2.add(ch1_3);
        ExpandableListChild ch1_4 = new ExpandableListChild();
        ch1_4.setName("1 Tbs water"); ch1_4.setTag(null); list2.add(ch1_4); 
        ExpandableListChild ch1_5 = new ExpandableListChild();
        ch1_5.setName("1 lb chicken"); ch1_5.setTag(null); list2.add(ch1_5); 
        ExpandableListChild ch1_6 = new ExpandableListChild();
        ch1_6.setName("2 tsp olive oil"); ch1_6.setTag(null); list2.add(ch1_6); 
        ExpandableListChild ch1_7 = new ExpandableListChild();
        ch1_7.setName("Kosher salt, to taste"); ch1_7.setTag(null); list2.add(ch1_7); 
        ExpandableListChild ch1_8 = new ExpandableListChild();
        ch1_8.setName("Black pepper, to taste"); ch1_8.setTag(null); list2.add(ch1_8); 
        ExpandableListChild ch1_9 = new ExpandableListChild();
        ch1_9.setName("3 Tbs butter, unsalted"); ch1_9.setTag(null); list2.add(ch1_9); 
        ExpandableListChild ch1_10 = new ExpandableListChild();
        ch1_10.setName("1/3 c. shallot, finely chopped "); ch1_10.setTag(null); list2.add(ch1_10);         
        ExpandableListChild ch1_11 = new ExpandableListChild();
        ch1_11.setName("1/4 c. carrot, finely chopped "); ch1_11.setTag(null); list2.add(ch1_11);         
        ExpandableListChild ch1_12 = new ExpandableListChild();
        ch1_12.setName("3/4 c. heavy cream"); ch1_12.setTag(null); list2.add(ch1_12);         
        ExpandableListChild ch1_13 = new ExpandableListChild();
        ch1_13.setName("1/2 c. chicken stock"); ch1_13.setTag(null); list2.add(ch1_13);         
        ExpandableListChild ch1_14 = new ExpandableListChild();
        ch1_14.setName("1/4 tsp. ground sage"); ch1_14.setTag(null); list2.add(ch1_14);         
        gru1.setItems(list2);        
        list2 = new ArrayList<ExpandableListChild>();       
        
        
        ExpandableListGroup gru6 = new ExpandableListGroup();
        gru6.setName("BBQ Chicken Pizza");
        ExpandableListChild ch6_1 = new ExpandableListChild();
        ch6_1.setName("2 10 3/4 oz can Campbell's Cream of Chicken Soup");
        ch6_1.setTag(null);
        list2.add(ch6_1);
        ExpandableListChild ch6_2 = new ExpandableListChild();
        ch6_2.setName("1 10 3/4 oz can Campbell's Cream of Mushroom Soup");
        ch6_2.setTag(null);
        list2.add(ch6_2);
        gru6.setItems(list2);
        list2 = new ArrayList<ExpandableListChild>();    
        
        list.add(gru1);
        list.add(gru2);
        list.add(gru3);
        list.add(gru4);
        list.add(gru5);        
        list.add(gru6);
        
        //BREAKFAST & CEREAL
        //BEVERAGES
        //CANNED GOODS & SOUPS
        //FROZEN ITEMS
        //MEAT & SEAFOOD
        
        return list;
    }	
*/	
}