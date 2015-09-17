package com.whexberg.ribbit;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by william on 9/13/15.
 */
public class RibbitApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this,
                "2nG5IRqFXyY6V1vB6EIvzTuUhBC5s7Dbau0z8pnA",
                "baiXT9pakYt4Pc2oNwumPfnIvLgKUzZ4obTTDV02");



    }
}
