package us.fetch321.firstlight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class AttributionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {

        fun inflate(parent: ViewGroup): AttributionViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fl_item_attribution, parent, false)
            return AttributionViewHolder(view)
        }
    }

    private val title: TextView = view.findViewById(R.id.fl_title)
    val buttonViewLicense: View = view.findViewById(R.id.fl_license)

    fun bind(attribution: Attribution) {
        title.text = attribution.title
    }
}
