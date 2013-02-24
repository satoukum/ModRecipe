package com.modrecipe.modrecipe.tabs;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.RecipeActivity;
import com.modrecipe.modrecipe.mealsExpandableList.ExpandableListAdapter;
import com.modrecipe.modrecipe.mealsExpandableList.ExpandableListChild;
import com.modrecipe.modrecipe.mealsExpandableList.ExpandableListGroup;

/**
 * A dummy fragment representing a section of the app, but that simply
 * displays dummy text.
 */
public class MealsSectionFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	public MealsSectionFragment() {
		
	}
	
	static View rootView;
	
	private ExpandableListAdapter ExpAdapter;
	private static ArrayList<ExpandableListGroup> ExpListItems = new ArrayList<ExpandableListGroup>();
	private ExpandableListView ExpandList;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_meals, container, false);
/**		
    	// Meal Plan
    	final ListView lv = (ListView) rootView.findViewById(R.id.mealView);
    	
        final List<String> sl1 = new ArrayList<String>();
        sl1.add("Chicken Pot Pie Bites");        
        sl1.add("Quick Lasagna");
        sl1.add("Sweet and Sour Meatballs");
        sl1.add("Chicken Parmigiana");        
        sl1.add("Chicken Divan");
        sl1.add("General Tso's");
*/        
		ExpandList = (ExpandableListView) rootView.findViewById(R.id.ExpList2);
		ExpListItems = SetStandardGroups();
		ExpAdapter = new ExpandableListAdapter(this.getActivity(), ExpListItems); //??
		ExpandList.setAdapter(ExpAdapter);
/**		
		//TODO make less tacky
		int count = ExpAdapter.getGroupCount();
		for (int position = 1; position <= count; position++) {
				ExpandList.expandGroup(position - 1);
		}
*/        
/**                
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.meal_item, sl1);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Intent childActivityIntent = new Intent(v.getContext(),
						RecipeActivity.class);
				childActivityIntent.putExtra("allowpin", "false");
				childActivityIntent.putExtra("recipe_imgsrc", R.drawable.recipe2); //TODO fix
				v.getContext().startActivity(childActivityIntent);
				//getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //TODO think about transitions
			}
        	
        });
*/		
        return rootView;
        }
	
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
        
        ExpandableListGroup gru2 = new ExpandableListGroup();
        gru2.setName("World's Best Lasagna");
        ExpandableListChild ch2_1 = new ExpandableListChild();
        ch2_1.setName("1 lb sweet Italian sausage"); ch2_1.setTag(null); list2.add(ch2_1);
        ExpandableListChild ch2_2 = new ExpandableListChild();
        ch2_2.setName("3/4 lb lean ground beef"); ch2_2.setTag(null); list2.add(ch2_2);
        ExpandableListChild ch2_3 = new ExpandableListChild();
        ch2_3.setName("1/2 cup minced onion"); ch2_3.setTag(null); list2.add(ch2_3);
        ExpandableListChild ch2_4 = new ExpandableListChild();
        ch2_4.setName("2 cloves garlic, crushed"); ch2_4.setTag(null); list2.add(ch2_4);
        ExpandableListChild ch2_5 = new ExpandableListChild();
        ch2_5.setName("1 28-oz can crushed tomatoes"); ch2_5.setTag(null); list2.add(ch2_5);
        ExpandableListChild ch2_6 = new ExpandableListChild();
        ch2_6.setName("2 6-oz cans tomato paste"); ch2_6.setTag(null); list2.add(ch2_6);
        ExpandableListChild ch2_7 = new ExpandableListChild();
        ch2_7.setName("2 6.5-oz cans canned tomato sauce"); ch2_7.setTag(null); list2.add(ch2_7);
        ExpandableListChild ch2_8 = new ExpandableListChild();
        ch2_8.setName("1/2 cup water"); ch2_8.setTag(null); list2.add(ch2_8);
        ExpandableListChild ch2_9 = new ExpandableListChild();
        ch2_9.setName("2 Tbs white sugar"); ch2_9.setTag(null); list2.add(ch2_9);
        ExpandableListChild ch2_10 = new ExpandableListChild();
        ch2_10.setName("1 1/2 tsp dried basil leaves"); ch2_10.setTag(null); list2.add(ch2_10);
        ExpandableListChild ch2_11 = new ExpandableListChild();
        ch2_11.setName("1/2 tsp fennel seeds"); ch2_11.setTag(null); list2.add(ch2_11);
        ExpandableListChild ch2_12 = new ExpandableListChild();
        ch2_12.setName("1 tsp. Italian seasoning"); ch2_12.setTag(null); list2.add(ch2_12);
        ExpandableListChild ch2_13 = new ExpandableListChild();
        ch2_13.setName("1 Tbs salt"); ch2_13.setTag(null); list2.add(ch2_13);
        ExpandableListChild ch2_14 = new ExpandableListChild();
        ch2_14.setName("1/4 tsp ground black pepper"); ch2_14.setTag(null); list2.add(ch2_14);
        ExpandableListChild ch2_15 = new ExpandableListChild();
        ch2_15.setName("4 Tbs chopped fresh parsley"); ch2_15.setTag(null); list2.add(ch2_15);
        ExpandableListChild ch2_16 = new ExpandableListChild();
        ch2_16.setName("12 lasagna noodles"); ch2_16.setTag(null); list2.add(ch2_16);
        ExpandableListChild ch2_17 = new ExpandableListChild();
        ch2_17.setName("16 oz ricotta cheese"); ch2_17.setTag(null); list2.add(ch2_17);
        ExpandableListChild ch2_18 = new ExpandableListChild();
        ch2_18.setName("1 egg"); ch2_18.setTag(null); list2.add(ch2_18);
        ExpandableListChild ch2_19 = new ExpandableListChild();
        ch2_19.setName("1/2 tsp salt"); ch2_19.setTag(null); list2.add(ch2_19);
        ExpandableListChild ch2_20 = new ExpandableListChild();
        ch2_20.setName("3/4 lb mozzarella cheese, sliced"); ch2_20.setTag(null); list2.add(ch2_20);
        ExpandableListChild ch2_21 = new ExpandableListChild();
        ch2_21.setName("3/4 c. grated Parmesan cheese"); ch2_21.setTag(null); list2.add(ch2_21);
        gru2.setItems(list2);
        list2 = new ArrayList<ExpandableListChild>();        
        
        ExpandableListGroup gru3 = new ExpandableListGroup();
        gru3.setName("Sweet and Sour Chicken");
        ExpandableListChild ch3_1 = new ExpandableListChild();
        ch3_1.setName("1/2 Green Bell Pepper"); ch3_1.setTag(null); list2.add(ch3_1);
        ExpandableListChild ch3_2 = new ExpandableListChild();
        ch3_2.setName("1/2 Red Bell Pepper"); ch3_2.setTag(null); list2.add(ch3_2);
        ExpandableListChild ch3_3 = new ExpandableListChild();
        ch3_3.setName("1 10 oz can Pineapple Tidbits"); ch3_3.setTag(null); list2.add(ch3_3);
        ExpandableListChild ch3_4 = new ExpandableListChild();
        ch3_4.setName("1/2 c. Yellow Onion"); ch3_4.setTag(null); list2.add(ch3_4);
        ExpandableListChild ch3_5 = new ExpandableListChild();
        ch3_5.setName("1 10 oz bottle Italian dressing"); ch3_5.setTag(null); list2.add(ch3_5);
        ExpandableListChild ch3_6 = new ExpandableListChild();
        ch3_6.setName("1 10 oz jar Approcot jam"); ch3_6.setTag(null); list2.add(ch3_6);
        ExpandableListChild ch3_7 = new ExpandableListChild();
        ch3_7.setName("2 breasts of chicken"); ch3_7.setTag(null); list2.add(ch3_7);
        gru3.setItems(list2);
        list2 = new ArrayList<ExpandableListChild>();

        ExpandableListGroup gru4 = new ExpandableListGroup();
        gru4.setName("Chicken Parmigiana");
        ExpandableListChild ch4_1 = new ExpandableListChild();
        ch4_1.setName("3 Breasts Chicken");
        ch4_1.setTag(null);
        list2.add(ch4_1);
        ExpandableListChild ch4_2 = new ExpandableListChild();
        ch4_2.setName("1 lb Hamburger Meat");
        ch4_2.setTag(null);
        list2.add(ch4_2);
        gru4.setItems(list2);
        list2 = new ArrayList<ExpandableListChild>();    
        
        ExpandableListGroup gru5 = new ExpandableListGroup();
        gru5.setName("General Tso's Chicken");
        ExpandableListChild ch5_1 = new ExpandableListChild();
        ch5_1.setName("2 16 oz bags frozen Mixed Vegetables");
        ch5_1.setTag(null);
        list2.add(ch5_1);
        ExpandableListChild ch5_2 = new ExpandableListChild();
        ch5_2.setName("1 16 oz bags frozen Broccoli Vegetables");
        ch5_2.setTag(null);
        list2.add(ch5_2);
        gru5.setItems(list2);
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
	
}