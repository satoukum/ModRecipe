package com.modrecipe.modrecipe;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
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

public class RecipeActivity extends Activity {
    int mNum;


    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        String allowpin = this.getIntent().getStringExtra("allowpin");

        //TODO make less hacky // READ ONLY
        if (allowpin.equals("false")) {
            setContentView(R.layout.activity_recipe_nopin);
        } else {
        	setContentView(R.layout.activity_recipe_pin);
        	
        	setBottomBarListeners();
        	
        	
        }
        
        //System.out.println("position: " + position);
        
        defaultRecipie();
        
    }
    
    public void setBottomBarListeners() {
    	// Listeners of bottom bar TODO fix up
    	final ImageView likeImgView = (ImageView) this.findViewById(R.id.heartBtn);
    	likeImgView.setTag("unchecked");
    	likeImgView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (likeImgView.getTag().equals("unchecked")) {
					likeImgView.setImageResource(R.drawable.icon_heart_checked_red);
					likeImgView.setTag("checked");
				} else {
					likeImgView.setImageResource(R.drawable.icon_heart_checked);
					likeImgView.setTag("unchecked");
				}
			}
        	
        });
    	
    	final ImageView pinImgView = (ImageView) this.findViewById(R.id.pinBtn);
    	pinImgView.setTag("unchecked");
    	pinImgView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (pinImgView.getTag().equals("unchecked")) {
					pinImgView.setImageResource(R.drawable.icon_pin_red);
					pinImgView.setTag("checked");
				} else {
					pinImgView.setImageResource(R.drawable.icon_pin);
					pinImgView.setTag("unchecked");
				}
			}
    		
    	});
    	
    	final ImageView mealImgView = (ImageView) this.findViewById(R.id.mealBtn);
    	mealImgView.setTag("unchecked");
    	mealImgView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (mealImgView.getTag().equals("unchecked")) {
					mealImgView.setImageResource(R.drawable.icon_meal_red);
					mealImgView.setTag("checked");
				} else {
					mealImgView.setImageResource(R.drawable.icon_meal);
					mealImgView.setTag("unchecked");
				}
			}
    		
    	});
    	
    	final ImageView modImgView = (ImageView) this.findViewById(R.id.modBtn);
    	modImgView.setTag("unchecked");
    	modImgView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (modImgView.getTag().equals("unchecked")) {
					modImgView.setImageResource(R.drawable.icon_recipemod_red);
					modImgView.setTag("checked");
				} else {
					modImgView.setImageResource(R.drawable.icon_recipemod);
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
    	
        // TODO fix up... recipie_name
        //recipiename.setText("" + getIntent().getExtras().get("recipie_name"));//"Sweet and Sour Meatballs");
        long imgResource = this.getIntent().getIntExtra("recipe_imgsrc", -1);
        recipeimg.setImageResource((int) imgResource);
        System.out.println("imgResource: " + imgResource);
        
        servings.setText("\n" +
        		"Ready in 1 Hour and 10 minutes, Servings: 8 \n");
        
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
