package com.modrecipe.modrecipe.tabs;

import com.modrecipe.modrecipe.R;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class ImageAdapter extends BaseAdapter {
	
	private Context mContext;
	
	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(270, 270)); // 270 px by 270 px image
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
    		R.drawable.recipe1, R.drawable.recipe2,
            R.drawable.recipe3, R.drawable.recipe4,
            R.drawable.recipe5, R.drawable.recipe6
    };
	
}
