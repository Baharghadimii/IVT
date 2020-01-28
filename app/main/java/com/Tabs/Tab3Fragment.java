package com.example.bahar.ivt.Activities.Tabs;

/**
 * Created by Bahar on 10/17/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bahar.ivt.Activities.Sources.DictionaryData;
import com.example.bahar.ivt.Activities.Sources.DictionaryEntry;
import com.example.bahar.ivt.R;

import pl.droidsonroids.gif.GifImageView;


public class Tab3Fragment extends Fragment {


    private GifImageView gif;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        gif = (GifImageView) view.findViewById(R.id.gif);

        DictionaryEntry myEntry = DictionaryData.getDefinition(getActivity().getIntent().getStringExtra("word"));
        if (myEntry != null) {

            gif.setImageResource(myEntry.getGif());
        }


        return view;






    }
}