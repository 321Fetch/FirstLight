package us.fetch321.firstlight

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

/**
 * End credits
 */
object FirstLight {

    fun init(config: Config) {
        this.config = config
    }

    internal var config: Config? = null

    fun show(activity: Activity) {
        activity.startActivity(Intent(activity, FirstLightActivity::class.java))
        activity.overridePendingTransition(android.R.anim.fade_in, 0)
    }

    fun showAttribution(activity: Activity) {
        activity.startActivity(Intent(activity, AttributionActivity::class.java))
        activity.overridePendingTransition(android.R.anim.fade_in, 0)
    }

    /**
     * Configuration, to know what to show
     */
    class Config(
            context: Context
    ) {
        internal val appName: String = context.getString(R.string.app_name)
        internal val appUrl: String = "https://play.google.com/store/apps/details?id=${context.packageName}"
        internal val attributions = mutableListOf<Attribution>()

        fun addAttribution(attribution: Attribution): Config {
            attributions.add(attribution)
            return this
        }
    }
}