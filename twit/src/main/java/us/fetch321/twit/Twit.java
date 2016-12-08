package us.fetch321.twit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;

/**
 * twit
 */
public class Twit {

    static String APP_URL;
    static String APP_NAME;

    public static void add(Toolbar toolbar) {
        toolbar.inflateMenu(R.menu.menu_twit);
    }

    public static void show(Activity activity, String appName, String appUrl){
        APP_URL = appUrl;
        APP_NAME = appName;
        activity.startActivity(new Intent(activity, TwitActivity.class));
        activity.overridePendingTransition(android.R.anim.fade_in, 0);
    }
}
