package ru.aev.basemvp.ui.activity.second;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import ru.aev.basemvp.R;
import ru.aev.basemvp.ui.fragment.blank.BlankFragment;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (savedInstanceState == null) {
            Fragment fragment = BlankFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment, fragment.getTag())
                    .commit();
        }
    }
}
