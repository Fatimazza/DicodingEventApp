package id.fatimazza.dicodingeventapp.ui.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.fatimazza.dicodingeventapp.data.response.EventResponse
import id.fatimazza.dicodingeventapp.data.response.ListEventsItem
import id.fatimazza.dicodingeventapp.data.retrofit.ApiConfig
import retrofit2.Callback

class UpcomingViewModel : ViewModel() {

    companion object {
        private const val TAG = "UpcomingViewModel"
        private const val IS_EVENT_ACTIVE = 1
    }

    private val _listUpcoming = MutableLiveData<List<ListEventsItem>>()
    val listUpcoming: LiveData<List<ListEventsItem>> = _listUpcoming

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getUpcomingEvents()
    }

    private fun getUpcomingEvents() {
        val client = ApiConfig.getApiService().getEvents(IS_EVENT_ACTIVE)
        client.enqueue(object : Callback<EventResponse> {

        })
    }
}
