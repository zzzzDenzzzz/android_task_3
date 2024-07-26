package com.example.app_3;

import static com.example.app_3.StringConst.AMOUNT_WITH_TIP;
import static com.example.app_3.StringConst.PERCENT;
import static com.example.app_3.StringConst.TIPS;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.seekBarTipId.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.tvTipPercentageId.setText(progress + PERCENT);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        binding.btnCalculateId.setOnClickListener(v -> {
            String billAmountStr = binding.etBillAmountId.getText().toString();
            if (!billAmountStr.isEmpty()) {
                double billAmount = Double.parseDouble(billAmountStr);
                int tipPercentage = binding.seekBarTipId.getProgress();
                double tipAmount = billAmount * tipPercentage / 100;
                double totalAmount = billAmount + tipAmount;

                binding.tvTipAmountId.setText(TIPS + String.format("%.2f", tipAmount));
                binding.tvTotalAmountId.setText(AMOUNT_WITH_TIP + String.format("%.2f", totalAmount));
            }
        });
    }
}