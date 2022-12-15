package com.sheltortoiseusa.advancedpinchzoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import java.io.IOException;

public class PinchZoomPan extends View {
    private Bitmap newBitmap;

    private int imageWidth;
    private int imageHeight;

    private float posX = 0;
    private float posY = 0;
    private float touchX;
    private float touchY;

    private static final int INVALID_POINTER_ID = -1;
    private int activePointerID = INVALID_POINTER_ID;

    private ScaleGestureDetector SGD;
    private float scaleFactor = 1.0f;
    private final static float minZoom = 0.5f;
    private final static float maxZoom = 5.0f;

    public PinchZoomPan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        SGD = new ScaleGestureDetector(context, new ScaleListener());
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        SGD.onTouchEvent(event);

        final int action = event.getAction();

        switch(action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                final float x = event.getX();
                final float y = event.getY();

                touchX = x;
                touchY = y;

                activePointerID = event.getPointerId(0);

                break;
            }
            case MotionEvent.ACTION_MOVE: {
                final int pointerIndex = event.findPointerIndex(activePointerID);

                final float x = event.getX(pointerIndex);
                final float y = event.getY(pointerIndex);

                if(!SGD.isInProgress()) {
                    final float xDistance = (x - touchX);
                    final float yDistance = (y - touchY);

                    posX += xDistance;
                    posY += yDistance;

                    invalidate();
                }
                touchX = x;
                touchY = y;

                break;
            }
            case MotionEvent.ACTION_UP : {
                activePointerID = INVALID_POINTER_ID;

                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                activePointerID = INVALID_POINTER_ID;

                break;
            }
            case MotionEvent.ACTION_POINTER_UP: {
                final int pointerIndex = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                final int pointerId = event.getPointerId(pointerIndex);

                if(pointerId == activePointerID) {
                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;

                    touchX = event.getX(newPointerIndex);
                    touchY = event.getY(newPointerIndex);

                    activePointerID = event.getPointerId(newPointerIndex);
                }
                break;
            }
        }
        return true;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(newBitmap != null) {
            canvas.save();

            if((imageWidth * scaleFactor) > getWidth() || (imageHeight * scaleFactor) > getHeight()) {
                if(posX < (20 - (imageWidth * scaleFactor))) {
                    posX = (20 - (imageWidth * scaleFactor));
                }
                else if(posX > (getWidth() - 20)) {
                    posX = (getWidth() - 20);
                }
                if(posY < (20 - (imageHeight * scaleFactor))) {
                    posY = (20 - (imageHeight * scaleFactor));
                }
                else if(posY > (getHeight() - 20)) {
                    posY = (getHeight() - 20);
                }
            }
            else {
                if(posX < 20) {
                    posX = 20;
                }
                else if((posX + imageWidth * scaleFactor) > (getWidth() - 20)) {
                    posX = ((getWidth() - 20) - (imageWidth * scaleFactor));
                }
                if(posY < 20) {
                    posY = 20;
                }
                else if((posY + imageHeight * scaleFactor) > (getHeight() - 20)) {
                    posY = ((getHeight() - 20) - (imageHeight * scaleFactor));
                }
            }
            canvas.translate(posX, posY);
            canvas.scale(scaleFactor, scaleFactor);
            canvas.drawBitmap(newBitmap, 0, 0, null);
            canvas.restore();
        }
    }
    public void loadImageOnCanvas(Uri selectedImage) {
        Bitmap bitmap = null;

        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), selectedImage);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        float aspectRatio = (float) bitmap.getHeight() / (float) bitmap.getWidth();

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        imageWidth = displayMetrics.widthPixels;
        imageHeight = Math.round(imageWidth * aspectRatio);

        newBitmap = bitmap.createScaledBitmap(bitmap, imageWidth, imageHeight, false);

        invalidate();
    }
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {

            scaleFactor *= scaleGestureDetector.getScaleFactor();
            scaleFactor = Math.max(minZoom, Math.min(scaleFactor, maxZoom));

            invalidate();

            return true;
        }
    }
}
