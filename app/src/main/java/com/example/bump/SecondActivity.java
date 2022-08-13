package com.example.bump;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        MaterialToolbar toolbar=findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.navigation_view);
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

                    case R.id.nav_gynecologist:
                        replaceFragment(new GynecologistFragment()); break;
                    case R.id.nav_counsellor:
                        replaceFragment(new counsellorFragment()); break;
                    case R.id.nav_ask:
                        replaceFragment(new AskFragment());break;
                    case R.id.nav_reply:
                        replaceFragment(new ReplyFragment());break;
                    case R.id.nav_logout:
                        Intent intent=(new Intent(SecondActivity.this,MainActivity.class));
                        startActivity(intent);
                        break;
                    case R.id.nav_home:
                       Intent intent1=(new Intent(SecondActivity.this,MainActivity.class));
                       startActivity(intent1);

                    default:
                        return true;
                }

                return true;
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }


    public void f1(HashMap<String, String> s) {
        FragmentManager manager1=getSupportFragmentManager();
        FragmentTransaction t1=manager1.beginTransaction();
        GynoFrgment2 m22=new GynoFrgment2();
        Bundle b2=new Bundle();
        int i;
        b2.putString("s", String.valueOf(s));
        m22.setArguments(b2);
        t1.replace(R.id.frameLayout,m22);
        t1.commit();

    }

    public void f2(HashMap<String, String> s) {
        FragmentManager manager2=getSupportFragmentManager();
        FragmentTransaction t2=manager2.beginTransaction();
        Reply2Fragment m33=new Reply2Fragment();
        Bundle b3=new Bundle();
        int i;
        b3.putString("s",String.valueOf(s));
        m33.setArguments(b3);
        t2.replace(R.id.frameLayout,m33);
        t2.commit();

    }

    public void f3(HashMap<String, String> s) {
        FragmentManager manager3=getSupportFragmentManager();
        FragmentTransaction t3=manager3.beginTransaction();
        CounsFragment m44=new CounsFragment();
        Bundle b4=new Bundle();
        int i;
        b4.putString("s",String.valueOf(s));
        m44.setArguments(b4);
        t3.replace(R.id.frameLayout,m44);
        t3.commit();
    }


}