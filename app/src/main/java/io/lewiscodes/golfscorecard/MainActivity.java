package io.lewiscodes.golfscorecard;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends ListActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String PREFS_FILE = "io.lewiscodes.golfscorecard.preferences";
    private static final String KEY_STROKES = "key_strokes";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ListAdapter listAdapter;
    private HoleTracker[] holes;
    private static final int TOTAL_HOLES = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        holes = new HoleTracker[TOTAL_HOLES];
        for(int i = 0; i < TOTAL_HOLES; i++) {
            holes[i] = new HoleTracker(i + 1);
            holes[i].setStrokes(sharedPreferences.getInt(KEY_STROKES + i, 0));
            Log.i(TAG, "In onCreate/nSetting prefs to " +
                    holes[i].getHoleName() +
                    ", Key: " + KEY_STROKES + i + 1 +
                    ", Value: " + sharedPreferences.getInt(KEY_STROKES + i, 0));
        }

        listAdapter = new ListAdapter(this, holes);
        setListAdapter(listAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        for (HoleTracker hole : holes) {
            editor.putInt(KEY_STROKES + (hole.getHoleNumber() - 1), hole.getStrokes());
            Log.i(TAG, "In onPause/nAdding to " +
                    hole.getHoleName() +
                    ", Key: " + KEY_STROKES + (hole.getHoleNumber() - 1) +
                    ", Value: " + hole.getStrokes());
        }
        editor.apply();
    }


}