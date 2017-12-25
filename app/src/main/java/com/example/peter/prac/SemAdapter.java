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

public class SemAdapter extends BaseAdapter {
    Context context;
    private final Seminar[] values;
    private final int [] images;

    public SemAdapter(Context context, Seminar[] values, int[] images) {
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
            convertView = inflater.inflate(R.layout.display_seminars_row, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.show_semname);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.show_sempic);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        String seminfo = values[position].seminarName + "\n"
                + values[position].cmName + ", " + values[position].ecName;
        viewHolder.txtName.setText(seminfo);
        //viewHolder.icon.setImageResource(images[position]);
        // currently set to "images[0]" because placeholder images
        viewHolder.icon.setImageResource(images[0]);

        return convertView;
    }

    public static class ViewHolder {
        TextView txtName;
        ImageView icon;

    }
}
