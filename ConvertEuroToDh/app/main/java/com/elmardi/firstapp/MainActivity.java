package com.elmardi.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextAmount = findViewById(R.id.editTextAmount);
        Button buttonCompute = findViewById(R.id.buttonCompute);
        TextView textViewResults = findViewById(R.id.textViewResults);
        ListView listViewResults = findViewById(R.id.listViewResults);
        List<String> data = new ArrayList<>();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        listViewResults.setAdapter(stringArrayAdapter);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(editTextAmount.getText().toString());
                double result = amount*10;
                textViewResults.setText(String.valueOf(result));
                data.add(amount+"=>"+result);
                stringArrayAdapter.notifyDataSetChanged();
                editTextAmount.setText("");
            }
        });
    }
}