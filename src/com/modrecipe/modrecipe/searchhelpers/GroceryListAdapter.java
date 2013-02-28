package com.modrecipe.modrecipe.searchhelpers;

import com.modrecipe.modrecipe.objects.Ingredient;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GroceryListAdapter extends ArrayAdapter<Ingredient>{

    Context context; 
    int layoutResourceId;    
    Ingredient data[] = null;
    
    public GroceryListAdapter(Context context, int layoutResourceId, Ingredient[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        IngredientHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new IngredientHolder();
            //holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(android.R.id.text1);
            
            row.setTag(holder);
        }
        else
        {
            holder = (IngredientHolder)row.getTag();
        }
        
        Ingredient ingredient= data[position];
        holder.txtTitle.setText(ingredient.Title);
        //holder.imgIcon.setImageResource(ingredient.icon);
        
        return row;
    }
    
    static class IngredientHolder
    {
        //ImageView imgIcon;
        TextView txtTitle;
    }
}