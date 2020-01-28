package com.example.bahar.ivt.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bahar.ivt.R;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class EnrollActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        //**initializing


        final EditText editText1 = (EditText) findViewById(R.id.edt_txt1);
        final EditText editText2 = (EditText) findViewById(R.id.edt_txt2);
        editText1.setShowSoftInputOnFocus(false);
        editText2.setShowSoftInputOnFocus(false);

        ShimmerTextView shimmerTextView = (ShimmerTextView) findViewById(R.id.shimmer_tv);

        Button btn = (Button) findViewById(R.id.enter);

        Shimmer shimmer = new Shimmer();
        shimmer.start(shimmerTextView);

        Typeface myTypeface = Typeface.createFromAsset(this.getAssets(), "fonts/IRANSans.ttf");

        //**set typeFace

        shimmerTextView.setTypeface(myTypeface);
        btn.setTypeface(myTypeface);

        //** handling button and edit text

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText1.getText().toString().equals("bahargh")&&editText2.getText().toString().equals("0000")) {
                    startActivity(new Intent(EnrollActivity.this, MainActivity.class));

                }else {
                    Toast.makeText(EnrollActivity.this, "نام کاربری یا کلمه عبور صحیح نمیباشد!", Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}
