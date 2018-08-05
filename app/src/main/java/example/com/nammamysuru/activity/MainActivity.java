package example.com.nammamysuru.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import example.com.nammamysuru.R;
import example.com.nammamysuru.fragment.EventFragment;
import example.com.nammamysuru.fragment.PlaceFragment;
import example.com.nammamysuru.fragment.RestaurantFragment;
import example.com.nammamysuru.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //use fragment manager and create a transaction to replace the container with default fragment
        final FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.container, new PlaceFragment()).commit();
        //set the title for the activity based on the current fragment
        setTitle(getString(R.string.places));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bnv);
        //define navigation between the different menu items
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                //initialize the fragment based on the menu item and set the activity title accordingly
                switch (item.getItemId()) {
                    case R.id.places:
                        fragment = new PlaceFragment();
                        setTitle(R.string.places);
                        break;
                    case R.id.restaurant:
                        fragment = new RestaurantFragment();
                        setTitle(getString(R.string.restaurants));
                        break;
                    case R.id.shop:
                        fragment = new ShopFragment();
                        setTitle(getString(R.string.shopping));
                        break;
                    case R.id.event:
                        fragment = new EventFragment();
                        setTitle(getString(R.string.events));
                        break;
                }
                //use the fragment manager to create a transaction and replace th container with the new fragment
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                return true;
            }
        });
    }
}
