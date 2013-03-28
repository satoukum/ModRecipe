package com.modrecipe.modrecipe.main;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.Up.ActionBarCompat;
import com.modrecipe.modrecipe.mealshelpers.JunkAdapter;
import com.modrecipe.modrecipe.objects.DataSingleton;
import com.modrecipe.modrecipe.objects.Recipe;

public class AddMealActivity extends Activity {
    int mNum;
	Recipe r = new Recipe();


    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActionBarCompat.setDisplayHomeAsUpEnabled(this, true); // Back button up top?
        
        setContentView(R.layout.meal_dialog_add_from);
        
        // Default Recipe?
        int context = this.getIntent().getIntExtra("context", -1);

        System.out.println("context: " + context);
        ListView lv = (ListView) findViewById(R.id.fromListView);
        TextView tv = (TextView) findViewById(R.id.title);
        EditText et = (EditText) findViewById(R.id.searchEditText);
        
        if (context==1) { //("recentlyliked")) {
        	//TODO call differently
        	et.setVisibility(View.GONE);
        	final ArrayList<Recipe> list = DataSingleton.getInstance().getUser().getFavoriteRecipesList();
        	tv.setText("Add Meal from Liked Meals");
        	ArrayAdapter<com.modrecipe.modrecipe.objects.Recipe> a = new JunkAdapter<com.modrecipe.modrecipe.objects.Recipe>(this, R.layout.meal_dialog_from_list, R.id.textView1, list);
        	DataSingleton.getInstance().setFromLikedMealsAdapter(a);
        	buildStuff(lv, list, a);
        
        } else if (context==2) { //("pinned")) {
        	et.setVisibility(View.GONE);
        	final ArrayList<Recipe> list = DataSingleton.getInstance().getUser().getPinnedRecipesList();
        	tv.setText("Add Meal from Pinned Meals");
        	ArrayAdapter<com.modrecipe.modrecipe.objects.Recipe> a = new JunkAdapter<com.modrecipe.modrecipe.objects.Recipe>(this, R.layout.meal_dialog_from_list, R.id.textView1, list);   		
        	DataSingleton.getInstance().setFromPinnedMealsAdapter(a);
        	buildStuff(lv, list, a);
        	
        } else if (context==3) { //("past")) {
        	et.setVisibility(View.GONE);
        	final ArrayList<Recipe> list = DataSingleton.getInstance().getUser().getPastRecipesList();
        	tv.setText("Add Meal from Past Meals");
        	ArrayAdapter<com.modrecipe.modrecipe.objects.Recipe> a = new JunkAdapter<com.modrecipe.modrecipe.objects.Recipe>(this, R.layout.meal_dialog_from_list, R.id.textView1, list);   		
        	buildStuff(lv, list, a);
        	
        } else if (context==4) { //("search")) {
        	et.setHint("Search Recipes...");
        	//final ArrayList<Recipe> list = DataSingleton.getInstance().getUser().getPastRecipesList();
        	tv.setText("Add Meal from Search");
        	//ArrayAdapter<com.modrecipe.modrecipe.objects.Recipe> a = new JunkAdapter<com.modrecipe.modrecipe.objects.Recipe>(this, R.layout.meal_dialog_from_list, R.id.textView1, list);   		
        	//buildStuff(lv, list, a);
        }
        
        

                
    }
    
    public void buildStuff(ListView lv, final ArrayList<Recipe> list, ArrayAdapter<com.modrecipe.modrecipe.objects.Recipe> a) {
	    lv.setAdapter(a);

	    lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View v,
						int arg2, long arg3) {
					Intent childActivityIntent = new Intent(v.getContext(), RecipeActivity.class);
					childActivityIntent.putExtra("recipe_uuid", ((Recipe)list.get(arg2)).getUUID().toString());
					childActivityIntent.putExtra("allowpin", "true");
					v.getContext().startActivity(childActivityIntent);
				}
	    });
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
