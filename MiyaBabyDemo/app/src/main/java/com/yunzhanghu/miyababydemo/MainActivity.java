package com.yunzhanghu.miyababydemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity implements OnViewClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.tab_rg);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, MainPageFragment.newInstance()).commit();
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                changeContent(checkedId);
            }
        });
    }

    private void changeContent(int checkedId) {
        Fragment fragment = null;
        switch (checkedId) {
            case R.id.rb_first:
                fragment = MainPageFragment.newInstance();
                break;
            case R.id.rb_second:
                break;
            case R.id.rb_third:
                fragment = DiscoverFragment.newInstance();
                break;
            case R.id.rb_forth:
                fragment = CartFragment.newInstance();
                break;
            case R.id.rb_fifth:
                fragment = MyFragment.newInstance();
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
        }
    }

    @Override
    public void onViewClick(int id) {

    }
}
