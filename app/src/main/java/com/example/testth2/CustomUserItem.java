//package com.example.testth2;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CustomUserItem extends BaseAdapter {
//    Context context;
//    int layout;
//    List<User> users;
//
//    public CustomUserItem(Context context, int layout, List<User> users) {
//        this.context = context;
//        this.layout = layout;
//        this.users = users;
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView= LayoutInflater.from(context).inflate(layout,parent,false);
//        TextView tvName=convertView.findViewById(R.id.tvNameitem);
//        TextView tvTuoi=convertView.findViewById(R.id.tvTuoiitem);
//
//        tvName.setText(users.get(position).getName());
//        tvTuoi.setText(users.get(position).getTuoi());
//        return convertView;
//    }
//}
