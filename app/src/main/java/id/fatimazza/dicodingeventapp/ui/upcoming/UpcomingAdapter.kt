package id.fatimazza.dicodingeventapp.ui.upcoming

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.fatimazza.dicodingeventapp.data.response.ListEventsItem
import id.fatimazza.dicodingeventapp.databinding.ItemListEventsBinding

class UpcomingAdapter: ListAdapter<ListEventsItem, UpcomingAdapter.ItemViewHolder> {
    
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
}
