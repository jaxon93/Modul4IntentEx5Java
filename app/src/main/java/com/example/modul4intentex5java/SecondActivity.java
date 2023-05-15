package com.example.modul4intentex5java;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.modul4intentex5java.modul.Member;
import com.example.modul4intentex5java.modul.User;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    void initView() {
        TextView tv_second = (TextView) findViewById(R.id.tv_second);
        Button b_exit_second = (Button) findViewById(R.id.b_exit_second);

        User user = (User) getIntent().getParcelableExtra("user");
        tv_second.setText(user.toString());

        Member member = new Member(22, "Mirabbos");


        b_exit_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToFinish(member);
            }
        });
    }

    void backToFinish(Member member) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("member", member);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}