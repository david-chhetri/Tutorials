package com.dhan.fragmentcommunicationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageReadListener {
    //Tutorial:  https://www.youtube.com/watch?v=ruPRpiJNJrU

    //It is not possible to communicate between two fragments
    //We do it using interfaces
    //Define interface on fragment and implement that interface on parent activity
    //By implementing the methods the fragment can communicate with the activity

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adding fragment to the main activity
        if( findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            MessageFragment messageFragment = new MessageFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container,messageFragment,null);
            fragmentTransaction.commit();

        }
    }


    @Override
    public void onMessageRead(String message) {
        textView = findViewById(R.id.txt_display_message);
        textView.setText(message);


    }
}