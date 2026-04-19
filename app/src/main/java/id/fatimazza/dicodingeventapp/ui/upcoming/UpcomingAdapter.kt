package id.fatimazza.dicodingeventapp.ui.upcoming

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.fatimazza.dicodingeventapp.data.response.ListEventsItem
import id.fatimazza.dicodingeventapp.databinding.ItemListEventsBinding

class UpcomingAdapter:
    ListAdapter<ListEventsItem, UpcomingAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    class ItemViewHolder(val binding: ItemListEventsBinding) : RecyclerView.ViewHolder(binding.root) {

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
