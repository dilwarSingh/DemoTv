package koi.com.demotv;


import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.mikhaellopez.circularimageview.CircularImageView;

import developer.shivam.library.DiagonalView;

import static android.content.Context.WINDOW_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    FloatingActionButton fab;
    CircularImageView image;
    LinearLayout linerLay;
    DiagonalView diagonalView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank, container, false);


        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        image = (CircularImageView) view.findViewById(R.id.image);
        linerLay = (LinearLayout) view.findViewById(R.id.linerLay);
        diagonalView = (DiagonalView) view.findViewById(R.id.diagonal_view);


        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels;

        Log.i("infoDilwar width", dpWidth + "");



        int fabHeight = (int) (((dpWidth - 100) - 50) * (0.267)) - (15);
        int linerHeight = (int) ((20) * (0.267));
        int imageHeight = (int) ((dpWidth / 2) * (0.267)) - (60);




        Log.i("infoDilwar tan", Math.tan(15) + "");
        Log.i("infoDilwar fab", fabHeight + "");
        Log.i("infoDilwar liner", linerHeight + "");
        Log.i("infoDilwar image", imageHeight + "");


        ViewGroup.MarginLayoutParams fabParams = (ViewGroup.MarginLayoutParams) fab.getLayoutParams();
        fabParams.bottomMargin = fabHeight;
        ViewGroup.MarginLayoutParams imageParams = (ViewGroup.MarginLayoutParams) image.getLayoutParams();
        imageParams.bottomMargin = imageHeight;
        ViewGroup.MarginLayoutParams linerPrams = (ViewGroup.MarginLayoutParams) linerLay.getLayoutParams();
        linerPrams.bottomMargin = linerHeight;


        fab.setLayoutParams(fabParams);
        image.setLayoutParams(imageParams);
        linerLay.setLayoutParams(linerPrams);


        return view;
    }

}
