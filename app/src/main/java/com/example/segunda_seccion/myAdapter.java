package com.example.segunda_seccion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class myAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public myAdapter(Context context, int layout, List<String> names){
        this.context=context;
        this.layout=layout;
        this.names=names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        this.names.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflater=LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder=new ViewHolder();

            holder.nameTextView=(TextView) convertView.findViewById(R.id.tvnames);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String currentName = names.get(position);

        holder.nameTextView.setText(currentName);

        return convertView;
    }
    static class ViewHolder{
        private TextView nameTextView;
    }
}
