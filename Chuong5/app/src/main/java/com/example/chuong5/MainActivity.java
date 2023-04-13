package com.example.chuong5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager viewPager;
    AdapterViewPager adapterViewPager;
    BottomNavigationView bottom;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view_pager);
        adapterViewPager = new AdapterViewPager(getSupportFragmentManager(),
                3);
        viewPager.setPageTransformer(true,
                new HorizontalFlipTransformation());
        viewPager.setAdapter(adapterViewPager);
        tab.setupWithViewPager(viewPager);
        bottom.findViewById(R.id.btNav);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0: bottom.getMenu().findItem(R.id.mFood).setChecked(true);
                        break;
                    case 1: bottom.getMenu().findItem(R.id.mMovie).setChecked(true);
                        break;
                    case 2: bottom.getMenu().findItem(R.id.mTravel).setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mFood:viewPager.setCurrentItem(0);
                        break;
                    case R.id.mMovie:viewPager.setCurrentItem(1);
                        break;
                    case R.id.mTravel:viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem()==0) {
            super.onBackPressed();
        }
        else{
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    public void setTabLayoutTitleColor() {
        switch (viewPager.getCurrentItem()) {
            case 0:
                tab.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorPink));
                break;
            case 1:
                tab.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorBlue));
                break;
            case 2:
                tab.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorGreen));
                break;
            default:
        }
    }
}