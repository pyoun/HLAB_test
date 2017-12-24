package com.example.peter.prac;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Peter on 12/24/2017.
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    private final Person[] values;
    private final int [] images;

    public ListAdapter(Context context, Person[] values, int[] images) {
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }
    @Override
    public Object getItem(int i) {
        return i;
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.display_cm_row, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.display_name);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.display_pic);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        String personInfo = values[position].firstName + " " + values[position].lastName + "\n"
                + values[position].age + ", " + values[position].school;
        viewHolder.txtName.setText(personInfo);
        viewHolder.icon.setImageResource(images[position]);

        return convertView;
    }

    public static class ViewHolder {
        TextView txtName;
        ImageView icon;

    }
}
