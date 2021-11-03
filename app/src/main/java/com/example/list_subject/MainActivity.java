package com.example.list_subject;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lst;
    // TextView ab;
    String obj,obj1;

    String [] devices = {"Планшеты", "Телефоны", "Компьютеры", "Ноутбуки"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//ab = findViewById(R.id.aboba);
        lst = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice,devices
        );
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
// ab.setText("");
                obj = "";
                obj1 = "";
                SparseBooleanArray chosen = ((ListView) adapterView).getCheckedItemPositions();
                for (int ad = 0; ad < chosen.size(); ad++) {
// если пользователь выбрал пункт списка,
// то выводим его в TextView.
                    if (chosen.valueAt(ad)) {
                        obj = (devices[chosen.keyAt(ad)] + " ");
                        obj1 += obj + " ";
// ab.append(devices[chosen.keyAt(ad)] + " ");
// Toast.makeText(getApplicationContext(),obj1, Toast.LENGTH_LONG).show();
                    }
//Toast.makeText(getApplicationContext(), ((TextView) ab).getText(), Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(),obj1, Toast.LENGTH_LONG).show();

            }
        });
    }}