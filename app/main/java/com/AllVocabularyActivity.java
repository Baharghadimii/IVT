package com.example.bahar.ivt.Activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.bahar.ivt.Activities.Adapter.WordsAdapter;
import com.example.bahar.ivt.Activities.Sources.DictionaryData;
import com.example.bahar.ivt.R;

public class AllVocabularyActivity extends AppCompatActivity {

    public RecyclerView myRecyclerView;
    public RecyclerView.Adapter wordsAdapter;
    public RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_vocabulary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.nav_bar_words));
        for(int i = 0; i < toolbar.getChildCount(); i++)
        { View view = toolbar.getChildAt(i);

            if(view instanceof TextView) {
                TextView textView = (TextView) view;

                Typeface myCustomFont= Typeface.createFromAsset(getAssets(),"fonts/IRANSans.ttf");
                textView.setTypeface(myCustomFont); }


        }


        DictionaryData.initDictionary();

        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        wordsAdapter = new WordsAdapter(DictionaryData.getAllEntries());
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.setAdapter(wordsAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.context_menu) {
            super.onBackPressed();
            DictionaryData.wordsList.clear();
            wordsAdapter.notifyDataSetChanged();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
