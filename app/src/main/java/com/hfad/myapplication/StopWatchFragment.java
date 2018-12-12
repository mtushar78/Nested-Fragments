package com.hfad.myapplication;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopWatchFragment extends Fragment implements View.OnClickListener{

    private int second=0;
    private boolean running;
    private boolean wasRunning;
    TextView textView;



    public StopWatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View layout= inflater.inflate(R.layout.fragment_stop_watch, container, false);
        Button start_button=layout.findViewById(R.id.start_button);
        start_button.setOnClickListener(this);
        Button stop_button=layout.findViewById(R.id.stop_button);
        stop_button.setOnClickListener(this);
        Button reset_button=layout.findViewById(R.id.reset_button);
        reset_button.setOnClickListener(this);

        if(savedInstanceState!=null){
            second=savedInstanceState.getInt("second");
            running=savedInstanceState.getBoolean("running");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
            if(wasRunning){
                running=true;
            }
        }

        runTimer(layout);
        return layout;
    }

    private void runTimer(View view) {
        final Handler handler=new Handler();
        textView=view.findViewById(R.id.timeView);

        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours=second/3600;
                int minutes=(second%3600)/60;
                int secs=second%60;

                String time= String.format("%d : %02d : %02d ",hours,minutes,secs);
                textView.setText(time);
                if(running){
                    second++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("running",running);
        outState.putBoolean("wasRunning", wasRunning);
        outState.putInt("sec",second);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case(R.id.start_button):
                onClickStart(view);
                break;
            case(R.id.stop_button):
                onClickStop(view);
                break;
            case(R.id.reset_button) :
                onClickReset(view);
        }
    }

    private void onClickReset(View view) {
        running=false;
        second=0;
    }

    private void onClickStop(View view) {
        running=false;
    }

    private void onClickStart(View view) {
        running=true;
    }


}
