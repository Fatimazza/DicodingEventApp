package id.fatimazza.dicodingeventapp.ui.upcoming

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.*
import id.fatimazza.dicodingeventapp.data.response.ListEventsItem
import id.fatimazza.dicodingeventapp.databinding.ItemListEventsBinding

class UpcomingAdapter:
    ListAdapter<ListEventsItem, UpcomingAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val binding = ItemListEventsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        val event = getItem(position)
        holder.bind(event)
    }

    class ItemViewHolder(val binding: ItemListEventsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(events: ListEventsItem) {
            binding.tvEventTitle.text = "${events.name}"
            Glide.with(binding.root)
                .load(events.mediaCover)
                .into(binding.ivEventImage)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListEventsItem>(){
            override fun areItemsTheSame(
                oldItem: ListEventsItem,
                newItem: ListEventsItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ListEventsItem,
                newItem: ListEventsItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
