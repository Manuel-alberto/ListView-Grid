package com.example.segunda_seccion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class List_Activity extends AppCompatActivity {

    ListView listView;
    List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);

        names=new ArrayList<String>();

        names.add("Alex");
        names.add("Enrique");
        names.add("Pedro");
        names.add("Mariana");
        names.add("Alex");
        names.add("Enrique");
        names.add("Pedro");
        names.add("Mariana");
        names.add("Alex");
        names.add("Enrique");
        names.add("Pedro");
        names.add("Mariana");
        names.add("Alex");
        names.add("Enrique");
        names.add("Pedro");
        names.add("Mariana");
        names.add("Alex");
        names.add("Enrique");
        names.add("Pedro");
        names.add("Mariana");

        //ArrayAdapter <String> adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        //listView.setAdapter(adapter);


        myAdapter myAdapter=new myAdapter(this, R.layout.list_item, names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(List_Activity.this, "Has clickeado "+names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

