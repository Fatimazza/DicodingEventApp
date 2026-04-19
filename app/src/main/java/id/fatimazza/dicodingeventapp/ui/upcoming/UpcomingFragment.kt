package id.fatimazza.dicodingeventapp.ui.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.fatimazza.dicodingeventapp.data.response.ListEventsItem
import id.fatimazza.dicodingeventapp.databinding.FragmentUpcomingBinding

class UpcomingFragment : Fragment() {

    private var _binding: FragmentUpcomingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val upcomingViewModel =
            ViewModelProvider(this).get(UpcomingViewModel::class.java)

        _binding = FragmentUpcomingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupUpcomingEventList()

        upcomingViewModel.listUpcoming.observe(viewLifecycleOwner) { upcomingEvents ->
            setListEventsData(upcomingEvents)
        }

        upcomingViewModel.isLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }

        return root
    }

    private fun setupUpcomingEventList() {
        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvListUpcomingEvents.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(requireActivity(), layoutManager.orientation)
        binding.rvListUpcomingEvents.addItemDecoration(itemDecoration)
    }

    private fun setListEventsData(upcomingEvents: List<ListEventsItem>) {
        val adapter = UpcomingAdapter()
        adapter.submitList(upcomingEvents)
        binding.rvListUpcomingEvents.adapter = adapter
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
