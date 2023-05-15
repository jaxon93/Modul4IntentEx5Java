package com.example.modul4intentex5java;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.modul4intentex5java.modul.Member;
import com.example.modul4intentex5java.modul.User;

public class MainActivity extends AppCompatActivity {
    TextView tv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    // Create the ActivityResultLauncher
    ActivityResultLauncher<Intent> secondLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK) {
            // Retrieve the object from the detail activity
            Intent data = result.getData();
            if (data != null) {
                Member member = data.getParcelableExtra("member");

                tv_main.setText(member.toString());
            }
        }
    });


    protected void initView() {
        Button b_open_second = (Button) findViewById(R.id.b_open_second);
        tv_main = (TextView) findViewById(R.id.tv_main);
        User user = new User(20, "Jakhongir");

        b_open_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity(user);
            }
        });

    }

    void openSecondActivity(User user) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("user", user);
        secondLauncher.launch(intent);
    }
}