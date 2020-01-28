package com.example.bahar.ivt.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.bahar.ivt.Activities.Adapter.TabAdapter;
import com.example.bahar.ivt.Activities.Tabs.Tab1Fragment;
import com.example.bahar.ivt.Activities.Tabs.Tab2Fragment;
import com.example.bahar.ivt.Activities.Tabs.Tab3Fragment;
import com.example.bahar.ivt.R;

public class WordsActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_word);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        TextView tct = (TextView) findViewById(R.id.text_view_toolbar_title);
        tct.setText(getString(R.string.app_name));



        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), getString(R.string.word_frag));
        adapter.addFragment(new Tab2Fragment(), getString(R.string.code_frag));
        adapter.addFragment(new Tab3Fragment(), getString(R.string.gif_frag));

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

}


