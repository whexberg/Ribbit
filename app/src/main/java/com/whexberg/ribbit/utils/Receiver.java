package com.whexberg.ribbit.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;
import com.whexberg.ribbit.ui.MainActivity;

/**
 * Created by william on 12/19/15.
 */
public class Receiver extends ParsePushBroadcastReceiver {

    @Override
    public void onPushOpen(Context context, Intent intent) {
        Log.e("Push", "Clicked");
        Intent i = new Intent(context, MainActivity.class);
        i.putExtras(intent.getExtras());
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
