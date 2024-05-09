package com.midterm.minhhan;

import com.midterm.minhhan.databinding.ActivityMainBinding;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailsActivity extends AppCompatActivity {
    private TextView tvDetails;
    private FloatingActionButton btnDetails;
    private Button btnUpdate;
    private MyViewModel model;
    private MainActivity main;
    private int currentNumber;
    private ActivityMainBinding binding;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
        btnUpdate = findViewById(R.id.btn_Update);
        tvDetails = findViewById(R.id.tv_details);
        btnDetails = findViewById(R.id.btn_details);

        Intent receivedIntent = getIntent();

        if(receivedIntent != null) {
            String data = receivedIntent.getStringExtra("number");
            tvDetails.setText(data);
        }
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentNumber = Integer.parseInt(tvDetails.getText().toString());
                tvDetails.setText(String.valueOf(--currentNumber));
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                int updatedNumber = Integer.parseInt(tvDetails.getText().toString());
                intent.putExtra("number", updatedNumber);
                int position = getIntent().getIntExtra("position", -1);
                intent.putExtra("position", position);
                setResult(33, intent);
                finish();
            }
        });

    }
}