package us.fetch321.firstlight

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Attribution activity
 */
internal class AttributionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = FirstLight.config ?: throw IllegalStateException("You did something wrong")
        setContentView(R.layout.fl_activity_attribution)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle(R.string.fl_attribution)
        toolbar.setNavigationIcon(R.drawable.fl_ic_close_white_24dp)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        val list: RecyclerView = findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(this)
        val adapter = AttributionAdapter()
        list.adapter = adapter
        adapter.setAttributions(config.attributions)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0, android.R.anim.fade_out)
    }
}