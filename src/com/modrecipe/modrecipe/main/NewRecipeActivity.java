package com.modrecipe.modrecipe.main;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.modrecipe.modrecipe.R;
import com.modrecipe.modrecipe.Up.ActionBarCompat;

public class NewRecipeActivity extends Activity {
    int mNum;


    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActionBarCompat.setDisplayHomeAsUpEnabled(this, true); // Back button up top?
        
        setContentView(R.layout.activity_newrecipe);
        	
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
