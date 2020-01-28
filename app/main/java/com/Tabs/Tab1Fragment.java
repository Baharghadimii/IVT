package com.example.bahar.ivt.Activities.Tabs;

/**
 * Created by Bahar on 10/17/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bahar.ivt.Activities.Sources.DictionaryData;
import com.example.bahar.ivt.Activities.Sources.DictionaryEntry;
import com.example.bahar.ivt.R;


public class Tab1Fragment extends Fragment {

    TextView word,pro, def, syn , exmp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);




        word = (TextView) view.findViewById(R.id.wo);
        pro = (TextView) view.findViewById(R.id.pro);
        def = (TextView) view.findViewById(R.id.def);
        syn = (TextView) view.findViewById(R.id.syn);
        exmp = (TextView) view.findViewById(R.id.exmp);


        DictionaryEntry myEntry = DictionaryData.getDefinition(getActivity().getIntent().getStringExtra("word"));
        if (myEntry != null) {
            word.setText(myEntry.getWord());
            pro.setText(myEntry.getPronunciation());
            def.setText(myEntry.getDefinition());
            syn.setText(myEntry.getSynonym());
            exmp.setText(myEntry.getExample());
        }


        return view;


    }
}