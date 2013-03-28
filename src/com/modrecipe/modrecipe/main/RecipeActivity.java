package com.modrecipe.modrecipe.main;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.modrecipe.modrecipe.Up.ActionBarCompat;
import com.modrecipe.modrecipe.objects.DataSingleton;
import com.modrecipe.modrecipe.objects.Ingredient;
import com.modrecipe.modrecipe.objects.Recipe;
import com.modrecipe.modrecipe.tabs.MealsSectionFragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TwoLineListItem;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.modrecipe.modrecipe.R;

public class RecipeActivity extends Activity {
    int mNum;
	Recipe r = new Recipe();


    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActionBarCompat.setDisplayHomeAsUpEnabled(this, true); // Back button up top?
        
        String allowpin = this.getIntent().getStringExtra("allowpin");
        
        // Default Recipe?
        String UUID = this.getIntent().getStringExtra("recipe_uuid");        
    	r = DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString(UUID));
        
        //TODO make less hacky // READ ONLY
        if (allowpin.equals("false")) {
            setContentView(R.layout.activity_recipe_nopin);
        } else {
        	setContentView(R.layout.activity_recipe_pin);
        	setBottomBarListeners();	
        }

        defaultRecipie();

        //System.out.println("position: " + position);
        
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }    
    
    public void setBottomBarListeners() {
    	// Listeners of bottom bar TODO fix up
    	final ImageView likeImgView = (ImageView) this.findViewById(R.id.heartBtn);
    	
    	if (!r.getHarted())
    		likeImgView.setTag("unchecked");
    	else {
    		likeImgView.setTag("checked");
    		likeImgView.setImageResource(R.drawable.icon_heart_red);
    	}
    		
    	likeImgView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (likeImgView.getTag().equals("unchecked")) {
					
					// change image to checked
					likeImgView.setImageResource(R.drawable.icon_heart_red);
					likeImgView.setTag("checked");
					r.setHarted(true);
					
					// add to hearted items
					DataSingleton.getInstance().getUser().getFavoriteRecipesList().add(r);
					if (DataSingleton.getInstance().getFromLikedMealsAdapter() != null) {
						DataSingleton.getInstance().getFromLikedMealsAdapter().notifyDataSetChanged();
					}
					
				} else {
					likeImgView.setImageResource(R.drawable.icon_heart);
					likeImgView.setTag("unchecked");
					r.setHarted(false);
					
					// remove from hearted items
					DataSingleton.getInstance().getUser().getFavoriteRecipesList().remove(r);
					if (DataSingleton.getInstance().getFromLikedMealsAdapter() != null) {
						DataSingleton.getInstance().getFromLikedMealsAdapter().notifyDataSetChanged();
					}
				}
			}
        	
        });
    	
    	final ImageView pinImgView = (ImageView) this.findViewById(R.id.pinBtn);
    	
    	if (!r.getPinned())
    		pinImgView.setTag("unchecked");
    	else {
    		pinImgView.setTag("checked");
    		pinImgView.setImageResource(R.drawable.icon_pin_red);
    	}
    	
    	pinImgView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (pinImgView.getTag().equals("unchecked")) {
					pinImgView.setImageResource(R.drawable.icon_pin_red);
					pinImgView.setTag("checked");
					r.setPinned(true);
					
					DataSingleton.getInstance().getUser().getPinnedRecipesList().add(r);
					if (DataSingleton.getInstance().getFromPinnedMealsAdapter() != null) {
						DataSingleton.getInstance().getFromPinnedMealsAdapter().notifyDataSetChanged();
					}
					
				} else {
					pinImgView.setImageResource(R.drawable.icon_pin);
					pinImgView.setTag("unchecked");
					r.setPinned(false);
					
					DataSingleton.getInstance().getUser().getPinnedRecipesList().remove(r);
					if (DataSingleton.getInstance().getFromPinnedMealsAdapter() != null) {
						DataSingleton.getInstance().getFromPinnedMealsAdapter().notifyDataSetChanged();
					}
				}
			}
    		
    	});
    	
    	final ImageView mealImgView = (ImageView) this.findViewById(R.id.mealBtn);
    	
    	if (!r.getPlanned())
    		mealImgView.setTag("unchecked");
    	else {
    		mealImgView.setTag("checked");
    		mealImgView.setImageResource(R.drawable.icon_meal_red);
    	}
    	
    	mealImgView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (mealImgView.getTag().equals("unchecked")) {
					mealImgView.setImageResource(R.drawable.icon_meal_red);
					mealImgView.setTag("checked");
					r.setPlanned(true);
					
					//DataSingleton.getInstance().getUser().getMealRecipesList().add(r);
					DataSingleton.getInstance().getUser().addToMeals(r.getUUID());
					DataSingleton.getInstance().getMealExpAdapter().notifyDataSetChanged();
					
				} else {
					mealImgView.setImageResource(R.drawable.icon_meal);
					mealImgView.setTag("unchecked");
					r.setPlanned(false);

					//DataSingleton.getInstance().getUser().getMealRecipesList().remove(r);
					DataSingleton.getInstance().getUser().removeFromMeals(r.getUUID());
					DataSingleton.getInstance().getMealExpAdapter().notifyDataSetChanged();
				}
			}
    		
    	});
    	
    	final ImageView modImgView = (ImageView) this.findViewById(R.id.modBtn);
    	modImgView.setTag("unchecked");
    	modImgView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (modImgView.getTag().equals("unchecked")) {
					modImgView.setImageResource(R.drawable.icon_edit);
					modImgView.setTag("checked");
					
					//TODO edit recipes...
					
				} else {
					modImgView.setImageResource(R.drawable.icon_edit_red);
					modImgView.setTag("unchecked");
				}
			}
    		
    	});

    	
    	
    }

    ImageView recipeimg;
    TextView recipiename;
	TextView ingredients;
	TextView directions;
	TextView nutrition;
	TextView servings;
	TextView reviews;
	
    public void defaultRecipie() {
    	
    	//recipiename = (TextView) findViewById(R.id.textView1);
    	recipeimg = (ImageView) findViewById(R.id.recipeImg);
        servings = (TextView) findViewById(R.id.textView7);
        ingredients = (TextView) findViewById(R.id.textView8);        
        directions = (TextView) findViewById(R.id.textView9);
        nutrition = (TextView) findViewById(R.id.textView10);
        reviews = (TextView) findViewById(R.id.textView11);
        
    	recipeimg.setImageResource(r.getImageResource());
            	
    	servings.setText("\n" +
        		"Ready in 1 Hour and 10 minutes, Servings: 8 \n");
    	
    	String ingredientsString = "\n";
    	for (Ingredient ingre : r.getIngredientList()) {
    		ingredientsString += ingre.toString() + "\n";
    	}
    	ingredients.setText(ingredientsString);
        
/**        
        ingredients.setText("\n" +
        		"1 lb. Ground Beef \n" +
        		"1 Egg \n" +
        		"1/2 c. Chopped Onion \n" +
        		"1/4 c. Bread Crumbs \n" +
        		"1 t. Salt \n" +
        		"1 t. Pepper \n" +
        		"1 c. Rice \n" +
        		"1 c. Pineapple Juice \n" +
        		"1 T. Oil \n" +
        		"1 T. Soy Sauce \n" +
        		"1/2 c. Sugar \n" +
        		"3 T. Vinegar \n" +
        		"15 oz. can Pineapple Chunks \n" +
        		"8 oz. Mandarin Oranges \n");
*/        
        directions.setText("\n" +
        		"1. Combine rice with 1 1/2 c. water and cook for 20 minutes. \n\n" +
        		"2. While rice is cooking, combine ground beef, egg, onion, bread crumbs, " +
        			"and salt and pepper. Form into 1-in meatballs, and broil on a rimmed " +
        			"cookie sheet on low in the oven until cooked through. \n\n" +
        		"3. Bring pineapple juice and oil to a boil for one minute. Meanwhile, mix" +
        			"soy sauce, sugar, and vinegar together. Add to the boiling juice and " +
        			"simmer on medium until sauce thickens. \n\n" +
    			"4. Combine sauce, meatballs, and canned fruit. Serve hot over fresh rice." +
    				"Can be served or warmed in crockpot as well. \n");
        
        nutrition.setText("" +
        		"\n" +
        		"Calories, 2080" +
        		"\n");
        
        reviews.setText("" +
        		"\n" +
        		"Reviews, 34" +
        		"\n");    	
    }
	
}
