package com.example.bahar.ivt.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bahar.ivt.Activities.Adapter.TestAdapter;
import com.example.bahar.ivt.Activities.Sources.DictionaryData;
import com.example.bahar.ivt.R;

import java.util.ArrayList;
import java.util.Random;

public class BasicSampleActivity extends AppCompatActivity {

    private TextView cw, cw_def, word;
    public RecyclerView myRecyclerView;
    public RecyclerView.Adapter testAdapter;
    public RecyclerView.LayoutManager myLayoutManager;
    private ArrayList<String> myList;
    public int listNum;
    public Random random = new Random();
    public int randomInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample1);

        cw = (TextView) findViewById(R.id.c_or_w);
        word = (TextView) findViewById(R.id.word);


        cw.setText(R.string.test_choose);


        final Intent intent = getIntent();
        Bundle b = intent.getExtras();
        final Integer integer = b.getInt("lesson");


        DictionaryData.initDictionary();


        listNum = DictionaryData.getAllEntries(integer).size();
        randomInt = random.nextInt(listNum);


        myList = new ArrayList<>();

        myList.add(DictionaryData.getAllEntries(integer).get(randomInt).getTestEntry().getDef1());
        myList.add(DictionaryData.getAllEntries(integer).get(randomInt).getTestEntry().getDef2());
        myList.add(DictionaryData.getAllEntries(integer).get(randomInt).getTestEntry().getDef3());
        myList.add(DictionaryData.getAllEntries(integer).get(randomInt).getTestEntry().getDef4());

        word.setText(DictionaryData.getAllEntries(integer).get(randomInt).getWord());
        myRecyclerView = (RecyclerView) findViewById(R.id.my_test_recycler_view);
        testAdapter = new TestAdapter(myList, new CustomItemClickListener() {
            int p;

            @Override
            public void onItemClick(View v, int position) {
                p = position;


                if (myList.get(p).equals(DictionaryData.getAllEntries(integer).get(randomInt).getCorrect())) {

                    final AlertDialog.Builder myBuilder = new AlertDialog.Builder(BasicSampleActivity.this);
                    View myView = getLayoutInflater().inflate(R.layout.dialog_box_right,null);

                    Button btn_next_right = (Button) myView.findViewById(R.id.btn_next_right);
                    Button btn_cancel_right = (Button) myView.findViewById(R.id.btn_cancel_right);


                    myBuilder.setView(myView);
                    final AlertDialog dialog = myBuilder.create();
                    dialog.show();

                    btn_next_right.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent.removeExtra("lesson");
                            intent.putExtra("lesson",integer);
                            BasicSampleActivity.this.recreate();
                            dialog.dismiss();
                        }
                    });
                    btn_cancel_right.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            onBackPressed();
                        }
                    });

                } else {

                    final AlertDialog.Builder myBuilder = new AlertDialog.Builder(BasicSampleActivity.this);
                    View myView = getLayoutInflater().inflate(R.layout.dialog_box_wrong,null);

                    TextView txt_word = (TextView) myView.findViewById(R.id.word_test);
                    TextView txt_def = (TextView) myView.findViewById(R.id.def_test);
                    Button btn_next = (Button) myView.findViewById(R.id.btn_next);
                    Button btn_cancel = (Button) myView.findViewById(R.id.btn_cancel);

                    txt_word.setText(DictionaryData.getAllEntries(integer).get(randomInt).getWord());
                    txt_def.setText(DictionaryData.getAllEntries(integer).get(randomInt).getDefinition());

                    myBuilder.setView(myView);
                    final AlertDialog dialog = myBuilder.create();
                    dialog.show();

                    btn_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent.removeExtra("lesson");
                            intent.putExtra("lesson",integer);
                            BasicSampleActivity.this.recreate();
                            dialog.dismiss();
                    }
                    });
                    btn_cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            onBackPressed();
                        }
                    });

                }


            }
        });

        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.setAdapter(testAdapter);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DictionaryData.wordsList.clear();
        testAdapter.notifyDataSetChanged();
        finish();
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
