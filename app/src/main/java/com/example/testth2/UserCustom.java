package com.example.testth2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserCustom extends ArrayAdapter<User> {
    private Context context;
    private  int resource;
    private List<User> userList;

    public UserCustom(@NonNull Context context,
                      int resource,
                      @NonNull List<User> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.userList = objects;
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView, @NonNull ViewGroup parent) {

        UserViewHolder userViewHolder;
        if(convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
            userViewHolder=new UserViewHolder();
            userViewHolder.tvName=(TextView)convertView.findViewById(R.id.tvNameitem);
            userViewHolder.tvTuoi=(TextView)convertView.findViewById(R.id.tvTuoiitem);
            convertView.setTag(userViewHolder);
        }else
            userViewHolder=(UserViewHolder)convertView.getTag();

        User user=userList.get(position);
        userViewHolder.tvName.setText(user.getName());
        userViewHolder.tvTuoi.setText(String.valueOf(user.getTuoi()));

        return convertView;
    }
    public class UserViewHolder {
        private TextView tvName;
        private TextView tvTuoi;
    }
}
