package io.lewiscodes.golfscorecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

    private final Context context;
    private final HoleTracker[] holes;

    public ListAdapter(Context context, HoleTracker[] holes) {
        this.context = context;
        this.holes = holes;
    }

    @Override
    public int getCount() {
        return holes.length;
    }

    @Override
    public Object getItem(int position) {
        return holes[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; // Not applicable
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.holeName = convertView.findViewById(R.id.holeName);
            viewHolder.strokeCount = convertView.findViewById(R.id.strokeCount);
            viewHolder.incrementStrokeBtn = convertView.findViewById(R.id.incrementStrokeBtn);
            viewHolder.decrementStrokeBtn = convertView.findViewById(R.id.decrementStrokeBtn);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.holeName.setText(holes[position].getHoleName());
        viewHolder.strokeCount.setText(String.valueOf(holes[position].getStrokes()));
        viewHolder.incrementStrokeBtn.setOnClickListener((v) -> {
            holes[position].incrementStrokes();
            viewHolder.strokeCount.setText(String.valueOf(holes[position].getStrokes()));
        });
        viewHolder.decrementStrokeBtn.setOnClickListener((v) -> {
            holes[position].decrementStrokes();
            viewHolder.strokeCount.setText(String.valueOf(holes[position].getStrokes()));
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView holeName;
        TextView strokeCount;
        Button incrementStrokeBtn;
        Button decrementStrokeBtn;
    }
}
