package com.example.volunteer_matching;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelperMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_main);

        Button btn_position = findViewById(R.id.btn_search_position);
        Button btn_condiiton = findViewById(R.id.btn_search_condition);
        Button btn_profile = findViewById(R.id.btn_profile);
        Button btn_back = findViewById(R.id.btn_back);
        Button btn_home = findViewById(R.id.btn_home);
        Button btn_setup = findViewById(R.id.btn_setup);
        Button btn_refresh = findViewById(R.id.btn_refresh);

        HomeFragment homeFragment = HomeFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.helper_main_frame, homeFragment).commit();

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment homeFragment_home = HomeFragment.newInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.helper_main_frame, homeFragment_home).commit();
            }
        });
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment homeFragment_refresh = HomeFragment.newInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.helper_main_frame, homeFragment_refresh).commit();
            }
        });
        btn_position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPosition = new Intent(HelperMainActivity.this, PositionActivity.class);
                startActivity(toPosition);
            }
        });
        btn_condiiton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConditionFragment conditionFragment = ConditionFragment.newInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.helper_main_frame, conditionFragment).commit();
            }
        });
    }
}
