package com.modrecipe.modrecipe.tabs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.modrecipe.modrecipe.NewRecipeActivity;
import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.RecipeActivity;
import com.modrecipe.modrecipe.adapters.ImageAdapter;

/**
 * A dummy fragment representing a section of the app, but that simply
 * displays dummy text.
 */
public class SearchSectionFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	public SearchSectionFragment() {
		
	}
	
	static View rootView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_search, container, false);
        //TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
        //dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
		
		rootView.findViewById(R.id.mainLayout).requestFocus();
		
		final GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(rootView.getContext()));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				//Toast.makeText(SearchSectionFragment.getContext(), "" + position, Toast.LENGTH_SHORT).show();
				
				Intent childActivityIntent = new Intent(v.getContext(),
						RecipeActivity.class);
						
				childActivityIntent.putExtra("recipie_name", "Cappuccino-Chocolate Cupcakes");
				childActivityIntent.putExtra("recipe_imgsrc", (int) gridview.getAdapter().getItemId(position));
				childActivityIntent.putExtra("allowpin", "true");
				
				v.getContext().startActivity(childActivityIntent);
				
			}});
	    
	    //TODO fix up
	    final ImageView addImgView = (ImageView) rootView.findViewById(R.id.addBtn);
    	addImgView.setTag("unchecked");
    	addImgView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent childActivityIntent = new Intent(v.getContext(),
						NewRecipeActivity.class);
										
				v.getContext().startActivity(childActivityIntent);				
			}
    		
    	});
		
        return rootView;
        }

	protected static Context getContext() {
		return rootView.getContext();
	}
	
}