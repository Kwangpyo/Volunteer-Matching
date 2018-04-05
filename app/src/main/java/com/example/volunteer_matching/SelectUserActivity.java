package com.example.volunteer_matching;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        Button btn_helper = (Button) findViewById(R.id.btn_helper);
        Button btn_helped = (Button) findViewById(R.id.btn_helped);

        btn_helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHelperMain = new Intent(SelectUserActivity.this, HelperMainActivity.class);

                startActivity(toHelperMain);
                finish();
            }
        });
    }
}
