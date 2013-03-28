package com.modrecipe.modrecipe.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.main.RecipeActivity;
import com.modrecipe.modrecipe.searchhelpers.ExpandableHeightGridView;
import com.modrecipe.modrecipe.searchhelpers.ImageAdapter;

/**
 * A dummy fragment representing a section of the app, but that simply
 * displays dummy text.
 */
public class SocialSectionFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	public SocialSectionFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_social, container, false);
        
		final ExpandableHeightGridView mAppsGrid = (ExpandableHeightGridView) rootView.findViewById(R.id.followingGridView);
		doStuff(mAppsGrid, rootView);
		mAppsGrid.setAdapter(new ImageAdapter(rootView.getContext()));

		mAppsGrid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				//Toast.makeText(SearchSectionFragment.getContext(), "" + position, Toast.LENGTH_SHORT).show();
				
				Intent childActivityIntent = new Intent(v.getContext(),
						RecipeActivity.class);
						
				childActivityIntent.putExtra("recipe_imgsrc", (int) mAppsGrid.getAdapter().getItemId(position));
				childActivityIntent.putExtra("allowpin", "true");
				
				v.getContext().startActivity(childActivityIntent);
		        
			}});

        return rootView;                
        }
	
	//TODO Gross, doesn't work...
	public void doStuff(ExpandableHeightGridView mAppsGrid, View rootView) {
		mAppsGrid.setExpanded(true);
		
		ScrollView mainScrollView = (ScrollView) rootView.findViewById(R.id.ScrollView01);
		mainScrollView.fullScroll(ScrollView.FOCUS_UP); //
		mainScrollView.smoothScrollTo(0,0);
		System.out.println("x: " + rootView.getScrollX() + " y: " + rootView.getScrollY());
		mainScrollView.setScrollX(0);
		mainScrollView.setScrollY(0);
	}
	
}