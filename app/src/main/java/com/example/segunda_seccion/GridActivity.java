package com.example.segunda_seccion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    GridView gridView;
    List<String> names;
    private myAdapter myAdapter;

    private int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView=findViewById(R.id.gridview);

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

        myAdapter =new myAdapter(this, R.layout.grid_item, names);
        gridView.setAdapter(myAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Has clickeado "+names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(gridView);

    }
    //inflamos el layout del menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }
    //Manejamos eventos click en el menu de opciones
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                //Añadimos nuevo nombre
                this.names.add("Added n "+(++counter));
                //se refresca el adaptador con los nuevo sdatos
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //inlfamos el layout del context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getMenuInflater();
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.setHeaderTitle(names.get(info.position));
        inflater.inflate(R.menu.context_menu,menu);

    }
    //manejamos eventos click en el context menu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete_item:
                //borramos item clickeado
                this.names.remove(info.position);
                //se refresca el adaptador con los nuevo sdatos
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}