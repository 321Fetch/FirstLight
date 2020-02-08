package us.fetch321.firstlight

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Shows all the attribution
 */
internal class AttributionAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_TITLE = 0
        private const val VIEW_TYPE_ATTRIBUTION = 1
    }

    private val items = mutableListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        VIEW_TYPE_TITLE -> {
            TitleViewHolder.inflate(parent)
        }
        VIEW_TYPE_ATTRIBUTION -> {
            val holder = AttributionViewHolder.inflate(parent)
            holder.buttonViewLicense.setOnClickListener {
                val attribution = items[holder.adapterPosition] as Attribution
                Utils.visitUrl(holder.itemView.context, attribution.licenseLink)
            }
            holder
        }
        else -> throw IllegalStateException("Something is wrong")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> {
                val title = items[position] as Title
                holder.bind(title)
            }
            is AttributionViewHolder -> {
                val attribution = items[position] as Attribution
                holder.bind(attribution)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Title -> VIEW_TYPE_TITLE
            is Attribution -> VIEW_TYPE_ATTRIBUTION
            else -> throw IllegalStateException("no")
        }
    }

    fun setAttributions(attributions: List<Attribution>) {
        items.clear()
        addAllForCategory(attributions, Attribution.Type.CODE)
        addAllForCategory(attributions, Attribution.Type.FONT)
        addAllForCategory(attributions, Attribution.Type.IMAGE)
        addAllForCategory(attributions, Attribution.Type.VIDEO)
        notifyDataSetChanged()
    }

    private fun addAllForCategory(allAttributions: List<Attribution>, type: Attribution.Type) {
        val attributions = allAttributions.filter { it.type == type }
        if (attributions.isNotEmpty()) {
            items.add(Title(type.title))
        }
        items.addAll(attributions.sortedBy { it.title })
    }
}
