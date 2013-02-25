package com.modrecipe.modrecipe.tabs;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.adapters.GroceryListAdapter;
import com.modrecipe.modrecipe.listExpandableList.ExpandableListAdapter;
import com.modrecipe.modrecipe.listExpandableList.ExpandableListChild;
import com.modrecipe.modrecipe.listExpandableList.ExpandableListGroup;
import com.modrecipe.modrecipe.objects.Ingredient;

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
	
	private ExpandableListAdapter ExpAdapter;
	private static ArrayList<ExpandableListGroup> ExpListItems = new ArrayList<ExpandableListGroup>();
	private ExpandableListView ExpandList;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_list, container, false);
		
		//TODO find a better solution
		ExpandList = (ExpandableListView) rootView.findViewById(R.id.ExpList);
		ExpListItems = SetStandardGroups();
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
        return rootView;
        }
	
    public ArrayList<ExpandableListGroup> SetStandardGroups() {
    	ArrayList<ExpandableListGroup> list = new ArrayList<ExpandableListGroup>();
    	ArrayList<ExpandableListChild> list2 = new ArrayList<ExpandableListChild>();
    	
        ExpandableListGroup gru1 = new ExpandableListGroup();
        gru1.setName("FRUITS & VEGETABLES");
        ExpandableListChild ch1_1 = new ExpandableListChild();
        ch1_1.setName("1 White Onion");
        ch1_1.setTag(null);
        list2.add(ch1_1);
        ExpandableListChild ch1_2 = new ExpandableListChild();
        ch1_2.setName("1 Red Onion");
        ch1_2.setTag(null);
        list2.add(ch1_2);
        ExpandableListChild ch1_3 = new ExpandableListChild();
        ch1_3.setName("1 Green Bell Pepper");
        ch1_3.setTag(null);
        list2.add(ch1_3);
        gru1.setItems(list2);        
        list2 = new ArrayList<ExpandableListChild>();
        
        ExpandableListGroup gru2 = new ExpandableListGroup();
        gru2.setName("DAIRY, EGGS, & CHEESE");
        ExpandableListChild ch2_1 = new ExpandableListChild();
        ch2_1.setName("2 Eggs");
        ch2_1.setTag(null);
        list2.add(ch2_1);
        ExpandableListChild ch2_2 = new ExpandableListChild();
        ch2_2.setName("1 Block Cheddar Cheese");
        ch2_2.setTag(null);
        list2.add(ch2_2);
        ExpandableListChild ch2_3 = new ExpandableListChild();
        ch2_3.setName("1 Gallon Milk");
        ch2_3.setTag(null);
        list2.add(ch2_3);
        gru2.setItems(list2);
        list2 = new ArrayList<ExpandableListChild>();        
        
        ExpandableListGroup gru3 = new ExpandableListGroup();
        gru3.setName("SPICES & BAKING");
        ExpandableListChild ch3_1 = new ExpandableListChild();
        ch3_1.setName("1 tsp Salt");
        ch3_1.setTag(null);
        list2.add(ch3_1);
        ExpandableListChild ch3_2 = new ExpandableListChild();
        ch3_2.setName("1 tsp Pepper");
        ch3_2.setTag(null);
        list2.add(ch3_2);
        gru3.setItems(list2);
        list2 = new ArrayList<ExpandableListChild>();

        ExpandableListGroup gru4 = new ExpandableListGroup();
        gru4.setName("MEAT & SEAFOOD");
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
        
        ExpandableListGroup gru6 = new ExpandableListGroup();
        gru6.setName("CANNED GOODS & SOUPS");
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
        
        ExpandableListGroup gru5 = new ExpandableListGroup();
        gru5.setName("FROZEN ITEMS");
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
}