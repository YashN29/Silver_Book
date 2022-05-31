package com.example.studypartner;

import static com.example.studypartner.R.id.host_nav_main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {

    Toolbar mytoolbar;
    DrawerLayout drawerLayout;
    AppBarConfiguration appBarConfiguration;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

      mytoolbar=findViewById(R.id.mytoolbar);
       setSupportActionBar(mytoolbar);

        bottomNavigationView = findViewById(R.id.bottom_nb);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        appBarConfiguration = new AppBarConfiguration.Builder(R.id.semester_Dashboard,R.id.profile_fragment,R.id.sem_1,R.id.show_doubts)
                .setDrawerLayout(drawerLayout)
                .build();

        NavController navController = Navigation.findNavController(this, host_nav_main);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView,navController);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, host_nav_main);
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
    }

//    @Override
//    public void onBackPressed() {
//        new AlertDialog.Builder(Dashboard.this)
//                .setTitle("Alert!")
//                .setMessage("Are You Sure?")
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i)
//                    {
//                        finish();
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i)
//                    {
//
//                    }
//                })
//                .setNeutralButton("Cancle", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i)
//                    {
//
//                    }
//                }).show();
//    }
}