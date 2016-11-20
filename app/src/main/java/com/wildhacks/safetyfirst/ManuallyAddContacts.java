package com.wildhacks.safetyfirst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class ManuallyAddContacts extends AppCompatActivity {

    ArrayList<String> mobileNoList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manually_add_contacts);
        mobileNoList = new ArrayList<>();
        mobileNoList.add("3128717627");
        Button addBtn = (Button) findViewById(R.id.addBtn);
        final EditText editText = (EditText) findViewById(R.id.mobTxtView);
        ListView listView = (ListView) findViewById(R.id.mobileListView);

        final ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mobileNoList);
        listView.setAdapter(aa);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText() != null && editText.getText().length() > 0) {
                    if (editText.getText().length() == 10) {
                        mobileNoList.add(editText.getText().toString());
                        aa.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getApplicationContext(), "Not Valid Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
