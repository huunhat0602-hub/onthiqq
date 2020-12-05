package com.example.testth2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
    DataRoomUser dataRoomUser;
        //CustomUserItem customUserItem;
    UserCustom userCustom;
    List<User> users=new ArrayList<>();
    List listName=new ArrayList();
    ListView lvList;
    EditText tvName,tvTuoi;
    Button btnThem,btnXoa;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataRoomUser=DataRoomUser.getInstance(this);
        users=dataRoomUser.dao().getAll();
       //customUserItem=new CustomUserItem(this,R.layout.listitem,users);
       userCustom=new UserCustom(this,R.layout.listitem,users);
//        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listName);
        lvList=findViewById(R.id.lvList);
        lvList.setAdapter(userCustom);
        tvName=findViewById(R.id.txtName);
        tvTuoi=findViewById(R.id.txtTuoi);
        btnThem=findViewById(R.id.btnAdd);
        btnXoa=findViewById(R.id.btnRemove);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User(tvName.getText().toString(),Integer.parseInt(tvTuoi.getText().toString()));
                dataRoomUser.dao().insertUser(user);
                users.clear();
                users.addAll(dataRoomUser.dao().getAll());
                userCustom.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index != 0){
                    dataRoomUser.dao().deleteById(users.get(index));
                    tvName.setText("");
                    tvTuoi.setText("");
                    index=0;
                    users.clear();
                    users.addAll(dataRoomUser.dao().getAll());
                    userCustom.notifyDataSetChanged();
                }else {
                    Toast.makeText(MainActivity.this,"mời chọn user",Toast.LENGTH_LONG).show();
                }
            }
        });

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index=position;

                tvName.setText(users.get(index).getName());
                tvTuoi.setText(String.valueOf(users.get(index).getTuoi()));

            }
        });
    }

}