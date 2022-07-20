package gr.iek.lectures.android.halfdayvisitapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gr.iek.lectures.android.halfdayvisitapplication.views.Participants;
import gr.iek.lectures.android.halfdayvisitapplication.views.RoutesList;
import gr.iek.lectures.android.halfdayvisitapplication.views.StreetList;

public class MainActivity extends AppCompatActivity {

    private Button routesButton;
    private Button streetsBtn;
    private Button participantsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Half Day Visit");

        routesButton = findViewById(R.id.show_routes);
        routesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RoutesList.class));
            }
        });

        streetsBtn = findViewById(R.id.show_streets);
        streetsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StreetList.class));
            }
        });


        participantsBtn = findViewById(R.id.participantsBtn);
        participantsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Participants.class));
            }
        });

    }
}