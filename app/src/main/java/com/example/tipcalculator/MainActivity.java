package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tipcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float totalBill = Float.valueOf(String.valueOf(binding.tBill.getText()));
                int percent = Integer.valueOf(String.valueOf(binding.tipPercent.getText()));
                int peopleNum = Integer.valueOf(String.valueOf(binding.numOfPeople.getText()));
                float totalCal = ((((float)percent / 100) + 1) * totalBill) / peopleNum ;
                String total = String.format("%.2f", totalCal);
                binding.amountText.setText("Total Per Person: $" + total);

            }
        });

    }
}