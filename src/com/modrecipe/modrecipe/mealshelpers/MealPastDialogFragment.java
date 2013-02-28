package com.modrecipe.modrecipe.mealshelpers;

import java.util.ArrayList;
import java.util.List;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.objects.Recipe;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MealPastDialogFragment extends DialogFragment {
	
	MealPastDialogFragment mpdf;
	
    /** The system calls this to get the DialogFragment's layout, regardless
    of whether it's being displayed as a dialog or an embedded fragment. */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		
		mpdf = this;
		
		// Inflate the layout to use as dialog or embedded fragment
		View v = inflater.inflate(R.layout.meal_dialog_past, container, false);
				
		ListView pastlv1 = (ListView) v.findViewById(R.id.pastListView1);
	        
	        Recipe[] rItems = { 
	            new Recipe("Chicken Pot Pie Bites"), 
	            new Recipe("Slow Cooker Lentil Sop with Turkey Bratwurst"), 
	            new Recipe("Creamy Braised Chicken with Pappardelle"), 
	            new Recipe("Cowboy Cookies"), 
	            new Recipe("Triple Decker Peanut Butter Brownies"), 
	        };
	        
	        ArrayAdapter<Recipe> adapter = new ArrayAdapter<Recipe>(this.getActivity(),
	                    android.R.layout.simple_list_item_1, rItems);
		
	        pastlv1.setAdapter(adapter);
	        		
		ListView pastlv2 = (ListView) v.findViewById(R.id.pastListView2);
	        
	        ArrayAdapter<Recipe> adapter2 = new ArrayAdapter<Recipe>(this.getActivity(),
	                    android.R.layout.simple_list_item_1, rItems);
		
	        pastlv2.setAdapter(adapter2);

	    Button cancelBtn = (Button) v.findViewById(R.id.cancelBtn);  
		cancelBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// Cancel
				mpdf.dismiss();
			}
			
		});
	        
		return v;
	}
	
	public List populate() {
		ArrayList<Recipe> rl = new ArrayList<Recipe>();
		
		Recipe r = new Recipe();
		r.setName("Some Recipe Name..."); // !!
		
		rl.add(r);
		
		return rl;
	}

	/** The system calls this only when creating the layout in a dialog. */
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// The only reason you might override this method when using onCreateView() is
		// to modify any dialog characteristics. For example, the dialog includes a
		// title by default, but your custom layout might not need it. So here you can
		// remove the dialog title, but you must call the superclass to get the Dialog.
		Dialog dialog = super.onCreateDialog(savedInstanceState);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		return dialog;
	}
}
