package com.modrecipe.modrecipe.mealshelpers;

import java.util.ArrayList;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.objects.DataSingleton;
import com.modrecipe.modrecipe.objects.Ingredient;
import com.modrecipe.modrecipe.objects.Recipe;
import com.modrecipe.modrecipe.objects.ShoppingCategory;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MealClearDialogFragment extends DialogFragment {
	
	MealClearDialogFragment mcdf;
	
    /** The system calls this to get the DialogFragment's layout, regardless
    of whether it's being displayed as a dialog or an embedded fragment. */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		// Inflate the layout to use as dialog or embedded fragment
		
		mcdf = this;
		
		View v = inflater.inflate(R.layout.meal_dialog_clear, container, false);
		
		Button clearAllBtn = (Button) v.findViewById(R.id.clearAllBtn);
		clearAllBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// Clear All
				ArrayList<ShoppingCategory> sl = DataSingleton.getInstance().getUser().getShoppingList();
				for (ShoppingCategory sc : sl) {
					ArrayList<Ingredient> il = sc.getIngredientList();
					il.clear();
				}
				DataSingleton.getInstance().getListExpAdapter().notifyDataSetChanged();
				
				ArrayList<Recipe> rl = DataSingleton.getInstance().getUser().getMealRecipesList();
				rl.clear();

				DataSingleton.getInstance().getMealExpAdapter().notifyDataSetChanged();
				
				mcdf.dismiss();
			}
			
		});
		
		Button clearSomeBtn = (Button) v.findViewById(R.id.clearSomeBtn);
		clearSomeBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// Clear Some
				ArrayList<Recipe> rl = DataSingleton.getInstance().getUser().getMealRecipesList();
				rl.clear();

				DataSingleton.getInstance().getMealExpAdapter().notifyDataSetChanged();

				mcdf.dismiss();
			}
			
		});
		
		Button cancelBtn = (Button) v.findViewById(R.id.cancelBtn);
		cancelBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// Cancel
				mcdf.dismiss();
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
