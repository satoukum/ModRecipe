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
import android.widget.ListView;
import android.widget.TextView;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.RecipeActivity;

/**
 * A dummy fragment representing a section of the app, but that simply
 * displays dummy text.
 */
public class MealsSectionFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	public MealsSectionFragment() {
		
	}
	
	static View rootView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_meals, container, false);
		
    	// Meal Plan
    	ListView lv = (ListView) rootView.findViewById(R.id.mealView);
    	
        final List<String> sl1 = new ArrayList<String>();
        sl1.add("Cappuccino-Chocolate Cupcakes");
        sl1.add("Chicken Pot Pie");        
        sl1.add("Quick Lasagna");
        sl1.add("Sweet and Sour Meatballs");
        sl1.add("Chicken Parmigiana");        
        sl1.add("Chicken Divan");
        sl1.add("General Tso's");
                
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.meal_item, sl1);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Intent childActivityIntent = new Intent(v.getContext(),
						RecipeActivity.class);
				System.out.println("hello world");
				childActivityIntent.putExtra("allowpin", "false");
				v.getContext().startActivity(childActivityIntent);
			}
        	
        });
		
        return rootView;
        }
	
}