package com.whexberg.ribbit.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.whexberg.ribbit.R;

import java.util.Timer;
import java.util.TimerTask;

public class ViewImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Uri imageUri = getIntent().getData();

        Picasso.with(this).load(imageUri.toString()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 10000);
            }

            @Override
            public void onError() {

            }
        });

//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                finish();
//            }
//        }, 10000);
    }

//    public static class ImageHandler {
//        private static Picasso instance;
//
//        public static Picasso getSharedInstance(Context mContext) {
//            if(instance == null )
//            {
//                instance = new Picasso
//                        .Builder(mContext)
//                        .executor(Executors.newSingleThreadExecutor())
//                        .memoryCache(Cache.NONE)
//                        .indicatorsEnabled(true)
//                        .build();
//            }
//            return instance;
//        }
//    }

}
