package us.fetch321.twit.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import us.fetch321.firstlight.Attributions
import us.fetch321.firstlight.FirstLight

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val config = FirstLight.Config(this)
                .addAttribution(Attributions.AndroidX)
                .addAttribution(Attributions.Coil)
                .addAttribution(Attributions.Firebase)
                .addAttribution(Attributions.Kotlin)
                .addAttribution(Attributions.MaterialComponents)
                .addAttribution(Attributions.Timber)
                .addAttribution(Attributions.Roboto)

        FirstLight.init(config)
        toolbar.title = "First Light"

        buttonSeeFirstLight.setOnClickListener {
            FirstLight.show(this)
        }

        buttonSeeAttribution.setOnClickListener {
            FirstLight.showAttribution(this)
        }
    }
}