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
                String totalBillS, percentS, peopleNumS;
                totalBillS = String.valueOf(binding.tBill.getText());
                percentS = String.valueOf(binding.tipPercent.getText());
                peopleNumS = String.valueOf(binding.numOfPeople.getText());
                if (totalBillS.isEmpty() || peopleNumS.isEmpty() || peopleNumS.isEmpty()){
                    // do nothing
                }
                else{
                    float totalBill = Float.parseFloat(totalBillS);
                    int percent = Integer.parseInt(percentS);
                    int peopleNum = Integer.parseInt(peopleNumS);
                    float totalCal = ((((float)percent / 100) + 1) * totalBill) / peopleNum ;
                    String total = String.format("%.2f", totalCal);
                    binding.amountText.setText(new StringBuilder().append(getString(R.string.tPerPerson)).append(total).toString());
                }


            }
        });

    }
}