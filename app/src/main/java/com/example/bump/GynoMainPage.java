package com.example.bump;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

public class GynoMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyno_main_page);


        MaterialToolbar toolbar=findViewById(R.id.gynotopAppbar);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout1);
        NavigationView navigationView=findViewById(R.id.gynonavigation_view);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {
                    case R.id.nav_notification:
                        replaceFragment(new GynoNotificationFragment());
                        break;
                    case R.id.nav_queries:

                        replaceFragment(new GynoQueriesFragment());
                        break;
                    case R.id.nav_logout:
                        Intent intent=(new Intent(GynoMainPage.this,MainActivity.class));
                        startActivity(intent);
                        break;
                    case R.id.nav_home:
                        Intent intent1=(new Intent(GynoMainPage.this,MainActivity.class));
                        startActivity(intent1);

                    default:
                        return true;
                }

                return true;
            }
        });
    }
    private void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager1=getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager1.beginTransaction();
//        fragmentTransaction.replace(R.id.frameLayout,fragment);
//        fragmentTransaction.commit();
    }





}