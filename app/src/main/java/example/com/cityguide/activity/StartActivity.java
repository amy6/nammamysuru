package example.com.cityguide.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import example.com.cityguide.R;

public class StartActivity extends AppCompatActivity {



        ListView listView;
        TextView textView;
        String[] listItem;

        ListView l;
        String city[]
                = { "Mysuru","Delhi","Jaipur"};

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_start);
            listView = findViewById(R.id.listView);
            final ArrayAdapter<String> arr;
            arr
                    = new ArrayAdapter<String>(
                    this,
                    R.layout.support_simple_spinner_dropdown_item,
                    city);
            listView.setAdapter(arr);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // TODO Auto-generated method stub
                    String value = arr.getItem(position);

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("key",value);
                    startActivity(i);
//                    Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

                }
            });
        }

//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_start);
//
//            listView = (ListView) findViewById(R.id.listView);
//            textView = (TextView) findViewById(R.id.textView);
//            listItem = getResources().getStringArray(R.array.city);
//            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                    android.R.layout.activity_list_item, android.R.id.text1, listItem);
//            listView.setAdapter(adapter);
//
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                    // TODO Auto-generated method stub
//                    String value = adapter.getItem(position);
//
//                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                    i.putExtra("key",value);
//                    startActivity(i);
////                    Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
//
//                }
//            });
//        }

}