package com.hfad.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // BlankFragment blankFragment=new BlankFragment();
        //blankFragment.setWorkoutId(1);

    }


    @Override
    public void onItemClicked(long id) {
        BlankFragment blankFragment=new BlankFragment();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        blankFragment.setWorkoutId(id);
        ft.replace(R.id.container,blankFragment);
        ft.commit();
        ft.addToBackStack(null);
    }


}
