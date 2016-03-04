package fr.android.animefight.view;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by rodesousa on 02/03/16.
 */
public class FightView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceViewHolder;

    public FightView(Context context) {
        super(context);
        surfaceViewHolder = getHolder();
        surfaceViewHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
