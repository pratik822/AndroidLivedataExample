package com.example.pratik.myclicktimer;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    MyClick click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        click = ViewModelProviders.of(this).get(MyClick.class);
        click.gettimer().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                textView.setText(aLong+"");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            ////    click.setI(click.getI());
              //  textView.setText(click.getI()+"");

            }
        });

    }
}
