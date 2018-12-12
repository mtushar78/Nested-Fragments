package com.hfad.myapplication;


import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState !=null){
            workoutId= savedInstanceState.getLong("workoutId");
        }

        else {
            StopWatchFragment stopWatchFragment = new StopWatchFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.childContainer, stopWatchFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view=getView();

        if(view !=null){
            TextView textView=view.findViewById(R.id.titleText);
            TextView description=view.findViewById(R.id.desText);

            Workout workout=Workout.workouts[(int)workoutId];
            textView.setText(workout.getName());
            description.setText(workout.getDescription());
        }
    }

    public void setWorkoutId(long workoutId) {

        this.workoutId = workoutId;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putLong("workoutId",workoutId);
    }
}
