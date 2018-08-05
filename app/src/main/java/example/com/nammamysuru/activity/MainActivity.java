package example.com.nammamysuru.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import example.com.nammamysuru.fragment.PlaceFragment;
import example.com.nammamysuru.R;
import example.com.nammamysuru.fragment.RestaurantFragment;
import example.com.nammamysuru.fragment.ShopFragment;
import example.com.nammamysuru.fragment.EventFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.container, new PlaceFragment()).commit();
        setTitle("Places");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.places:
                        fragment = new PlaceFragment();
                        setTitle("Places");
                        break;
                    case R.id.restaurant:
                        fragment = new RestaurantFragment();
                        setTitle("Restaurants");
                        break;
                    case R.id.shop:
                        fragment = new ShopFragment();
                        setTitle("Shopping");
                        break;
                    case R.id.event:
                        fragment = new EventFragment();
                        setTitle("Events");
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                return true;
            }
        });
    }
}
