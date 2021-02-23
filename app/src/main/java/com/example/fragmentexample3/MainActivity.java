package com.example.fragmentexample3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean twoPane  = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if we cannot find the second fragment in the layout
        // that means we only have one column -> landscape mode
        if (findViewById(R.id.fragContainerLand_second) != null){
            twoPane = true;
        }

        // loading whether 1 or 2 frags based on this boolean variable

        if (!twoPane) { // Portrait
            loadFragment(new FirstFragment(), R.id.fragContainer_first);
            Button button = findViewById(R.id.button_personality);
            Button button_2 = findViewById(R.id.button_house);
            button.setOnClickListener(v -> launchActivity(v));
            button_2.setOnClickListener(v -> launchActivity_2(v));

        }
        else{
            loadFragment(new FirstFragment(), R.id.fragContainerLand_first);
            loadFragment(new SecondFragment(), R.id.fragContainerLand_second);
            loadFragment(new ThirdFragment(), R.id.fragContainerLand_third);
        }

    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public void launchActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void launchActivity_2(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}