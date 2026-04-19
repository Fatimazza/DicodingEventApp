package id.fatimazza.dicodingeventapp.ui.upcoming

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.fatimazza.dicodingeventapp.data.response.ListEventsItem
import id.fatimazza.dicodingeventapp.databinding.ItemListEventsBinding

class UpcomingAdapter: ListAdapter<ListEventsItem, UpcomingAdapter.ItemViewHolder> {

    class ItemViewHolder(val binding: ItemListEventsBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}
