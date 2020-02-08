package us.fetch321.firstlight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {

        fun inflate(parent: ViewGroup): TitleViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fl_item_title, parent, false)
            return TitleViewHolder(view)
        }
    }

    private val textTitle: TextView = view.findViewById(R.id.fl_title)

    fun bind(title: Title) {
        textTitle.text = title.title
    }
}
