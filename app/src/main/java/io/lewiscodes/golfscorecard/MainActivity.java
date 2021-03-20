package io.lewiscodes.golfscorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {
    private HoleTracker[] holes;
    private static final int TOTAL_HOLES = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        holes = new HoleTracker[TOTAL_HOLES];
        for(int i = 0; i < TOTAL_HOLES; i++) {
            holes[i] = new HoleTracker(i + 1);
        }
    }
}