package us.fetch321.firstlight

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

internal class FirstLightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = FirstLight.config ?: throw IllegalStateException("You did something wrong")
        setContentView(R.layout.fl_activity_first_light)
        findViewById<View>(R.id.root).setOnClickListener { onBackPressed() }
        findViewById<View>(R.id.tweet).setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, config.appName)
            shareIntent.putExtra(Intent.EXTRA_TEXT, config.appUrl)
            startActivity(Intent.createChooser(shareIntent, getString(R.string.fl_share_this_app)))
        }
        findViewById<View>(R.id.twits).setOnClickListener {
            Utils.visitUrl(this, "https://twitter.com/321Fetch")
        }
        val attributionButton = findViewById<View>(R.id.attribution)
        if (config.attributions.isEmpty()) {
            attributionButton.visibility = View.GONE
        }
        attributionButton.setOnClickListener {
            FirstLight.showAttribution(this)
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0, android.R.anim.fade_out)
    }
}