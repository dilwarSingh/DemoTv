package koi.com.demotv;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.InputStream;

import developer.shivam.library.DiagonalView;
import rm.com.audiowave.AudioWaveView;
import rm.com.audiowave.OnProgressListener;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    AudioWaveView audioWaveView;
    DiagonalView diagonalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        audioWaveView = (AudioWaveView) findViewById(R.id.wave);
        toolbar.setTitle("Playlist");
        diagonalView = (DiagonalView) findViewById(R.id.diagonal_view1);

        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.bringToFront();
        setSupportActionBar(toolbar);

        audioWaveView.setEnabled(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            ViewGroup.MarginLayoutParams toolbarPrams = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
            toolbarPrams.topMargin = 0;
            toolbar.setLayoutParams(toolbarPrams);
        }

        try {
            Resources res = getResources();
            InputStream inStream = res.openRawResource(R.raw.song);

            byte[] buff = new byte[inStream.available()];
            inStream.read(buff);
            audioWaveView.setRawData(buff);


        } catch (Exception e) {
            e.printStackTrace();
        }

        audioWaveView.setOnProgressListener(new OnProgressListener() {
            @Override
            public void onStartTracking(float v) {

            }

            @Override
            public void onStopTracking(float v) {

            }

            @Override
            public void onProgressChanged(float v, boolean b) {

                DisplayMetrics displayMetrics = getApplication().getResources().getDisplayMetrics();
                float dpWidth = displayMetrics.widthPixels;

                int diagHeight = (int) ((int) dpWidth - (dpWidth * v / 100));

                ViewGroup.MarginLayoutParams linerPrams = (ViewGroup.MarginLayoutParams) diagonalView.getLayoutParams();
                linerPrams.rightMargin = diagHeight;

                diagonalView.setLayoutParams(linerPrams);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
