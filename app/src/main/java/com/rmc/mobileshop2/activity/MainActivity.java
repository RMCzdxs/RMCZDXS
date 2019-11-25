package com.rmc.mobileshop2.activity;


import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.rmc.mobileshop2.R;
import com.rmc.mobileshop2.common.BaseActivity;
import com.rmc.mobileshop2.fragment.NavigationFragment;

public class MainActivity extends BaseActivity {


    @Override
    public @LayoutRes
    int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_main,new NavigationFragment());
        transaction.commit();
    }
}


