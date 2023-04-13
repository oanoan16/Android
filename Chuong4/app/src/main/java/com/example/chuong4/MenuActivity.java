package com.example.chuong4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        txt = findViewById(R.id.textView);
        registerForContextMenu(txt);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_color, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mExit:
                System.exit(0);
                break;
            case R.id.mFile:
                Toast.makeText(this,"Selected File", Toast.LENGTH_LONG).show();
                break;
            case R.id.mEmail:
                Toast.makeText(this,"Selected Email", Toast.LENGTH_LONG).show();
                break;

            case R.id.mPhone:
                Toast.makeText(this,"Selected Phone", Toast.LENGTH_LONG).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mRed:
                txt.setTextColor(getResources().getColor(R.color.cRed));
                break;
            case R.id.mGreen:
                txt.setTextColor(getResources().getColor(R.color.cGreen));
                break;
            case R.id.mBlue:
                txt.setTextColor(getResources().getColor(R.color.cBlue));
                break;
        }
        return super.onContextItemSelected(item);
    }
}