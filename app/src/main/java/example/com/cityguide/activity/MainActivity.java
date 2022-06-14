package example.com.cityguide.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import example.com.cityguide.R;
import example.com.cityguide.fragment.EventFragment;
import example.com.cityguide.fragment.PlaceFragment;
import example.com.cityguide.fragment.RestaurantFragment;
import example.com.cityguide.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity {
    private  String value = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        //use fragment manager and create a transaction to replace the container with default fragment
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final Bundle bundle = new Bundle();
        bundle.putString("key", value);

        fragmentManager.beginTransaction().add(R.id.container, PlaceFragment.newInstance(bundle)).commit();
        //set the title for the activity based on the current fragment
        setTitle(getString(R.string.places));
//        Bundle bundle = new Bundle();
//        bundle.putString("edttext", "From Activity");
//// set Fragmentclass Arguments
//        PlaceFragment fragobj = new PlaceFragment();
//        fragobj.setArguments(bundle);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnv);
        //define navigation between the different menu items
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                //initialize the fragment based on the menu item and set the activity title accordingly
                switch (item.getItemId()) {
                    case R.id.places:
//                        Bundle bundle = new Bundle();
//                        bundle.putString("key", value);
                        fragment = PlaceFragment.newInstance(bundle);
                        setTitle(R.string.places);
                        break;
                    case R.id.restaurant:
                        fragment = RestaurantFragment.newInstance(bundle);
                        setTitle(getString(R.string.restaurants));
                        break;
//                    case R.id.shop:
//                        fragment = ShopFragment.newInstance(bundle);
//                        setTitle(getString(R.string.shopping));
//                        break;
                    case R.id.event:
                        fragment = EventFragment.newInstance(bundle);
                        setTitle(getString(R.string.events));
                        break;
                }
                //use the fragment manager to create a transaction and replace th container with the new fragment
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                return true;
            }
        });
    }

//    public Bundle getMyData() {
//        Bundle hm = new Bundle();
//        hm.putString("val1",value);
//        return hm;
//    }
}
