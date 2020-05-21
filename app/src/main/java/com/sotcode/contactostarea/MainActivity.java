package com.sotcode.contactostarea;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.sotcode.contactostarea.adapter.PageAdapter;
import com.sotcode.contactostarea.vista_fragment.PerfilFragment;
import com.sotcode.contactostarea.vista_fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
         tabLayout =(TabLayout) findViewById(R.id.tabLayout);
         viewPager = (ViewPager) findViewById(R.id.viewPager);
         setUpViewPager();
            if (toolbar != null){
                setSupportActionBar(toolbar);
            }

    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return  fragments;
    }
    public void setUpViewPager(){
   viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
   tabLayout.setupWithViewPager(viewPager);
tabLayout.getTabAt(0).setIcon(R.drawable.persona);
tabLayout.getTabAt(1).setIcon(R.drawable.logofavoritos);
    }

}
