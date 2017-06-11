package com.example.bhumihar.mapproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] Menu = new String[] {"RouteTrace","LocationTrace","HomeTrace"};



        final ListView listView = (ListView)findViewById(R.id.listview);

        ArrayAdapter<String> list = new ArrayAdapter<String>(MainActivity.this ,android.R.layout.simple_list_item_1 ,Menu);
        listView.setAdapter(list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String clas = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(MainActivity.this, clas, Toast.LENGTH_SHORT).show();

                Class New_Class = null;
                try {
                    New_Class = Class.forName("com.example.bhumihar.mapproject."+clas);
                    Intent New_Activity = new Intent(MainActivity.this ,New_Class);
                    startActivity(New_Activity);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }



}
