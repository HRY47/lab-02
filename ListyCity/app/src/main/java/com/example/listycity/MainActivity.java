package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    Integer selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>( this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        Button addButton = findViewById(R.id.button);
        Button deleteButton = findViewById(R.id.button2);
        EditText input = findViewById(R.id.input);

        Button checkBox = findViewById(R.id.checkBox2);

        input.setVisibility(View.GONE);
        checkBox.setVisibility(View.GONE);

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = dataList.get(position);
                selected = position;

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setVisibility(View.VISIBLE);
                checkBox.setVisibility(View.VISIBLE);
                //String newCity = input.getText().toString();
                //dataList.add(newCity);
                //cityAdapter.notifyDataSetChanged();
                //input.setText("");
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setVisibility(View.VISIBLE);
                //checkBox.setVisibility(View.VISIBLE);
                //String City = input.getText().toString();
                //dataList.remove(City);
                dataList.remove(dataList.get(selected));
                cityAdapter.notifyDataSetChanged();
                input.setText("");
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setVisibility(View.VISIBLE);
                checkBox.setVisibility(View.VISIBLE);

                String newCity = input.getText().toString();
                dataList.add(newCity);
                cityAdapter.notifyDataSetChanged();
                input.setText("");
                input.setVisibility(View.GONE);
                checkBox.setVisibility(View.GONE);
            }
        });
    }
}