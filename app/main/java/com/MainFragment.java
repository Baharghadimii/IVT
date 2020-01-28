package com.example.bahar.ivt.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bahar.ivt.R;

/**
 * Created by Bahar on 1/12/2019.
 */
public class MainFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        Button basic_btn = (Button) rootView.findViewById(R.id.basic_btn);
        basic_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VocabularyActivity.class);
                intent.putExtra("lesson", 1);
                startActivity(intent);
            }
        });
        Button intermediate_btn = (Button) rootView.findViewById(R.id.intermediate_btn);
        intermediate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VocabularyActivity.class);
                intent.putExtra("lesson", 2);
                startActivity(intent);
            }
        });
        Button upper_intermediate_btn = (Button) rootView.findViewById(R.id.upper_intermediate_btn);
        upper_intermediate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VocabularyActivity.class);
                intent.putExtra("lesson", 3);
                startActivity(intent);
            }
        });
        Button advance_btn = (Button) rootView.findViewById(R.id.advance_btn);
        advance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VocabularyActivity.class);
                intent.putExtra("lesson", 4);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
