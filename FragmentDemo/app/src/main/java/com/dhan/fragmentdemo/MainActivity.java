package com.dhan.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;

//import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean status = true;
    Button btn = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.loadBtn);
    }

    public void loadFirstClicked(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(status){
            FragmentOne f1 = new FragmentOne();
            fragmentTransaction.add(R.id.fragmentContainer, f1);
            btn.setText("Load second fragment");

        }else{
            FragmentTwo f2 = new FragmentTwo();
            fragmentTransaction.add(R.id.fragmentContainer,f2);
            btn.setText("Load first fragment");
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        status = !status;
    }
}