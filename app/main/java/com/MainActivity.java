package com.example.bahar.ivt.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bahar.ivt.R;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuObject;
import com.yalantis.contextmenu.lib.MenuParams;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemLongClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements OnMenuItemClickListener, OnMenuItemLongClickListener {


    ContextMenuDialogFragment mMenuDialogFragment;
    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();

        initToolBar();
        initMenuFragment();
        addFragment(new MainFragment(), true, R.id.container);

    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textView = (TextView) findViewById(R.id.text_view_toolbar_title);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationIcon(R.drawable.icon_back_1);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        textView.setText("IVT");
    }

    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
        menuParams.setMenuObjects(getMenuObjects());
        menuParams.setClosableOutside(false);
        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);

    }

    private List<MenuObject> getMenuObjects() {

        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icon_close);
        close.setBgDrawable(getDrawable(R.drawable.shape2));
        close.setDividerColor(R.color.transparent);





        MenuObject info = new MenuObject("مشخصات");
        info.setResource(R.drawable.icon_profile);
        info.setBgDrawable(getDrawable(R.drawable.shape2));
        info.setDividerColor(R.color.transparent);



        MenuObject word = new MenuObject("کلمات");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icon_word);
        word.setBitmap(b);
        word.setBgDrawable(getDrawable(R.drawable.shape2));
        word.setDividerColor(R.color.transparent);


        MenuObject test = new MenuObject("Test Yourself!");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icon_test));
        test.setDrawable(bd);
        test.setBgDrawable(getDrawable(R.drawable.shape2));
        test.setDividerColor(R.color.transparent);

        MenuObject aboutUs = new MenuObject("درباره ی ما");
        aboutUs.setResource(R.drawable.icon_about_us);
        aboutUs.setBgDrawable(getDrawable(R.drawable.shape2));
        aboutUs.setDividerColor(R.color.transparent);


        menuObjects.add(close);
        menuObjects.add(info);
        menuObjects.add(word);
        menuObjects.add(test);
        menuObjects.add(aboutUs);
        return menuObjects;
    }

    protected void addFragment(Fragment fragment, boolean addToBackStack, int containerId) {
        invalidateOptionsMenu();
        String backStackName = fragment.getClass().getName();
        boolean fragmentPopped = mFragmentManager.popBackStackImmediate(backStackName, 0);
        if (!fragmentPopped) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.add(containerId, fragment, backStackName)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            if (addToBackStack)
                transaction.addToBackStack(backStackName);
            transaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (mMenuDialogFragment != null && mMenuDialogFragment.isAdded()) {
            mMenuDialogFragment.dismiss();
        } else {
            finish();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.context_menu:
                if (mFragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
                    mMenuDialogFragment.show(mFragmentManager, ContextMenuDialogFragment.TAG);
                }
                break;
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onMenuItemClick(View clickedView, int position) {
        if(position== 1){
            Intent intent = new Intent(MainActivity.this,InfoActivity.class);
            startActivity(intent);
        } else if (position==2){
            Intent intent = new Intent(MainActivity.this,AllVocabularyActivity.class);
            startActivity(intent);
        } else if (position==3){
            Intent intent = new Intent(MainActivity.this,IeltsSamplesActivity.class);
            startActivity(intent);
        } else {
//            Intent intent = new Intent(MainActivity.this,AboutUsActivity.class);
//            startActivity(intent);
        }
    }

    @Override
    public void onMenuItemLongClick(View clickedView, int position) {
        Toast.makeText(this, "Long clicked on position: " + position, Toast.LENGTH_SHORT).show();

    }
}
