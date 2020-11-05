package com.sheltortoiseusa.asciicamera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyActivity extends Activity {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;

    private Bitmap photoCaptured;

    private TextView asciiImage;

    private Button asciiButton;
    private Button cameraButton;

    private ProgressBar asciiProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        asciiImage = (TextView) findViewById(R.id.textView1);

        cameraButton = (Button) findViewById(R.id.button1);
        asciiButton = (Button) findViewById(R.id.button2);
        asciiProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        asciiButton.setEnabled(false);

        asciiProgressBar.setAlpha(0);
    }
    public void toCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ImageView photoPreview = (ImageView) findViewById(R.id.imageView1);

        if(requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK) {
                Bundle extras = data.getExtras();

                photoCaptured = (Bitmap) extras.get("data");
                photoPreview.setImageBitmap(photoCaptured);

                asciiButton.setEnabled(true);
            }
            else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "result canceled", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "image capture failed", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void toAsciiConversion(View view) {
        new PerformAsyncTask().execute();
    }
    private class PerformAsyncTask extends AsyncTask<Void, Void, Void> {
        String asciiArtWork;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            cameraButton.setEnabled(false);
            asciiButton.setEnabled(false);

            asciiProgressBar.setAlpha(1);

            asciiArtWork = "\n";
        }
        @Override
        protected Void doInBackground(Void... params) {
            Bitmap photoThumbnail = photoCaptured;

            int thumbnailWidth = photoThumbnail.getWidth();
            int thumbnailHeight = photoThumbnail.getHeight();

            int scaleWidth = 2;
            int scaleHeight = 2;

            for(int y = 0; y < thumbnailHeight / scaleHeight; y++) {
                for(int x = 0; x < thumbnailWidth / scaleWidth; x++) {
                    int pixel = photoThumbnail.getPixel(x * scaleWidth, y * scaleHeight);

                    int redVal = Color.red(pixel);
                    int greenVal = Color.green(pixel);
                    int blueVal = Color.blue(pixel);

                    int grayVal = (redVal + greenVal + blueVal) / 3;

                    if(grayVal < 52) {
                        asciiArtWork += "MM";
                    }
                    else if(grayVal <= 52) {
                        asciiArtWork += "$$";
                    }
                    else if(grayVal <= 69) {
                        asciiArtWork += "##";
                    }
                    else if(grayVal <= 103) {
                        asciiArtWork += "**";
                    }
                    else if(grayVal <= 120) {
                        asciiArtWork += "++";
                    }
                    else if(grayVal <= 137) {
                        asciiArtWork += "vV";
                    }
                    else if(grayVal <= 154) {
                        asciiArtWork += "-;";
                    }
                    else if(grayVal <= 171) {
                        asciiArtWork += "--";
                    }
                    else if(grayVal <= 188) {
                        asciiArtWork += ";;";
                    }
                    else if(grayVal <= 205) {
                        asciiArtWork += "::";
                    }
                    else if(grayVal <= 222) {
                        asciiArtWork += "..";
                    }
                    else {
                        asciiArtWork += "  ";
                    }
                }
                asciiArtWork += "\n";
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            cameraButton.setEnabled(true);
            asciiButton.setEnabled(true);

            asciiProgressBar.setAlpha(0);

            asciiImage.setText(asciiArtWork);
        }
    }
    public void takeScreenSnapshot() {
        Bitmap bitmap = loadBitmapFromView(this, asciiImage);
        String mPath = Environment.getExternalStorageState() + File.separator + "screen_" + System.currentTimeMillis() + ".jpeg";

        File imageFile = new File(mPath);
        OutputStream fileOut = null;

        try {
            fileOut = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOut);
            fileOut.flush();
            fileOut.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static Bitmap loadBitmapFromView(Context context, View view) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();

        view.measure(View.MeasureSpec.makeMeasureSpec(dm.widthPixels, View.MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(dm.heightPixels, View.MeasureSpec.EXACTLY));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        Bitmap returnedBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas c = new Canvas(returnedBitmap);
        view.draw(c);

        return returnedBitmap;
    }
}
