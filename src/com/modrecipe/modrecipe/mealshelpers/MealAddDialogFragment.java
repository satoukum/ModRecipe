package com.modrecipe.modrecipe.mealshelpers;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.main.AddMealActivity;
import com.modrecipe.modrecipe.main.RecipeActivity;
import com.modrecipe.modrecipe.objects.Recipe;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MealAddDialogFragment extends DialogFragment {
	
	MealAddDialogFragment madf;
	
    /** The system calls this to get the DialogFragment's layout, regardless
    of whether it's being displayed as a dialog or an embedded fragment. */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		// Inflate the layout to use as dialog or embedded fragment
		
		madf = this;
		
		View v = inflater.inflate(R.layout.meal_dialog_add, container, false);
		
		Button fromLikedBtn = (Button) v.findViewById(R.id.addFromRecentlyLikedBtn);
		fromLikedBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// from Liked Btn
				Intent childActivityIntent = new Intent(v.getContext(),
						AddMealActivity.class);
				childActivityIntent.putExtra("context", 1); // from Liked
				v.getContext().startActivity(childActivityIntent);
			}
			
		});
		
		Button fromPinnedBtn = (Button) v.findViewById(R.id.addFromPinnedBtn);
		fromPinnedBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// from Pinned Btn
				Intent childActivityIntent = new Intent(v.getContext(),
						AddMealActivity.class);
				childActivityIntent.putExtra("context", 2); // From Pinned
				v.getContext().startActivity(childActivityIntent);
			}
			
		});
		
		Button fromPastMealsBtn = (Button) v.findViewById(R.id.addFromPastMealsBtn);
		fromPastMealsBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// from Past Meals Btn
				Intent childActivityIntent = new Intent(v.getContext(),
						AddMealActivity.class);
				childActivityIntent.putExtra("context", 3); // from Past Meals
				v.getContext().startActivity(childActivityIntent);
			}
			
		});
		
		Button fromSearchBtn = (Button) v.findViewById(R.id.addFromSearchBtn);
		fromSearchBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// from Past Meals Btn
				Intent childActivityIntent = new Intent(v.getContext(),
						AddMealActivity.class);
				childActivityIntent.putExtra("context", 4); // from Past Meals
				v.getContext().startActivity(childActivityIntent);
			}
			
		});
		
		Button cancelBtn = (Button) v.findViewById(R.id.cancelBtn);
		cancelBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// Cancel
				madf.dismiss();
			}
			
		});
		
		return v;
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
