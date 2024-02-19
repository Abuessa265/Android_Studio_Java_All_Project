package com.example.mylistviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    ArrayAdapter<String>adapter;
    private SearchView searchView;

    String[] country_Names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);
        searchView=findViewById(R.id.searchViewId);

        country_Names = getResources().getStringArray(R.array.country_names);

        adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sample_view, R.id.textViewId, country_Names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });


    }


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value=adapter.getItem(position);
                Toast.makeText(MainActivity.this,value+" "+position,Toast.LENGTH_SHORT).show();
            }
        }

