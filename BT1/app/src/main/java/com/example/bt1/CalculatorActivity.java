package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class CalculatorActivity extends AppCompatActivity {
    EditText num1, num2;
    Button btnAdd;
    TextView tv1, tv2;
    Spinner spTinh;
    ArrayAdapter<String> adapterTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initGUI();

        spTinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String snum1 =  num1.getText().toString();
                String snum2 =  num2.getText().toString();
                double n1, n2;
                try {
                    n1 = Double.parseDouble(snum1);
                    n2 = Double.parseDouble(snum2);
                    String o = adapterTinh.getItem(position);
                    tv2.setText(tinh(n1, n2, o));
                }
                catch (NumberFormatException e){
                    Toast.makeText(CalculatorActivity.this, "fill number", Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public Double tong(Double d1, Double d2) {
        return d1+d2;
    }

    private void initGUI() {
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnAdd = findViewById((R.id.btnAdd));
//        tv1 = findViewById(R.id.txtResult);
        tv2 = findViewById(R.id.txtResult);
        spTinh = findViewById(R.id.spinner);
        String[] listTinh = getResources().getStringArray(R.array.listPhepTinh);
        adapterTinh = new ArrayAdapter<>(this, R.layout.item, listTinh);
        spTinh.setAdapter(adapterTinh);
    }

    public void tinhToan(View v) {
        String txtn1 = num1.getText().toString();
        String txtn2 = num2.getText().toString();

        double n1, n2;
        try {
            n1 = Double.parseDouble(txtn1);
            n2 = Double.parseDouble(txtn2);
            tv2.setText(String.format(java.util.Locale.US, "Ket qua: %f", tong(n1, n2)));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "de nghi nhap so", Toast.LENGTH_LONG).show();
        }
    }

    private String tinh(double x, double y, String o) {
        String t = "";
        switch (o) {
            case "+":
                t = "Tong: " + (x + y);
                break;
            case "-":
                t = "Hieu: " + (x - y);
                break;
            case "*":
                t = "Tich: " + (x * y);
                break;
            case "/":
                if (y == 0) {
                    t = "Khong chia cho 0";
                }
                else {
                    t = "Thuong: " + (x / y);
                }
                break;
        }
        return t;
    }

}