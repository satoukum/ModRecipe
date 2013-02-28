package com.modrecipe.modrecipe.main;


import java.util.ArrayList;
import java.util.List;
import com.modrecipe.modrecipe.Up.ActionBarCompat;
import com.modrecipe.modrecipe.mealshelpers.MealExpandableListAdapter;
import com.modrecipe.modrecipe.objects.*;

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
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TwoLineListItem;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.modrecipe.modrecipe.R;

public class PastMealsActivity extends Activity {
    int mNum;
    
	private MealExpandableListAdapter ExpAdapter;
	private ArrayList<Ingredient> ExpListItems = new ArrayList<Ingredient>();
	private ExpandableListView ExpandList;    
	
	private MealExpandableListAdapter ExpAdapter2;
	private ArrayList<Ingredient> ExpListItems2 = new ArrayList<Ingredient>();
	private ExpandableListView ExpandList2;   

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActionBarCompat.setDisplayHomeAsUpEnabled(this, true); // Back button up top?
        
        //String allowpin = this.getIntent().getStringExtra("allowpin");

        setContentView(R.layout.activity_pastmeals);
        /**
		ExpandList = (ExpandableListView) findViewById(R.id.ExpList3);
		ExpListItems = SetStandardGroups();
		ExpAdapter = new ExpandableListAdapter(this, ExpListItems); //??
		ExpandList.setAdapter(ExpAdapter);
		
		ExpandList2 = (ExpandableListView) findViewById(R.id.ExpList4);
		ExpListItems2 = SetStandardGroups2();
		ExpAdapter2 = new ExpandableListAdapter(this, ExpListItems2); //??
		ExpandList2.setAdapter(ExpAdapter2);
		*/
        
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }    
/**        
    public ArrayList<Ingredient> SetStandardGroups() {
    	ArrayList<Ingredient> list = new ArrayList<Ingredient>();
    	ArrayList<Recipe> list2 = new ArrayList<Recipe>();
    	
        Ingredient gru1 = new Ingredient();
        gru1.setName("Chicken Pot Pie Bites");
        Recipe ch1_1 = new Recipe();
        ch1_1.setName("All-purpose flour, as needed"); ch1_1.setTag(null); list2.add(ch1_1);
        Recipe ch1_2 = new Recipe();
        ch1_2.setName("2 14-16 oz packages all-butter puff pastry, thawed"); ch1_2.setTag(null); list2.add(ch1_2);
        Recipe ch1_3 = new Recipe();
        ch1_3.setName("1 egg"); ch1_3.setTag(null); list2.add(ch1_3);
        Recipe ch1_4 = new Recipe();
        ch1_4.setName("1 Tbs water"); ch1_4.setTag(null); list2.add(ch1_4); 
        Recipe ch1_5 = new Recipe();
        ch1_5.setName("1 lb chicken"); ch1_5.setTag(null); list2.add(ch1_5); 
        Recipe ch1_6 = new Recipe();
        ch1_6.setName("2 tsp olive oil"); ch1_6.setTag(null); list2.add(ch1_6); 
        Recipe ch1_7 = new Recipe();
        ch1_7.setName("Kosher salt, to taste"); ch1_7.setTag(null); list2.add(ch1_7); 
        Recipe ch1_8 = new Recipe();
        ch1_8.setName("Black pepper, to taste"); ch1_8.setTag(null); list2.add(ch1_8); 
        Recipe ch1_9 = new Recipe();
        ch1_9.setName("3 Tbs butter, unsalted"); ch1_9.setTag(null); list2.add(ch1_9); 
        Recipe ch1_10 = new Recipe();
        ch1_10.setName("1/3 c. shallot, finely chopped "); ch1_10.setTag(null); list2.add(ch1_10);         
        Recipe ch1_11 = new Recipe();
        ch1_11.setName("1/4 c. carrot, finely chopped "); ch1_11.setTag(null); list2.add(ch1_11);         
        Recipe ch1_12 = new Recipe();
        ch1_12.setName("3/4 c. heavy cream"); ch1_12.setTag(null); list2.add(ch1_12);         
        Recipe ch1_13 = new Recipe();
        ch1_13.setName("1/2 c. chicken stock"); ch1_13.setTag(null); list2.add(ch1_13);         
        Recipe ch1_14 = new Recipe();
        ch1_14.setName("1/4 tsp. ground sage"); ch1_14.setTag(null); list2.add(ch1_14);         
        gru1.setItems(list2);        
        list2 = new ArrayList<Recipe>();
        
        Ingredient gru2 = new Ingredient();
        gru2.setName("World's Best Lasagna");
        Recipe ch2_1 = new Recipe();
        ch2_1.setName("1 lb sweet Italian sausage"); ch2_1.setTag(null); list2.add(ch2_1);
        Recipe ch2_2 = new Recipe();
        ch2_2.setName("3/4 lb lean ground beef"); ch2_2.setTag(null); list2.add(ch2_2);
        Recipe ch2_3 = new Recipe();
        ch2_3.setName("1/2 cup minced onion"); ch2_3.setTag(null); list2.add(ch2_3);
        Recipe ch2_4 = new Recipe();
        ch2_4.setName("2 cloves garlic, crushed"); ch2_4.setTag(null); list2.add(ch2_4);
        Recipe ch2_5 = new Recipe();
        ch2_5.setName("1 28-oz can crushed tomatoes"); ch2_5.setTag(null); list2.add(ch2_5);
        Recipe ch2_6 = new Recipe();
        ch2_6.setName("2 6-oz cans tomato paste"); ch2_6.setTag(null); list2.add(ch2_6);
        Recipe ch2_7 = new Recipe();
        ch2_7.setName("2 6.5-oz cans canned tomato sauce"); ch2_7.setTag(null); list2.add(ch2_7);
        Recipe ch2_8 = new Recipe();
        ch2_8.setName("1/2 cup water"); ch2_8.setTag(null); list2.add(ch2_8);
        Recipe ch2_9 = new Recipe();
        ch2_9.setName("2 Tbs white sugar"); ch2_9.setTag(null); list2.add(ch2_9);
        Recipe ch2_10 = new Recipe();
        ch2_10.setName("1 1/2 tsp dried basil leaves"); ch2_10.setTag(null); list2.add(ch2_10);
        Recipe ch2_11 = new Recipe();
        ch2_11.setName("1/2 tsp fennel seeds"); ch2_11.setTag(null); list2.add(ch2_11);
        Recipe ch2_12 = new Recipe();
        ch2_12.setName("1 tsp. Italian seasoning"); ch2_12.setTag(null); list2.add(ch2_12);
        Recipe ch2_13 = new Recipe();
        ch2_13.setName("1 Tbs salt"); ch2_13.setTag(null); list2.add(ch2_13);
        Recipe ch2_14 = new Recipe();
        ch2_14.setName("1/4 tsp ground black pepper"); ch2_14.setTag(null); list2.add(ch2_14);
        Recipe ch2_15 = new Recipe();
        ch2_15.setName("4 Tbs chopped fresh parsley"); ch2_15.setTag(null); list2.add(ch2_15);
        Recipe ch2_16 = new Recipe();
        ch2_16.setName("12 lasagna noodles"); ch2_16.setTag(null); list2.add(ch2_16);
        Recipe ch2_17 = new Recipe();
        ch2_17.setName("16 oz ricotta cheese"); ch2_17.setTag(null); list2.add(ch2_17);
        Recipe ch2_18 = new Recipe();
        ch2_18.setName("1 egg"); ch2_18.setTag(null); list2.add(ch2_18);
        Recipe ch2_19 = new Recipe();
        ch2_19.setName("1/2 tsp salt"); ch2_19.setTag(null); list2.add(ch2_19);
        Recipe ch2_20 = new Recipe();
        ch2_20.setName("3/4 lb mozzarella cheese, sliced"); ch2_20.setTag(null); list2.add(ch2_20);
        Recipe ch2_21 = new Recipe();
        ch2_21.setName("3/4 c. grated Parmesan cheese"); ch2_21.setTag(null); list2.add(ch2_21);
        gru2.setItems(list2);
        list2 = new ArrayList<Recipe>();        
        
        Ingredient gru3 = new Ingredient();
        gru3.setName("Sweet and Sour Chicken");
        Recipe ch3_1 = new Recipe();
        ch3_1.setName("1/2 Green Bell Pepper"); ch3_1.setTag(null); list2.add(ch3_1);
        Recipe ch3_2 = new Recipe();
        ch3_2.setName("1/2 Red Bell Pepper"); ch3_2.setTag(null); list2.add(ch3_2);
        Recipe ch3_3 = new Recipe();
        ch3_3.setName("1 10 oz can Pineapple Tidbits"); ch3_3.setTag(null); list2.add(ch3_3);
        Recipe ch3_4 = new Recipe();
        ch3_4.setName("1/2 c. Yellow Onion"); ch3_4.setTag(null); list2.add(ch3_4);
        Recipe ch3_5 = new Recipe();
        ch3_5.setName("1 10 oz bottle Italian dressing"); ch3_5.setTag(null); list2.add(ch3_5);
        Recipe ch3_6 = new Recipe();
        ch3_6.setName("1 10 oz jar Approcot jam"); ch3_6.setTag(null); list2.add(ch3_6);
        Recipe ch3_7 = new Recipe();
        ch3_7.setName("2 breasts of chicken"); ch3_7.setTag(null); list2.add(ch3_7);
        gru3.setItems(list2);
        list2 = new ArrayList<Recipe>();

        Ingredient gru4 = new Ingredient();
        gru4.setName("Chicken Parmigiana");
        Recipe ch4_1 = new Recipe();
        ch4_1.setName("3 Breasts Chicken");
        ch4_1.setTag(null);
        list2.add(ch4_1);
        Recipe ch4_2 = new Recipe();
        ch4_2.setName("1 lb Hamburger Meat");
        ch4_2.setTag(null);
        list2.add(ch4_2);
        gru4.setItems(list2);
        list2 = new ArrayList<Recipe>();     
        
        list.add(gru1);
        list.add(gru2);
        list.add(gru3);
        list.add(gru4);

        //BREAKFAST & CEREAL
        //BEVERAGES
        //CANNED GOODS & SOUPS
        //FROZEN ITEMS
        //MEAT & SEAFOOD
        
        return list;
    }	
    
    public ArrayList<Ingredient> SetStandardGroups2() {
    	ArrayList<Ingredient> list = new ArrayList<Ingredient>();
    	ArrayList<Recipe> list2 = new ArrayList<Recipe>();
    	
    	Ingredient gru5 = new Ingredient();
        gru5.setName("General Tso's Chicken");
        Recipe ch5_1 = new Recipe();
        ch5_1.setName("2 16 oz bags frozen Mixed Vegetables");
        ch5_1.setTag(null);
        list2.add(ch5_1);
        Recipe ch5_2 = new Recipe();
        ch5_2.setName("1 16 oz bags frozen Broccoli Vegetables");
        ch5_2.setTag(null);
        list2.add(ch5_2);
        gru5.setItems(list2);
        list2 = new ArrayList<Recipe>();
        
        Ingredient gru6 = new Ingredient();
        gru6.setName("BBQ Chicken Pizza");
        Recipe ch6_1 = new Recipe();
        ch6_1.setName("2 10 3/4 oz can Campbell's Cream of Chicken Soup");
        ch6_1.setTag(null);
        list2.add(ch6_1);
        Recipe ch6_2 = new Recipe();
        ch6_2.setName("1 10 3/4 oz can Campbell's Cream of Mushroom Soup");
        ch6_2.setTag(null);
        list2.add(ch6_2);
        gru6.setItems(list2);
        list2 = new ArrayList<Recipe>();    

        Ingredient gru7 = new Ingredient();
        gru7.setName("Chicken Alfredo");
        Recipe ch7_1 = new Recipe();
        ch7_1.setName("2 16 oz bags frozen Mixed Vegetables"); ch7_1.setTag(null); list2.add(ch7_1);
        gru7.setItems(list2);
        list2 = new ArrayList<Recipe>();
        
        Ingredient gru8 = new Ingredient();
        gru8.setName("Sweet and Sour Meatballs");
        Recipe ch8_1 = new Recipe();
        ch8_1.setName("2 10 3/4 oz can Campbell's Cream of Chicken Soup");
        ch8_1.setTag(null);
        list2.add(ch8_1);
        Recipe ch8_2 = new Recipe();
        ch8_2.setName("1 10 3/4 oz can Campbell's Cream of Mushroom Soup");
        ch8_2.setTag(null);
        list2.add(ch8_2);
        gru8.setItems(list2);
        list2 = new ArrayList<Recipe>(); 
        
        list.add(gru5);        
        list.add(gru6);
        list.add(gru7);        
        list.add(gru8);
        
        return list;
    }
 */   
}
