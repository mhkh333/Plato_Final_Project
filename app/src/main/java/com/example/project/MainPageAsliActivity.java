package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.project.ui.GamesFragment.GamesFragment;
import com.example.project.ui.dashboard.DashboardFragment;
import com.example.project.ui.home.HomeFragment;
import com.example.project.ui.notifications.AboutUs;
import com.example.project.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainPageAsliActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_asli);

        bottomNavigationView = this.findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.games:
                        Toast.makeText(getApplicationContext(), "Games", Toast.LENGTH_LONG).show();
                        GamesFragment fragment2 = new GamesFragment();
                        openFragment(fragment2);
                        break;

                    case R.id.navigation_dashboard:
                        DashboardFragment fragment3 = new DashboardFragment();
                        openFragment(fragment3);
                        Toast.makeText(getApplicationContext(), "List Of Chats", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navigation_home:
                        HomeFragment fragment1 = new HomeFragment();
                        openFragment(fragment1);
                        Toast.makeText(getApplicationContext(), "Friends", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navigation_notifications:
                        NotificationsFragment fragment = new NotificationsFragment();
                        openFragment(fragment);
                        Toast.makeText(getApplicationContext(), "Setting", Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });


        /////////////////////////////
     BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
              NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
    /////////////////////////////////


    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.commit();

    }


}