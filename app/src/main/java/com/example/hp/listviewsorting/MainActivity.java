package com.example.hp.listviewsorting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
// Array of option ----> Array of Adapter ----> List view.
// List View is collection of views {  da_items.xml }.

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListView(); // Calling method
    }

    private void populateListView() { //Creating Method
        /**
         * Building Array adapter
         * Calling another layout da_items.xml and initializing  string array into it .
         **/

        //Creating Array of strings
        final String[] items={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>
                        (this,    // Context
                        R.layout.da_items, // Layout is used ( Created )
                        items);  //Array to be displayed
        //Creating & Initializing List view object
        ListView listview = (ListView) findViewById(R.id.ListviewMain);
        listview.setAdapter(adapter); //Passing list view into the adapter

        //Creating & Intializing Button object
        Button ascending=(Button)findViewById(R.id.asc);
        Button descending=(Button)findViewById(R.id.dsc);
        ascending.setOnClickListener(new View.OnClickListener() { // On click method for button 1
            @Override
            public void onClick(View v) {
                Arrays.sort(items); // Sorts the the array of string in Ascending order
                adapter.notifyDataSetChanged(); // It notifies the updated array
                Toast.makeText(getApplicationContext(),"List View in Ascending order",//Toast message
                        Toast.LENGTH_LONG).show();
            }
        });
        descending.setOnClickListener(new View.OnClickListener() { // On click method for button 2
            @Override
            public void onClick(View v) {
                /**
                 * Sorts the the array of string in Descending order.
                 * As array cannot sorts in reverse that's why we are taking collections.
                 **/
                Arrays.sort(items, Collections.<String>reverseOrder());
                adapter.notifyDataSetChanged(); // It notifies the updated array
                Toast.makeText(getApplicationContext(),"List View in Descending order",//Toast Message
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}
