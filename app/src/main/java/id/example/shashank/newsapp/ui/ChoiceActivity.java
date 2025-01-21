package id.example.shashank.newsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.example.shashank.newsapp.R;

public class ChoiceActivity extends AppCompatActivity {
 CardView cvMasak;
 CardView cdMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        cvMasak = findViewById(R.id.cvMasak);
        cvMasak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChoiceActivity.this, MainActivity.class));
            }
        });

        cdMain = findViewById(R.id.cdMain);
        cdMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChoiceActivity.this, TtsActivity.class));
            }
        });
    }
}