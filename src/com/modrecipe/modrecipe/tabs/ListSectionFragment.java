package com.modrecipe.modrecipe.tabs;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.listhelpers.ExpandableListAdapter;
import com.modrecipe.modrecipe.listhelpers.Ingredient1;
import com.modrecipe.modrecipe.listhelpers.Recipe1;
import com.modrecipe.modrecipe.listhelpers.ListAddDialogFragment;
import com.modrecipe.modrecipe.listhelpers.ListClearDialogFragment;
import com.modrecipe.modrecipe.objects.DataSingleton;
import com.modrecipe.modrecipe.objects.Ingredient;
import com.modrecipe.modrecipe.objects.Recipe;
import com.modrecipe.modrecipe.objects.ShoppingCategory;
import com.modrecipe.modrecipe.searchhelpers.GroceryListAdapter;

/**
 * A dummy fragment representing a section of the app, but that simply
 * displays dummy text.
 */
public class ListSectionFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	public ListSectionFragment() {
		
	}
	
	private ListView listView1;
	static View rootView;
/**	
	private ExpandableListAdapter ExpAdapter;
	private static ArrayList<Recipe1> ExpListItems = new ArrayList<Recipe1>();
	private ExpandableListView ExpandList;
*/
	private ExpandableListAdapter ExpAdapter;
	private static ArrayList<ShoppingCategory> ExpListItems = new ArrayList<ShoppingCategory>();
	private ExpandableListView ExpandList;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_list, container, false);
		
		//TODO find a better solution
		ExpandList = (ExpandableListView) rootView.findViewById(R.id.ExpList);
		ExpListItems = DataSingleton.getInstance().getUser().getShoppingList(); //SetIngredients(); //SetStandardGroups();
		ExpAdapter = new ExpandableListAdapter(this.getActivity(), ExpListItems); //??
		ExpandList.setAdapter(ExpAdapter);
		
		//TODO make less tacky
		int count = ExpAdapter.getGroupCount();
		for (int position = 1; position <= count; position++)
		    //if (position == 2) { //TODO fix section
		    //	ExpandList.collapseGroup(position - 1);
		    //} else {
				ExpandList.expandGroup(position - 1);
		    //}
		
		// clear listener
		ImageView clearBtn = (ImageView) rootView.findViewById(R.id.clearBtn);
		clearBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// TODO find better way to change the text
				DialogFragment newFragment = new ListClearDialogFragment();
			    newFragment.show(getFragmentManager(), "clear");
			}
			
		});		
		
		// add listener
		ImageView addBtn = (ImageView) rootView.findViewById(R.id.addBtn);
		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// TODO find better way to change the text
				DialogFragment newFragment = new ListAddDialogFragment();
			    newFragment.show(getFragmentManager(), "add");
			}
			
		});		
		
		
		
		
        return rootView;
        }
	
/**	
	public ArrayList<Ingredient> SetIngredients() {
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();
		
		/**
		ArrayList<Recipe> recipes = DataSingleton.getInstance().getUser().getMealRecipesList();
		for (Recipe recipe : recipes) {
			ArrayList<Ingredient> ingredients = recipe.getIngredientList();
			for (Ingredient ingredient : ingredients) {
				//
			}
		}
		
		
		return list;
	}
*/	
/**	
    public ArrayList<Recipe1> SetStandardGroups() {
    	ArrayList<Recipe1> list = new ArrayList<Recipe1>();
    	ArrayList<Ingredient1> list2 = new ArrayList<Ingredient1>();
    	
        Recipe1 gru1 = new Recipe1();
        gru1.setName("FRUITS & VEGETABLES");
        Ingredient1 ch1_1 = new Ingredient1();
        ch1_1.setName("1 White Onion");
        ch1_1.setTag(null);
        list2.add(ch1_1);
        Ingredient1 ch1_2 = new Ingredient1();
        ch1_2.setName("1 Red Onion");
        ch1_2.setTag(null);
        list2.add(ch1_2);
        Ingredient1 ch1_3 = new Ingredient1();
        ch1_3.setName("1 Green Bell Pepper");
        ch1_3.setTag(null);
        list2.add(ch1_3);
        gru1.setItems(list2);        
        list2 = new ArrayList<Ingredient1>();
        
        Recipe1 gru2 = new Recipe1();
        gru2.setName("DAIRY, EGGS, & CHEESE");
        Ingredient1 ch2_1 = new Ingredient1();
        ch2_1.setName("2 Eggs");
        ch2_1.setTag(null);
        list2.add(ch2_1);
        Ingredient1 ch2_2 = new Ingredient1();
        ch2_2.setName("1 Block Cheddar Cheese");
        ch2_2.setTag(null);
        list2.add(ch2_2);
        Ingredient1 ch2_3 = new Ingredient1();
        ch2_3.setName("1 Gallon Milk");
        ch2_3.setTag(null);
        list2.add(ch2_3);
        gru2.setItems(list2);
        list2 = new ArrayList<Ingredient1>();        
        
        Recipe1 gru3 = new Recipe1();
        gru3.setName("SPICES & BAKING");
        Ingredient1 ch3_1 = new Ingredient1();
        ch3_1.setName("1 tsp Salt");
        ch3_1.setTag(null);
        list2.add(ch3_1);
        Ingredient1 ch3_2 = new Ingredient1();
        ch3_2.setName("1 tsp Pepper");
        ch3_2.setTag(null);
        list2.add(ch3_2);
        gru3.setItems(list2);
        list2 = new ArrayList<Ingredient1>();

        Recipe1 gru4 = new Recipe1();
        gru4.setName("MEAT & SEAFOOD");
        Ingredient1 ch4_1 = new Ingredient1();
        ch4_1.setName("3 Breasts Chicken");
        ch4_1.setTag(null);
        list2.add(ch4_1);
        Ingredient1 ch4_2 = new Ingredient1();
        ch4_2.setName("1 lb Hamburger Meat");
        ch4_2.setTag(null);
        list2.add(ch4_2);
        gru4.setItems(list2);
        list2 = new ArrayList<Ingredient1>();
        
        Recipe1 gru6 = new Recipe1();
        gru6.setName("CANNED GOODS & SOUPS");
        Ingredient1 ch6_1 = new Ingredient1();
        ch6_1.setName("2 10 3/4 oz can Campbell's Cream of Chicken Soup");
        ch6_1.setTag(null);
        list2.add(ch6_1);
        Ingredient1 ch6_2 = new Ingredient1();
        ch6_2.setName("1 10 3/4 oz can Campbell's Cream of Mushroom Soup");
        ch6_2.setTag(null);
        list2.add(ch6_2);
        gru6.setItems(list2);
        list2 = new ArrayList<Ingredient1>();        
        
        Recipe1 gru5 = new Recipe1();
        gru5.setName("FROZEN ITEMS");
        Ingredient1 ch5_1 = new Ingredient1();
        ch5_1.setName("2 16 oz bags frozen Mixed Vegetables");
        ch5_1.setTag(null);
        list2.add(ch5_1);
        Ingredient1 ch5_2 = new Ingredient1();
        ch5_2.setName("1 16 oz bags frozen Broccoli Vegetables");
        ch5_2.setTag(null);
        list2.add(ch5_2);
        gru5.setItems(list2);
        list2 = new ArrayList<Ingredient1>();
        
        list.add(gru1);
        list.add(gru2);
        list.add(gru3);
        list.add(gru4);
        list.add(gru6);        
        list.add(gru5);
        
        //BREAKFAST & CEREAL
        //BEVERAGES
        //CANNED GOODS & SOUPS
        //FROZEN ITEMS
        //MEAT & SEAFOOD
        
        return list;
    }
*/
}