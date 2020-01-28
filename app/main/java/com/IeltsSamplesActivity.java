package com.example.bahar.ivt.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.bahar.ivt.R;

public class IeltsSamplesActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ielts_samples);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.nav_bar_exam_samples));


        Button btn_basic_test = (Button) findViewById(R.id.basic_btn_test);
        btn_basic_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IeltsSamplesActivity.this, BasicSampleActivity.class);
                intent.putExtra("lesson",1);
                startActivity(intent);
            }
        });
        Button btn_intermediate_test = (Button) findViewById(R.id.intermediate_btn_test);
        btn_intermediate_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IeltsSamplesActivity.this, BasicSampleActivity.class);
                intent.putExtra("lesson",2);
                startActivity(intent);
            }
        });
        Button btn_upper_intermediate_test = (Button) findViewById(R.id.upper_intermediate_btn_test);
        btn_upper_intermediate_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IeltsSamplesActivity.this, BasicSampleActivity.class);
                intent.putExtra("lesson",3);
                startActivity(intent);
            }
        });
        Button btn_advance_test = (Button) findViewById(R.id.advance_btn_test);
        btn_advance_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IeltsSamplesActivity.this, BasicSampleActivity.class);
                intent.putExtra("lesson",4);
                startActivity(intent);
            }
        });

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
