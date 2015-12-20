package com.whexberg.ribbit;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.whexberg.ribbit.utils.ParseConstants;

/**
 * Created by william on 9/13/15.
 */
public class RibbitApplication extends Application {

    public static void updateParseInstallation(ParseUser user) {
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
        installation.saveInBackground();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this,
                "2nG5IRqFXyY6V1vB6EIvzTuUhBC5s7Dbau0z8pnA",
                "baiXT9pakYt4Pc2oNwumPfnIvLgKUzZ4obTTDV02");
        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}